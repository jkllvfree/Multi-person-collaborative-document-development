package com.example.db_document.pojo;

public class JsonResult<T> {
    private int code;
    private String msg;          //提示信息
    private T data;         //具体数据

    public JsonResult() {}

    public JsonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(200, "success", data);
    }

    public static <T> JsonResult<T> error(String msg) {
        return new JsonResult<>(500, msg, null);
    }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}