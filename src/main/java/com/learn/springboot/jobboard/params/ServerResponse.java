package com.learn.springboot.jobboard.params;

public class ServerResponse {
    private int statusCode;
    private String statusMessage;
    private String data;
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "ServerResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", data=" + data + "]";
    }
    public ServerResponse(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
    public ServerResponse(int statusCode, String statusMessage, String data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }
}
