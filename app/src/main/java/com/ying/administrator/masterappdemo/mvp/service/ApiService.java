package com.ying.administrator.masterappdemo.mvp.service;

import com.ying.administrator.masterappdemo.base.BaseResult;
import com.ying.administrator.masterappdemo.entity.Data;
import com.ying.administrator.masterappdemo.entity.WorkOrder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    /**
     * 判断用户名是否可用
     */
    @FormUrlEncoded
    @POST("Account/ValidateUserName")
    Observable<BaseResult<String>> ValidateUserName(@Field("UserID") String userName);

    /**
     * 获取短信
     */
    @FormUrlEncoded
    @POST("Message/Send")
    Observable<BaseResult<String>> GetCode(@Field("mobile") String mobile,
                                           @Field("type") String type,
                                           @Field("roleType") String roleType);



    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("Account/Reg")
    Observable<BaseResult<String>> Reg(@Field("mobile") String mobile,
                                       @Field("type") String type,
                                       @Field("code") String code,
                                       @Field("roleType") String roleType);


    /**
     * app用户登录
     */
    @FormUrlEncoded
    @POST("Account/LoginOn")
    Observable<BaseResult<String>> LoginOn(@Field("userName") String userName,
                                           @Field("passWord") String passWord);


    /**
     * app获取用户信息
     */
    @POST("Account/GetUserInfo")
    Observable<BaseResult<String>> GetUserInfo(@Body RequestBody json);

    /**
     * app获取用户信息
     */
    @FormUrlEncoded
    @POST("Account/GetUserInfo")
    Observable<BaseResult<String>> GetUserInfo(@Field("userName") String userName);



      /*
      *新增获取更新推送账户的token以及tags， 工厂的type是6 师傅的type是7 ， createtime可以不传 UserID为登录用户名
      * */
      @FormUrlEncoded
      @POST("Message/AddAndUpdatePushAccount")
      Observable<BaseResult<String>> AddAndUpdatePushAccount(@Field("token") String token,
                                                             @Field("type") String type,
                                                             @Field("UserID") String UserID);

    /**
     * 获取工单列表
     * 废除-1，待审核0，派单中1，服务中2，已完成3
     */
    @FormUrlEncoded
    @POST("Order/GetOrderInfoList")
    Observable<BaseResult<WorkOrder>> GetOrderInfoList(@Field("state") String state,
                                                       @Field("page") String page,
                                                       @Field("limit") String limit);



    /**
     * 提交抢单申请
     */
@FormUrlEncoded
@POST("Order/GrabOrder")
    Observable<BaseResult<Data>> AddGrabsheetapply (@Field("OrderID") String OrderID,
                                                    @Field("UserID") String UserID);

/**
 * 获取其他状态的 获取已接的订单
 * **/
    @FormUrlEncoded
    @POST("Order/GetOrderInfoList")
    Observable<BaseResult<WorkOrder>> GetOrderInfoListForMe(@Field("state") String state,
                                                            @Field("page") String page,
                                                            @Field("limit") String limit,
                                                            @Field("SendUser") String SendUser);
/**
 * 提交师傅预约失败的原因
 * **/
    @FormUrlEncoded
    @POST("Order/UpdateSendOrderAppointmentState")
    Observable<BaseResult<Data>> AddOrderfailureReason(@Field("OrderID") String OrderID,
                                                         @Field("AppointmentState") String AppointmentState,
                                                         @Field("AppointmentMessage") String AppointmentMessage);



}
