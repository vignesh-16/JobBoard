package com.learn.springboot.jobboard.params;
import com.learn.springboot.jobboard.schema.User;

public class AccountDetails {

    private String modifiedAt;

    private User log;

    private String modifiedField;

    private String logType;

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public User getLog() {
        return log;
    }

    public void setLog(User log) {
        this.log = log;
    }

    public String getModifiedField() {
        return modifiedField;
    }

    public void setModifiedField(String modifiedField) {
        this.modifiedField = modifiedField;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "AccountDetails [modifiedAt=" + modifiedAt + ", log=" + log.toString() + ", modifiedField=" + modifiedField
                + ", logType=" + logType + "]";
    }

}
