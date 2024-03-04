<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> 
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Welcome</title>
        <link rel='stylesheet' href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Poppins&amp;display=swap'>
        <link rel="stylesheet" href="../styles/siginin.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="../js/signin.js"></script>
    </head>
    <body>
        <div class="landing-page-container">
            <div class="wrapper">
                <div class="login_box log-in-section">
                <div class="login-header">
                    <span>Login</span>
                </div>
            
                <div class="input_box">
                    <input type="text" id="user" name="userid" class="input-field" required>
                    <label for="user" class="label">Username</label>
                    <i class="bx bx-user icon"></i>
                </div>
            
                <div class="input_box">
                    <input type="password" id="pass" name="userpass" class="input-field" required>
                    <label for="pass" class="label">Password</label>
                    <i class="bx bx-lock-alt icon"></i>
                </div>
            
                <div class="remember-forgot">
                    <div class="remember-me">
                        <input type="checkbox" id="remember">
                        <label for="remember">Remember me</label>
                    </div>
            
                    <div class="forgot">
                        <a href="#">Forgot password?</a>
                    </div>
                </div>
            
                <div class="input_box">
                    <input type="submit" class="input-submit js-log-in" value="Login">
                </div>
            
                <div class="register js-sign-up">
                    <span>Don't have an account? <a href="#">Register</a></span>
                </div>
                </div>
            </div>
        </div>
    </body>
</html>