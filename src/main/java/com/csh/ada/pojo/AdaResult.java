package com.csh.ada.pojo;

public class AdaResult<T> {

    private int state;

    private String message;

    private T data;

    /**
     * 添加或者删除成功回调
     */
    public AdaResult(){
        this.state = 200;
        this.message = "success";
    }
    /**
     * 查询成功回调
     * @param data
     */
    public AdaResult(T data){
        this.state = 200;
        this.message = "success";
        this.data = data;
    }

    /**
     * 查询失败回调
     * @param state
     * @param message
     */
    public AdaResult(int state,String message){
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
