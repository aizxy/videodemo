package com.feicuiedu.videonews.bombapi.result;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class QueryResult_Cloud<T> {

//    {
//        "success": true,
//            "error": null,
//            "data": [ .....]
//    }

    private QueryResult_Cloud<T> data;
    private String success;
    private String error;

    public QueryResult_Cloud<T> getData(){
        return data;
    }

    public String getSuccess(){
        return success;
    }

    public String getError(){
        return error;
    }


}
