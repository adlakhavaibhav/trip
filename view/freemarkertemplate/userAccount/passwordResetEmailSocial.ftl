Reset Password Instructions - HealthKart.com
<html>
<head>
  <title>Reset Password Instructions - HealthKart.com</title>
</head>
<body>
<#include "/includes/header.ftl">
<p>Hi ${user.name},</p>

<p style="margin-bottom:1em">Welcome to Healthkart.com</p>

<p>Your Username (Same as your Email Id): <a href="#">${user.login}</a></p>

<p>Please click the below link to set a new password: </p>

<p><a href="${link}" target="_blank">${link}</a></p>

<p>This will ask for new password which you can then use to login.</p>

<p>Once you set up this password, you can continue using your ${provider} login as well.</p>

<p>Note: If you are not able to click on the link, you can paste the above address into your browser.</p>

<p>Happy Shopping!</p>

<p><strong>HealthKart.com</strong></p>
<#include "/includes/footer.ftl">
</body>
</html>