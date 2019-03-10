package com.jay.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * created by jaywang on 2019/3/8.
 */
public class E3Result implements Serializable {

    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    public E3Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static E3Result build(Integer status, String msg, Object data) {
        return new E3Result(status, msg, data);
    }

    public static E3Result build(Integer status, String msg) {
        return new E3Result(status, msg, null);
    }

    public static E3Result ok(Object data) {
        return new E3Result(data);
    }

    public static E3Result ok() {
        return new E3Result(null);
    }

    public E3Result(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
