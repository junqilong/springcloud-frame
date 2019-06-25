package com.tcl.mibc.constant;




/**
 * 接口返回结构
 **/
public class ResponseResult {

    private int code = ResponseCode.SUCCESS.getCode();
    private String msg = "ok";
    /**
     * 数据对象默认为一个空map对象
     */
    private Object data;

    public ResponseResult() {}

    public static ResponseResult success(Object data) {
        return new ResponseResult(data);
    }

    public static ResponseResult success() {
        return new ResponseResult(ResponseCode.SUCCESS);
    }

    public static ResponseResult success(Object data, int offset) {
        return new ResponseResult(data, offset);
    }


    public static ResponseResult error(String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseCode.FAILURE.getCode());
        result.setMsg(msg);
        return result;
    }

    public static ResponseResult error(ResponseCode responseCode) {
        return new ResponseResult(responseCode);
    }

    public ResponseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMessage();
    }

    public ResponseResult(ResponseCode responseCode, Object data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMessage();
        this.data = data;
    }

    private ResponseResult(Object data) {
        this.data = data;
    }

    private ResponseResult(Object data, int offset) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
