package cn.sciuridae.bean;

import java.io.Serializable;

public class Result implements Serializable {
    private String message;//返回的消息
    private boolean status;//返回的状态
    private Object object;//随缘参数

    public Result() {
    }

    public Result(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public Result(String message, boolean status, Object object) {
        this.message = message;
        this.status = status;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public Result setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", object=" + object +
                '}';
    }
}
