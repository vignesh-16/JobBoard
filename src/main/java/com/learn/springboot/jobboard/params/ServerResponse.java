package com.learn.springboot.jobboard.params;

import org.springframework.web.servlet.ModelAndView;

public class ServerResponse {
    private int statusCode;
    private String statusMessage;
    private String data;
    private ModelAndView view;
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
    public ModelAndView getView() {
        return view;
    }
    public void setView(ModelAndView view) {
        this.view = view;
    }
    @Override
    public String toString() {
        return "ServerResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", data=" + data
                + ", view=" + view + "]";
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
    public ServerResponse(int statusCode, String statusMessage, ModelAndView view) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.view = view;
    }
}
