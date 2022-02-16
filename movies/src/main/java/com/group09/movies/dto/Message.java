package com.group09.movies.dto;

public class Message {

    private Object message;
    private String status;


    public Message(Object message){
        this.status="0";
        this.message=message;
    }


    public Message(Object message, String status){
        this.status=status;
        this.message=message;
    }

    public Object getMessage() {
        return message;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return this.status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
