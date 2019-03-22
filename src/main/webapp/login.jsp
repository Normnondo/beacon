<!doctype html>
<html lang="en">

<!--
    Created by Norm Nondorf
    Date: 3/17/19

<%@ page contentType="text/html;charset=UTF-8" language="java" %> -->

<head>
    <title>Beacon Login</title>


    <link rel="icon" href="favicon.ico" type="image/x-icon" />
    <title>Beacon</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>

<h2>Not a member yet?</h2>
<a href="enterInfo.jsp" class="btn btn-primary">Create Account</a>

<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>E-mail address: <INPUT TYPE="TEXT" NAME="j_username"><!--</TD></TR>-->
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password"><!--</TD></TR>-->
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In"><!--</TH></TR>-->
    </TABLE>
</FORM>
<!-- if login successful should go to gameSearch.jsp -->
</body>
</html>