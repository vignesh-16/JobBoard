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
        <script src="../JS/signup.js"></script>
    </head>
    <body>
        <div class="landing-page-container"> 
            <!-- Sign up section starts here... -->
            <div class="sign-up-section sign-up-box">
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