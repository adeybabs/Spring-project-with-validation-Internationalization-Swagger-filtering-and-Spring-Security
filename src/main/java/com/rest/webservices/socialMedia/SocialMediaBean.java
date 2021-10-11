package com.rest.webservices.socialMedia;

public class SocialMediaBean {

    private String message;

    public SocialMediaBean(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SocialMediaBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
