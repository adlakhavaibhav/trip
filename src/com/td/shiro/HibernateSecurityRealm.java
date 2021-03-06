package com.td.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 8:13 AM
 */
public class HibernateSecurityRealm extends AuthorizingRealm {
    public static String realmName      = "DefaultHibernateRealmName";
    public static String passwordSalt   = "";
    public static int    hashIterations = 1;

    public HibernateSecurityRealm() {
        super();
    }

    @Autowired
    private UserSecurityManager userSecurityManager;

    @Override
    public String getName() {
        return realmName;
    }

    @Override
    public CacheManager getCacheManager() {
        return null;
    }

    @Override
    public Cache getAuthorizationCache() {
        return null;
    }

    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        SecurityCredentialsMatcher credentialsMatcher = new SecurityCredentialsMatcher();
        credentialsMatcher.setHashSalted(true);
        credentialsMatcher.setStoredCredentialsHexEncoded(false);
        credentialsMatcher.setHashIterations(hashIterations);
        return credentialsMatcher;
    }

    class SecurityCredentialsMatcher extends Md5CredentialsMatcher {
        protected Object getSalt(AuthenticationToken token) {
            return passwordSalt;
        }
    }

    public HibernateSecurityRealm(UserSecurityManager userSecurityManager) {
        this.userSecurityManager = userSecurityManager;
    }

    //private static final Log log                      = LogFactory.getLog(HibernateSecurityRealm.class);

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/
    protected boolean        permissionsLookupEnabled = false;

    /**
     * Enables lookup of permissions during authorization. The default is "false" - meaning that only roles are
     * associated with a user. Set this to true in order to lookup roles <b>and</b> permissions.
     *
     * @param permissionsLookupEnabled true if permissions should be looked up during authorization, or false if only
     *            roles should be looked up.
     */
    public void setPermissionsLookupEnabled(boolean permissionsLookupEnabled) {
        this.permissionsLookupEnabled = permissionsLookupEnabled;
    }

    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        String password = userSecurityManager.getPasswordForUser(username);
        Principal principal = userSecurityManager.getPrincipal(username);
        if (password == null) {
            throw new UnknownAccountException("No account found for user [" + username + "]");
        }
        return buildAuthenticationInfo(principal, password.toCharArray());
    }

    protected AuthenticationInfo buildAuthenticationInfo(Principal principal, char[] password) {
        return new SimpleAuthenticationInfo(principal, password, getName());
    }

    /**
     * This implementation of the interface expects the principals collection to return a String username keyed off of
     * this realm's {@link #getName() name}
     *
     * @see AuthorizingRealm#getAuthorizationInfo(PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        // null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        Principal userPrincipal = (Principal) principals.fromRealm(getName()).iterator().next();

        // Retrieve roles and permissions from database
        Set<String> roleNames = userSecurityManager.getRoleNamesForUser(userPrincipal);
        Set<String> permissions = userSecurityManager.getPermissions(userPrincipal, roleNames);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

}