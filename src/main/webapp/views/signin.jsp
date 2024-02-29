<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> 
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel='stylesheet' href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Poppins&amp;display=swap'>
    <link rel="stylesheet" href="../styles/siginin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../JS/signin.js"></script>
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
        <!-- Sign up section starts here... -->
        <div class="sign-up-section sign-up-box disabled">
            <div class="new-user-firstname space">
                <label>First name:</label>
                <input type="text" name="fname" placeholder="enter first name">
            </div>
            <div class="new-user-lastname space">
                <label>Last name:</label>
                <input type="text" name="lname" placeholder="enter last/family name">
            </div>
            <div class="new-user-email space">
                <label>Email address:</label> 
                <input type="email" name="mail" placeholder="your email address">
            </div>
            <div class="user-account-type space">
                <label>Account type:</label> 
                <select name="account-type">
                    <optgroup label="Select your account type">
                        <option value="recruiter">Recruiter</option>
                        <option value="candidate">Candidate</option>
                    </optgroup>
                </select>
            </div>
            <div class="new-user-password pass-one space">
                <label>Choose a password:</label>
                <input type="password" name="password1" placeholder="choose a password">
            </div>
            <div class="new-user-password pass-two space">
                <label>Confirm password:</label>
                <input type="password" name="password2" placeholder="confirm your password">
            </div>
            <div class="create-new-user space">
                <button class="js-create-account">Create Account</button>
            </div>
        </div>
    </div>
</body>
</html>