package com.example.john.beautyteam2.bean;

import java.io.Serializable;

/**
 * Created by ZheWei on 2016/9/14.
 */
public class Bean_Base<T> implements Serializable {

    public T data;
    public String Code;
    public String Result;

    @Override
    public String toString() {
        return "Bean_Base{" +
                "data=" + data +
                ", Code='" + Code + '\'' +
                ", Result='" + Result + '\'' +
                '}';
    }
}
