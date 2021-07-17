package com.example.demo.exception;




public class BadRequestException extends RuntimeException {

    private String message;

    private Object detail;


    public BadRequestException(String message, Object detail){
        this.message=message;
        this.detail=detail;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
