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
        <script src="../js/signup.js"></script>
    </head>
    <body>
        <div class="wrapper landing-page-container"> 
            <!-- Sign up section starts here... -->
            <div class="sign-up-section sign-up-box">
                <div class="input_box new-user-firstname space">
                    <label>First name:</label>
                    <input class="input-field" type="text" name="fname" placeholder="enter first name">
                </div>
                <div class="input_box new-user-lastname space">
                    <label>Last name:</label>
                    <input class="input-field" type="text" name="lname" placeholder="enter last/family name">
                </div>
                <div class="input_box new-user-email space">
                    <label>Email address:</label> 
                    <input class="input-field" type="email" name="mail" placeholder="your email address">
                </div>
                <div class="input_box custom-select user-account-type space">
                    <label>Account type:</label> 
                    <select name="account-type">
                        <option value="">Account type</option>
                        <option value="candidate"><label class="label">Candidate</label></option>
                        <option value="recruiter"><label class="label">Recruiter</label></option>
                    </select>
                </div>
                <div class="input_box new-user-password pass-one space">
                    <label>Choose a password:</label>
                    <input class="input-field" type="password" name="password1" placeholder="choose a password">
                </div>
                <div class="input_box new-user-password pass-two space">
                    <label>Confirm password:</label>
                    <input class="input-field" type="password" name="password2" placeholder="confirm your password">
                </div>
                <div class="input_box create-new-user space">
                    <button class="input-submit js-create-account">Create Account</button>
                </div>
            </div>
        </div>
    </body>
</html>