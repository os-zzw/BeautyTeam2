package com.example.john.beautyteam2.service;

import com.example.john.beautyteam2.bean.Bean_Hello;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ZheWei on 2016/9/13.
 * 所有网络的接口
 */
public interface Api {

    String BASE = "https://www.obisoft.com.cn";
    String AppId = "7a76bda590d1fd2a3ead5f1b25a3a398";
    String AppSecret = "95d410be7d90cbb555e3ad4c0dd9fb5c";

    @GET("api")
    Observable<Bean_Hello> getHello();

    @GET("/api/token")
    Observable<Bean_Hello> getToken(
            @Query("AppId") String AppId,
            @Query("AppSecret") String AppSecret);

    @POST("/api/Login")
    Observable<Bean_Hello> postLogin(
            @Query("Email") String Email,
            @Query("Password") String Password,
            @Query("RememberMe") boolean RememberMe
    );

    @POST("/api/Register")
    Observable<Bean_Hello> postRegister(
            @Query("Email") String Email,
            @Query("Password") String Password,
            @Query("ConfirmPassword") String ConfirmPassword
    );

    @POST("/api/ForgotPassword")
    Observable<Bean_Hello> postForgotPassWord(
            @Query("Email") String Email
    );
    @POST("/api/VerifyEmail")
    Observable<Bean_Hello> postVerifyEmail(
    );

    @GET("/api/UserInfo")
    Observable<Bean_Hello> getUserInfo(
    );


}
