<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> 
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="../styles/home.css">
</head>
<body>
    <div class="home-page-container">
        <div class="log-in-section">
            <div class="username-email-container">
                <label>User Id:</label>
                <input type="text" placeholder="username or email address">
            </div>
            <div class="password-container">
                <label>Password:</label>
                <input type="password" placeholder="enter your password">
            </div>
            <button class="js-sign-in">Log in</button>
            <button class="js-forgot-password">Forgot password?</button>
        </div>
        <div class="sign-up-section">
            <div class="new-user-firstname">
                <label>First name:</label>
                <input type="text" placeholder="enter first name">
            </div>
            <div class="new-user-lastname">
                <label>Last name:</label>
                <input type="text" placeholder="enter last/family name">
            </div>
            <div class="new-user-email">
                <label>Email address:</label> 
                <input type="email" placeholder="your email address">
            </div>
            <div class="new-user-password pass-one">
                <label>Create a password:</label>
                <input type="password">
            </div>
            <div class="new-user-password pass-two">
                <label>Confirm password:</label>
                <input type="password">
            </div>
            <button class="js-sign-up">Sign up</button>
        </div>
    </div>
</body>
</html>