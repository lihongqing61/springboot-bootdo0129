package com.bootdo.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Lihq
 * @Date: 2019/1/29 20:16
 * @Description: 封装结果集
 */
public class Result extends HashMap<String, Object> {

    public Result() {
        this.put("code", 1);
        this.put("msg", "操作成功");
    }

    public static Result ok() {
        return new Result();
    }

    public static Result ok(Map<String, Object> paramMap) {
        Result result = new Result();
        result.putAll(paramMap);
        return result;
    }

    public static Result ok(int code) {
        Result result = new Result();
        result.put("code", code);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }


    public static Result error() {
        return Result.error(0, "操作失败");
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result error(int code) {
        Result result = Result.error();
        result.put("code", code);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result error(Map<String, Object> paramMap) {
        Result result = new Result();
        result.putAll(paramMap);
        return result;
    }
}
