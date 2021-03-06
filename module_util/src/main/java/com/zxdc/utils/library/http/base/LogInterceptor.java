package com.zxdc.utils.library.http.base;

import com.zxdc.utils.library.base.BaseApplication;
import com.zxdc.utils.library.util.LogUtils;
import com.zxdc.utils.library.util.SPUtil;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/**
 * HTTP拦截器
 * Created by lyn on 2017/4/13.
 */
public class LogInterceptor implements Interceptor {

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        if (request.method().equals("GET")) {
            request = addGetParameter(request);
        }else if(request.method().equals("POST")){
            request = addPostParameter(request);
        }else if(request.method().equals("PUT")){
            request = addPutParameter(request);
        }else{
            request = addDeleteParameter(request);
        }
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        String body = response.body().string();
        //如果ACCESS_TOKEN失效，自动重新获取一次
        final int code = getCode(body);
        LogUtils.e(String.format("response %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, body));
        return response.newBuilder().body(ResponseBody.create(response.body().contentType(), body)).build();
    }


    /**
     * 传递GET请求的全局参数
     * @param request
     * @return
     */
    public Request addGetParameter(Request request){
        LogUtils.e("参数：token="+SPUtil.getInstance(BaseApplication.getContext()).getString(SPUtil.TOKEN));
        String params;
        if(request.url().toString().contains("?")){
            params="&ch=2&token="+SPUtil.getInstance(BaseApplication.getContext()).getString(SPUtil.TOKEN);
        }else{
            params="?ch=2&token="+SPUtil.getInstance(BaseApplication.getContext()).getString(SPUtil.TOKEN);
        }
        Request newRequest = request.newBuilder()
                .method(request.method(), request.body())
                .url(request.url()+params)
                .build();
        return newRequest;
    }


    /***
     * 添加POST的公共参数
     */
    public Request addPostParameter(Request request) throws IOException {
        request = request.newBuilder()
                .post(request.body())
                .url(request.url()+"?ch=2&token="+SPUtil.getInstance(BaseApplication.getContext()).getString(SPUtil.TOKEN))
                .build();
        return request;
    }


    /***
     * 添加PUT的公共参数
     */
    public Request addPutParameter(Request request) throws IOException {
        request = request.newBuilder()
                .put(request.body())
                .url(request.url()+"?ch=2&token="+SPUtil.getInstance(BaseApplication.getContext()).getString(SPUtil.TOKEN))
                .build();
        return request;
    }


    /**
     * 传递DELETE请求的全局参数
     * @param request
     * @return
     */
    public Request addDeleteParameter(Request request){
        LogUtils.e("参数：token="+SPUtil.getInstance(BaseApplication.getContext()).getString(SPUtil.TOKEN));
        String params;
        if(request.url().toString().contains("?")){
            params="&ch=2&token="+SPUtil.getInstance(BaseApplication.getContext()).getString(SPUtil.TOKEN);
        }else{
            params="?ch=2&token="+SPUtil.getInstance(BaseApplication.getContext()).getString(SPUtil.TOKEN);
        }
        Request newRequest = request.newBuilder()
                .method(request.method(), request.body())
                .url(request.url()+params)
                .build();
        return newRequest;
    }


    public int getCode(String json) {
        int code = 0;
        try {
            JSONObject jsonObject = new JSONObject(json);
            code = jsonObject.getInt("code");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return code;
    }

}
