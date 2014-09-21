package com.td.util;

import com.td.constants.StoreConstants;
import com.td.util.md5.MD5;
import net.sourceforge.stripes.action.ActionBeanContext;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.zip.Adler32;
import java.util.zip.CRC32;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 4:29 PM
 */
public class BaseUtils {

  public static String newline = System.getProperty("line.separator");
  public static String fileSeparator = System.getProperty("file.separator");


  public static String md5Hash(String string, String salt, int hashIterations) {
    return new Md5Hash(string, salt, hashIterations).toBase64();
  }

  public static String passwordEncrypt(String password) {
    return new Md5Hash(password, StoreConstants.DEFAULT_PASSWORD_SALT, StoreConstants.DEFAULT_HASH_ITERATIONS).toBase64();
  }

  public static String passwordEncryptPools(String password) {
    return new Sha256Hash(password, "vljo4lsa0zx;32", 1).toBase64();
  }

  public static String getMD5Checksum(String str) {
    MD5 md5 = new MD5();
    try {
      md5.Update(str, null);
    } catch (UnsupportedEncodingException e) {
    }
    return md5.asHex();
  }


  public static String getAdler32Checksum(String str) {
    Adler32 adl = new Adler32();
    adl.update(str.getBytes());
    return String.valueOf(adl.getValue());
  }

  public static Timestamp getCurrentTimestamp() {
    return new Timestamp(System.currentTimeMillis());
  }

  public static Long copyFile(File srcFile, File destFile, boolean verify)
      throws IOException {
    if (srcFile.getAbsolutePath().equals(destFile.getAbsolutePath())) {
      return null;
    }
    File destDir = destFile.getParentFile();
    destDir.mkdirs();
    InputStream in = new FileInputStream(srcFile);
    OutputStream out = new FileOutputStream(destFile);
    CRC32 checksum = null;
    if (verify) {
      checksum = new CRC32();
      checksum.reset();
    }
    byte[] buffer = new byte[32768];
    int bytesRead;
    while ((bytesRead = in.read(buffer)) >= 0) {
      if (verify) {
        checksum.update(buffer, 0, bytesRead);
      }
      out.write(buffer, 0, bytesRead);
    }
    out.close();
    in.close();
    if (verify) {
      return checksum.getValue();
    } else {
      return null;
    }
  }


  public static String getFilenameWithoutExtension(String filename) {
    String extension = getFileExtension(filename);
    if (extension.length() > 0) {
      filename = filename.substring(0, filename.length() - extension.length() - 1);
    }
    return filename;
  }

  public static String getFileExtension(String filename) {
    String extension = "";
    Pattern pattern = Pattern.compile("(?<=\\.)[a-zA-Z0-9]+$");
    Matcher matcher = pattern.matcher(filename);
    while (matcher.find()) {
      extension = matcher.group();
    }
    return extension;
  }

  public static String changeFileExt(String filename, String ext) {
    return filename.substring(0, filename.lastIndexOf(".") + 1) + ext;
  }

  public static String getRandomString(int length) {
    char[] pw = new char[length];
    int c = 'A';
    int r1 = 0;
    for (int i = 0; i < length; i++) {
      r1 = (int) (Math.random() * 3);
      switch (r1) {
        case 0:
          c = '0' + (int) (Math.random() * 10);
          break;
        case 1:
          c = 'a' + (int) (Math.random() * 26);
          break;
        case 2:
          c = 'A' + (int) (Math.random() * 26);
          break;
      }
      pw[i] = (char) c;
    }
    return new String(pw);
  }

  public static String getRandomStringTypable(int length) {
    char[] pw = new char[length];
    int c = 'A';
    int r1 = 0;
    for (int i = 0; i < length; i++) {
      r1 = (int) (Math.random() * 2);
      switch (r1) {
        case 0:
          c = '0' + (int) (Math.random() * 10);
          break;
        case 1:
          c = 'A' + (int) (Math.random() * 26);
          break;
      }
      if ('O' == c || '0' == c || 'I' == c) {
        c = 'P';
      }
      pw[i] = (char) c;
    }
    return new String(pw);
  }

  public static String getRandomNumber(int length) {
    char[] pw = new char[length];
    int c = '0';
    for (int i = 0; i < length; i++) {
      c = '0' + (int) (Math.random() * 10);
      pw[i] = (char) c;
    }
    return new String(pw);
  }


  public static void outputPrettyXml(java.io.OutputStream outputStream, Document document) {
    XMLWriter xmlWriter = null;
    try {
      OutputFormat outputFormat = OutputFormat.createPrettyPrint();
      xmlWriter = new XMLWriter(outputStream, outputFormat);
      xmlWriter.write(document);
    } catch (IOException e) {
    }
  }

  public static void outputPrettyXmlToSystemOut(Document document) {
    outputPrettyXml(System.out, document);
  }

  // Deletes all files and subdirectories under dir.
  // Returns true if all deletions were successful.
  // If a deletion fails, the method stops attempting to delete and returns false.
  public static boolean deleteDir(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (String child : children) {
        boolean success = deleteDir(new File(dir, child));
        if (!success) {
          return false;
        }
      }
    }
    // The directory is now empty so delete it
    return dir.delete();
  }

  public static boolean doubleEquality(double d1, double d2) {
    return (Math.abs(d2 - d1) < .005D);
  }

  /**
   * "Splice" means the place where two ends have been joined or to stick together
   * <p/>
   * This method will take a list of strings and join together with the second string between them.
   *
   * @return String
   */
  public static String splice(List<String> items, String joiner) {
    String joinedString = "";
    for (String item : items) {
      joinedString += item + joiner;
    }
    return joinedString.substring(0, joinedString.lastIndexOf(joiner));
  }

  public static Set<String> split(String str, String delimiterRegex) {
    if (str == null) return null;
    Set<String> set = new HashSet<String>();
    if (delimiterRegex == null) {
      set.add(str);
      return set;
    }
    String[] strings = str.split(delimiterRegex);
    for (String string : strings) {
      set.add(string.trim());
    }
    return set;
  }


  public static Timestamp getFutureTimestamp(long t) {
    return new Timestamp(System.currentTimeMillis() + t);
  }

  public static Timestamp getPastTimestamp(long t) {
    return new Timestamp(System.currentTimeMillis() - t);
  }


  public static boolean compareObjects(Object object1, Object object2) {
    if (object1 != null && object2 != null) {
      if (object1.getClass() != object2.getClass()) {
        throw new RuntimeException("objects must belong to same class");
      }
    }
    if (object1 != null) {
      return object1.equals(object2);
    } else if (object2 != null) {
      return object2.equals(object1);
    }
    return true;
  }

  public static boolean isValidEmail(String email) {
    try {
      String emailRegEx = "^([A-Za-z0-9_%+-]\\.?)+@([A-Za-z0-9-]\\.?)*[A-Za-z0-9-]+\\.[A-Za-z]{2,4}$";
      Pattern p = Pattern.compile(emailRegEx);
      Matcher m = p.matcher(email);

      if (!m.find()) {
        return false;
      }
    } catch (PatternSyntaxException e) {
      return false;
    }
    return true;
  }

  public static Cookie getCookie(HttpServletRequest request, String cookieKey) {
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        if (cookie.getName() != null && cookie.getName().equals(cookieKey)) return cookie;
      }
    }
    return null;
  }

  /**
   * Returns a Map of parameter and its values from a queryParam like string
   *
   * @param queryParams
   * @return
   * @throws UnsupportedEncodingException
   */
  public static Map<String, List<String>> getQueryParamMap(String queryParams) {
    Map<String, List<String>> params = new HashMap<String, List<String>>();
    try {
      if (queryParams != null) {
        for (String param : queryParams.split("&")) {
          String[] pair = param.split("=");
          String key = URLDecoder.decode(pair[0], "UTF-8");
          String value = URLDecoder.decode(pair[1], "UTF-8");
          List<String> values = params.get(key);
          if (values == null) {
            values = new ArrayList<String>();

            params.put(key, values);
          }
          values.add(value);
        }
      }
    } catch (UnsupportedEncodingException e) {
      // do nothing
    }
    return params;
  }


  public static float roundTwoDecimals(float d) {
    DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Float.valueOf(twoDForm.format(d));
  }

  public static Double roundTwoDecimalsDouble(Double d) {
    DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
  }


  public static String getRemoteIpAddrForUser(ActionBeanContext context) {
    String ipAddr = null;

    if (context != null && context.getRequest() != null) {
      ipAddr = context.getRequest().getRemoteAddr();
    }
    return ipAddr;
  }

  public static Boolean remoteFileExists(String linkValue) throws IOException {
    Integer pageNotFoundErrorCode = 404;
    URL url = new URL(linkValue);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();
    int code = connection.getResponseCode();
    connection.disconnect();
    return (code != pageNotFoundErrorCode);
  }

  public static String getCommaSeparatedString(String[] list) {
    String commaSeparatedString = "";
    for (String s : list) {
      commaSeparatedString += s + "','";
    }
    return commaSeparatedString.substring(0, commaSeparatedString.lastIndexOf(",") - 1);
  }

  public static Set<String> getLowerCaseStringSet(List<String> list) {
    Set<String> set = new HashSet<String>();
    for (String s : list) {
      set.add(s.toLowerCase());
    }
    return set;
  }

  public Map<String, Object> addParameter(Map<String, Object> parameters, String name, Object... values) {
    if (parameters.containsKey(name)) {
      Object[] src = (Object[]) parameters.get(name);
      Object[] dst = new Object[src.length + values.length];
      System.arraycopy(src, 0, dst, 0, src.length);
      System.arraycopy(values, 0, dst, src.length, values.length);
      parameters.put(name, dst);
    } else {
      parameters.put(name, values);
    }
    return parameters;
  }
}
