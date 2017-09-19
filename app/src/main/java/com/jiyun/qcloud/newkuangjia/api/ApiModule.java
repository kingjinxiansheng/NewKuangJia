package com.jiyun.qcloud.newkuangjia.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jiyun.qcloud.newkuangjia.mvp.model.Card;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chj on 2017/8/30.
 */
@Module
public class ApiModule {
    public static final String BASE_URL="https://omgvamp-hearthstone-v1.p.mashape.com";

    @Provides
    @Singleton
    public IApi getCardsApi(OkHttpClient client){
        Gson gson=new GsonBuilder()
                .registerTypeAdapter(new TypeToken<List<Card>>() {}.getType(),new CardsDeserializer()).create();


        Retrofit CardsApiAdapter=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        return CardsApiAdapter.create(IApi.class);

    }
}
