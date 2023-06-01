package com.example.mytest.resulters;

public class ResultData<T> {
    private Integer status;
    private T data;
    private String msg;
    public ResultData<T>  sucess(T t){
        return new ResultData<>(200,t,"操作成功");
    }

    public ResultData(Integer status, T data,String msg) {
        this.status = status;
        this.data = data;
        this.msg=msg;
    }

    public ResultData() {
    }
    public static ResultData notoken(){
        return new ResultData<>(403,null,"请重新登陆");
    }
}
