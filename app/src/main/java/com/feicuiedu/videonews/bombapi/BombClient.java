package com.feicuiedu.videonews.bombapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：yuanchao on 2016/8/16 0016 11:57
 * 邮箱：yuanchao@feicuiedu.com
 */
public class BombClient {

    private static BombClient sInstance;

    public static synchronized BombClient getsInstance() {
        if (sInstance == null) {
            sInstance = new BombClient();
        }
        return sInstance;
    }

    private Retrofit retrofit;
    private NewsApi newsApi;
    private UserApi userApi;


    //cloud
    private Retrofit retrofit_cloud;
    private NewsApi newsApi_cloud;

    private BombClient() {

        // 日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 构建OkHttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BombInterceptor()) // 用来统一处理bomb必要头字段的拦截器
                .addInterceptor(httpLoggingInterceptor) // 日志拦截器
                .build();

        // 让Gson能将bomb返回的时间戳自动转为date对象
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                        // bomb服务器baseurl
                .baseUrl("https://api.bmob.cn/")
                        // Gson转换器
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // Bomb云逻辑接口
        retrofit_cloud = new Retrofit.Builder()
                .client(okHttpClient)
                // bomb服务器baseurl
                .baseUrl("http://cloud.bmob.cn/")
                // Gson转换器
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public NewsApi getNewsApi() {
        if (newsApi == null) {
            newsApi = retrofit.create(NewsApi.class);
        }
        return newsApi;
    }

    public UserApi getUserApi() {
        if (userApi == null) {
            userApi = retrofit.create(UserApi.class);
        }
        return userApi;
    }

    //Bomb云逻辑接口
    public NewsApi getNewsApi_cloud(){
        if (newsApi_cloud == null){
            newsApi_cloud = retrofit_cloud.create(NewsApi.class);
        }
        return  newsApi_cloud;
    }

}
