package com.learn.springboot.jobboard.schema;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.learn.springboot.jobboard.params.AccountDetails;

@Document(collection = "useraccounthistory")
public class UserAccountHistory {
    @Id
    private String id;
    @Field("forUserId")
    private String forUserId;
    @Field("logs")
    private ArrayList<AccountDetails> logs = new ArrayList<>();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getForUserId() {
        return forUserId;
    }
    public void setForUserId(String forUserId) {
        this.forUserId = forUserId;
    }
    public List<AccountDetails> getLogs() {
        return logs;
    }
    public void setLogs(AccountDetails logs) {
        this.logs.add(logs);
    }
    @Override
    public String toString() {
        return "UserAccountHistory [id=" + id + ", forUserId=" + forUserId + ", logs=" + logs.size() + "]";
    }
}