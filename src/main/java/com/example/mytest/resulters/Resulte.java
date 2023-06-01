package com.example.mytest.resulters;

import java.sql.ResultSetMetaData;

public class Resulte {
    private Integer status;
    private ResultData data;
    public static Resulte sucess(Object obj){
        return new Resulte(200,new ResultData().sucess(obj));
    }

    public Resulte(Integer status, ResultData data) {
        this.status = status;
        this.data = data;
    }
    public static Resulte noken(){
        return new Resulte(403,ResultData.notoken());
    }
}
