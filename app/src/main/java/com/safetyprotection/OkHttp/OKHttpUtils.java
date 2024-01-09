package com.safetyprotection.OkHttp;


import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.Collections;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by renxuetao on 16/7/10.
 */
public class OKHttpUtils {

    private static OKHttpUtils sInstance;
    //请求类型
    public static final MediaType mJSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient.Builder builder;
    private Request.Builder requestBuilder;
    private OkHttpClient okHttpClient;

    private OKHttpUtils() {
        builder = new OkHttpClient.Builder();
        okHttpClient = builder.addInterceptor(new RequestLoggerInterceptor())
                .addInterceptor(new ResponseLoggerInterceptor())
                .build();
        requestBuilder = new Request.Builder();//省的每次都new  request操作,直接builder出来,随后需要什么往里加,build出来即可
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static OKHttpUtils instance() {
        if (sInstance == null) {
            synchronized (OKHttpUtils.class) {
                if (sInstance == null) {
                    sInstance = new OKHttpUtils();
                }
            }
        }
        return sInstance;
    }

    /**
     * 这是一个下载文件的方法
     *
     * @param filepath         文件路径
     * @param filename         文件名字
     * @param donwLoadUrl      下载链接
     * @param progressListener 回调监听
     */
    public Call donwloadFile(final String filepath, final String filename, String donwLoadUrl, final ProgressResponseBody.ProgressListener progressListener) {
        Request request = new Request.Builder().url(donwLoadUrl).build();
        Call call = new OkHttpClient.Builder()
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                /**
                 * 任雪涛增加防止代理方法
                 * .proxy(Proxy.NO_PROXY)
                 */
                .proxy(Proxy.NO_PROXY)
                .build()
                .newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response originalResponse = chain.proceed(chain.request());
                        return originalResponse.newBuilder().body(
                                        new ProgressResponseBody(originalResponse.body(), progressListener))
                                .build();
                    }
                }).build().newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("wanges1", "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("wanges1", "onResponse");
                //将返回结果转化为流，并写入文件
                int len;
                byte[] buf = new byte[2048];
                InputStream inputStream = response.body().byteStream();
                //可以在这里自定义路径
                File files = new File(filepath);
                if (!files.exists()) {
                    files.mkdir();
                }
                File file1 = new File(filepath, filename);
                FileOutputStream fileOutputStream = new FileOutputStream(file1);
                while ((len = inputStream.read(buf)) != -1) {
                    fileOutputStream.write(buf, 0, len);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
            }
        });
        return call;
    }

    public void httpGet(String url, final ICallback callback) {
        Request request = requestBuilder.url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.invoke("数据错误");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                callback.invoke(response.body().string());
            }
        });
    }

    public void httpPost(String urlString, FormBody formBody, Callback callback) {
        Request request = requestBuilder.url(urlString).method("POST", formBody).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 接口用于回调数据
     */
    public interface ICallback {
        void invoke(String string);
    }

    /**
     * 请求拦截器
     */
    static class RequestLoggerInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            Log.e(this.getClass().getSimpleName(), "url    =  : " + request.url());
            Log.e(this.getClass().getSimpleName(), "method =  : " + request.method());
            Log.e(this.getClass().getSimpleName(), "headers=  : " + request.headers());
            Log.e(this.getClass().getSimpleName(), "body   =  : " + request.body());

            return chain.proceed(request);
        }
    }

    /**
     * 响应拦截器
     */
    static class ResponseLoggerInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());

            Log.e(this.getClass().getSimpleName(), "code    =  : " + response.code());
            Log.e(this.getClass().getSimpleName(), "message =  : " + response.message());
            Log.e(this.getClass().getSimpleName(), "protocol=  : " + response.protocol());

            if (response.body() != null && response.body().contentType() != null) {
                MediaType mediaType = response.body().contentType();
                String string = response.body().string();
                Log.e(this.getClass().getSimpleName(), "mediaType=  :  " + mediaType.toString());
                Log.e(this.getClass().getSimpleName(), "string   =  : " + string);
                ResponseBody responseBody = ResponseBody.create(mediaType, string);
                return response.newBuilder().body(responseBody).build();
            } else {
                return response;
            }
        }
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public Response httpGet(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post请求
     *
     * @param url
     * @param data 提交的参数为key=value&key1=value1的形式
     */
    public static String httpPost(String url, String data) {
        String result = null;
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/html;charset=utf-8"), data);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response response = httpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
