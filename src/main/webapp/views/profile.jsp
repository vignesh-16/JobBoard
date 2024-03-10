<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> 
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Profile</title>
    <!-- Font Awesome Icons -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
    />
    <!-- Google Fonts  -->
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap"
      rel="stylesheet"
    />
    <!-- Stylesheet -->
    <link rel="stylesheet" href="../styles/profileview.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Script -->
    <!-- <script src="../js/home.js"></script> -->
    <script src="../js/utility.js"></script>
</head>
<body>
    <div class="container">
      <input type="file" id="file-input"/>
        <label for="file-input">
            <i class="fa-solid fa-arrow-up-from-bracket"></i>
            Upload resume
        </label>
      <div id="num-of-files">No Files Choosen</div>
      <ul id="files-list"></ul>
    </div>
</body>
</html>