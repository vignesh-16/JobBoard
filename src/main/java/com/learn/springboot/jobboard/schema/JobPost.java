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

    @Field("aboutadvertiser")
    private String aboutadvertiser;

    @Field("location")
    private String location;

    @Field("jobrequirements")
    private String jobrequirements;

    @Field("salary")
    private String salary;

    @Field("jobType")
    private String jobType;

    @Field("mode")
    private String mode;

    @Field("description")
    private String description;

    @Field("field")
    private String field;

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

    public String getAboutadvertiser() {
        return aboutadvertiser;
    }

    public void setAboutadvertiser(String aboutadvertiser) {
        this.aboutadvertiser = aboutadvertiser;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobrequirements() {
        return jobrequirements;
    }

    public void setJobrequirements(String jobrequirements) {
        this.jobrequirements = jobrequirements;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDateposted() {
        return dateposted;
    }

    public void setDateposted(String dateposted) {
        this.dateposted = dateposted;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", jobTitle=" + jobTitle + ", advertiser=" + advertiser + ", aboutadvertiser="
                + aboutadvertiser + ", location=" + location + ", jobrequirements=" + jobrequirements + ", salary="
                + salary + ", jobType=" + jobType + ", mode=" + mode + ", description=" + description + ", field="
                + field + ", dateposted=" + dateposted + "}";
    }

}