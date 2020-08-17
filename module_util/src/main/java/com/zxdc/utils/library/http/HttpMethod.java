package com.zxdc.utils.library.http;

import com.zxdc.utils.library.bean.BaseBean;
import com.zxdc.utils.library.bean.FileBean;
import com.zxdc.utils.library.bean.NetCallBack;
import com.zxdc.utils.library.bean.ProvinceBean;
import com.zxdc.utils.library.bean.UserInfo;
import com.zxdc.utils.library.http.base.BaseRequst;
import com.zxdc.utils.library.http.base.Http;
import com.zxdc.utils.library.util.DialogUtil;
import com.zxdc.utils.library.util.JsonUtil;
import com.zxdc.utils.library.util.ToastUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpMethod extends BaseRequst {

    private static String size="10";
    public static int pageSize=10;


    /**
     * 获取所有省集合
     */
    public static void getProvince(final NetCallBack netCallBack) {
        Http.getRetrofit().create(HttpApi.class).getProvince().enqueue(new Callback<ProvinceBean>() {
            public void onResponse(Call<ProvinceBean> call, Response<ProvinceBean> response) {
                DialogUtil.closeProgress();
                netCallBack.onSuccess(response.body());
            }
            public void onFailure(Call<ProvinceBean> call, Throwable t) {
                DialogUtil.closeProgress();
                ToastUtil.showLong("网络异常，请检查网络后重试");
            }
        });
    }



    /**
     * 根据省代码获取市集合
     */
    public static void getCityByProvince(String code,final NetCallBack netCallBack) {
        Http.getRetrofit().create(HttpApi.class).getCityByProvince(code).enqueue(new Callback<ProvinceBean>() {
            public void onResponse(Call<ProvinceBean> call, Response<ProvinceBean> response) {
                DialogUtil.closeProgress();
                netCallBack.onSuccess(response.body());
            }
            public void onFailure(Call<ProvinceBean> call, Throwable t) {
                DialogUtil.closeProgress();
                ToastUtil.showLong("网络异常，请检查网络后重试");
            }
        });
    }


    /**
     * 根据市代码获取区集合
     */
    public static void getAreaByCity(String code,final NetCallBack netCallBack) {
        Http.getRetrofit().create(HttpApi.class).getAreaByCity(code).enqueue(new Callback<ProvinceBean>() {
            public void onResponse(Call<ProvinceBean> call, Response<ProvinceBean> response) {
                DialogUtil.closeProgress();
                netCallBack.onSuccess(response.body());
            }
            public void onFailure(Call<ProvinceBean> call, Throwable t) {
                DialogUtil.closeProgress();
                ToastUtil.showLong("网络异常，请检查网络后重试");
            }
        });
    }


    /**
     * 注册第一步
     */
    public static void register1(String code, String idcardno, String phone, String pwd, List<FileBean> list,final NetCallBack netCallBack){
        Map<String,String> map=new HashMap<>();
        map.put("code",code);
        map.put("idcardno",idcardno);
        map.put("phone",phone);
        map.put("pwd",pwd);
        Http.upLoadFile("api/user/student/register", list, map, new okhttp3.Callback() {
            public void onResponse(okhttp3.Call call, okhttp3.Response response){
                DialogUtil.closeProgress();
                try {
                    String str = response.body().string();
                    final UserInfo userInfo= (UserInfo) JsonUtil.stringToObject(str,UserInfo.class);
                    netCallBack.onSuccess(userInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            public void onFailure(okhttp3.Call call, IOException e) {
                DialogUtil.closeProgress();
                ToastUtil.showLong(e.getMessage());
            }
        });
    }


    /**
     * 保存用户基本信息
     */
    public static void saveUser(String ucphone,String address,String qq,String residenceaddress,String uctel,int uid,String wechat,final NetCallBack netCallBack) {
        Map<String ,String> map=new HashMap<>();
        map.put("ucphone",ucphone);
        map.put("address",address);
        map.put("qq",qq);
        map.put("residenceaddress",residenceaddress);
        map.put("uctel",uctel);
        map.put("uid",uid+"");
        map.put("wechat",wechat);
        Http.getRetrofit().create(HttpApi.class).saveUser(map).enqueue(new Callback<BaseBean>() {
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                DialogUtil.closeProgress();
                netCallBack.onSuccess(response.body());
            }
            public void onFailure(Call<BaseBean> call, Throwable t) {
                DialogUtil.closeProgress();
                ToastUtil.showLong("网络异常，请检查网络后重试");
            }
        });
    }


    /**
     * 学生注册第三步
     */
    public static void bindingEmail(String code,String email,final NetCallBack netCallBack) {
        Map<String ,String> map=new HashMap<>();
        map.put("code",code);
        map.put("email",email);
        Http.getRetrofit().create(HttpApi.class).bindingEmail(map).enqueue(new Callback<BaseBean>() {
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                DialogUtil.closeProgress();
                netCallBack.onSuccess(response.body());
            }
            public void onFailure(Call<BaseBean> call, Throwable t) {
                DialogUtil.closeProgress();
                ToastUtil.showLong("网络异常，请检查网络后重试");
            }
        });
    }

}
