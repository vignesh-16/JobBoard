<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> 
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Job Results</title>
    <link rel="stylesheet" href="../../styles/jobshome.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <section class="jobs-list-container">
        <div class="job-post-container">
            <div class="job-title-options-container">
                <span class="job-title-space">Job title</span>
                <span class="options-space">:</span>
            </div>
            <div class="job-poster-details-container">
                <span class="company-name-space">Company name</span>
                <span class="job-location-space">Job location</span>
            </div>
            <div class="salary-jobtype-container">
                <span class="salary-details-space">Salary range</span>
                <span class="job-type-shift-space">Job type</span>
            </div>
            <div class="apply-mode-container">
                <span class="apply-mode-space">Apply mode</span>
            </div>
            <div class="job-description-container">
                <ul>
                    <li>
                        Job description points
                    </li>
                </ul>
            </div>
        </div>
    </section>
</body>
</html>