package com.cy.vo;

import java.io.Serializable;

public class JsonResult implements Serializable {

    private static final long serialVersionUID = 6782563694122672181L;

    private Integer state = 1;

    private String message = "ok";

    private Object data;

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(Throwable throwable){
        this.state = 0;
        this.message = "error";
    }

    public JsonResult(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
