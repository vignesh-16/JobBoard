package com.learn.springboot.jobboard.schema;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "jobPosts")
public class JobPost {
    @Id
    private String id;

    @Field("jobTitle")
    private String jobTitle;

    @Field("advertiser")
    private String advertiser;

    @Field("location")
    private String location;

    @Field("salary")
    private String salary;

    @Field("jobType")
    private String jobType;

    @Field("mode")
    private String mode;

    @Field("description")
    private String description;

    @Field("dateposted")
    private String dateposted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(String advertiser) {
        this.advertiser = advertiser;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateposted() {
        return dateposted;
    }

    public void setDateposted(String dateposted) {
        this.dateposted = dateposted;
    }

    @Override
    public String toString() {
        return "JobPost [id=" + id + ", jobTitle=" + jobTitle + ", advertiser=" + advertiser + ", location=" + location
                + ", salary=" + salary + ", jobType=" + jobType + ", mode=" + mode + ", description=" + description
                + ", dateposted=" + dateposted + "]";
    }
}
