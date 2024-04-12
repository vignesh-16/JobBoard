<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> 
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create Job Post</title>
    <link rel="stylesheet" href="../../styles/jobshome.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../../js/jobs/createjobposts.js"></script>
    <script src="../../js/utility.js"></script>
</head>
<body>
    <div class="post-create-container">
        <form id="jobcreater">
            <label for="jobTitle">Job title: </label>
            <input type="text" id="title" name="jobTitle">
            <!-- TO DO : Company name should be automatically fetched from user details -->
            <label for="advertiser">Company name:</label>
            <input type="text" id="advertiser" name="advertiser">

            <label for="location">Job location:</label>
            <input type="text" id="location" name="location">

            <label for="salary">Salary:</label>
            <input type="text" id="salary" name="salary">

            <label for="job-type">Job type:</label>
            <input type="text" id="job-type" name="job-type">

            <label for="jobrequirements">Requirements:</label>
            <textarea id="job-requirements" name="jobrequirements"></textarea>

            <label for="apply-mode">Apply mode:</label>
            <input type="text" id="apply-mode" name="apply-mode">

            <label for="description">Job Description:</label>
            <textarea id="description" name="description"></textarea>

            <button type="submit">Create Job</button>
        </form>
    </div>
</body>
</html>