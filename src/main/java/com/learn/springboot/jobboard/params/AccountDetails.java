package com.learn.springboot.jobboard.params;
import com.learn.springboot.jobboard.schema.User;

public class AccountDetails {

    private String modifiedAt;

    private User log;

    private String modified;

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

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "AccountDetails [modifiedAt=" + modifiedAt + ", log=" + log.toString() + ", modified=" + modified + "]";
    }
}
