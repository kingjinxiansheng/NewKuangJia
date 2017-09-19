package com.jiyun.qcloud.newkuangjia.model;

import com.jiyun.qcloud.newkuangjia.entity.WeatherEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by chj on 2017/9/1.
 *  功能描述: http://wthrcdn.etouch.cn/weather_mini?city=北京
 */

public interface GetWeaTherService {
        //这是frtofit2的接口请求注解
        @GET("weather_mini")
        Observable<WeatherEntity> getRxMessage(@Query("city") String city); //Query代表问号的意思，拼接的字符串为

}
