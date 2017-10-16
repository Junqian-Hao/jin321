package com.jin321.ms.dao;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by Tyranitarx on 2017/10/16.
 *
 * @Description :
 */
public class TestJson {
    public static void main(String[] args){
        String json="[\"123\",\"456\"]";
        List<Integer> pidlist= JSON.parseArray(json,Integer.class);

    }
}
