package com.learn.springboot.jobboard.schema;

import java.util.ArrayList;

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
    private ArrayList<AccountDetails> logs;
}