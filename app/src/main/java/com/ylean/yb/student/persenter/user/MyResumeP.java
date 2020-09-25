package com.ylean.yb.student.persenter.user;

import android.app.Activity;

import com.zxdc.utils.library.bean.BaseBean;
import com.zxdc.utils.library.bean.NetCallBack;
import com.zxdc.utils.library.bean.ResumeBean;
import com.zxdc.utils.library.bean.parameter.AddSpecialtyP;
import com.zxdc.utils.library.bean.parameter.ResumeCertificate;
import com.zxdc.utils.library.http.HttpMethod;
import com.zxdc.utils.library.util.DialogUtil;
import com.zxdc.utils.library.util.ToastUtil;

public class MyResumeP {

    private Activity activity;
    private Face face;
    private Face2 face2;
    private Face3 face3;

    public MyResumeP(Activity activity){
        this.activity=activity;
    }

    public void setFace(Face face){
        this.face=face;
    }

    public void setFace2(Face2 face2){
        this.face2=face2;
    }

    public void setFace3(Face3 face3){
        this.face3=face3;
    }


    /**
     * 查询我的简历
     */
    public void getMyResume(){
        DialogUtil.showProgress(activity,"数据加载中");
        HttpMethod.getMyResume(new NetCallBack() {
            @Override
            public void onSuccess(Object object) {
                final ResumeBean resumeBean= (ResumeBean) object;
                if(resumeBean.isSussess()){

                    face.getMyResume(resumeBean.getData());

                }else{
                    ToastUtil.showLong(resumeBean.getDesc());
                }
            }

            @Override
            public void onFail() {

            }
        });
    }


    /**
     * 新增或编辑简历信息(简历证书)
     */
    public void SaveOrUpdateCertificates(ResumeCertificate resumeCertificate){
        DialogUtil.showProgress(activity,"数据加载中");
        HttpMethod.SaveOrUpdateCertificates(resumeCertificate, new NetCallBack() {
            @Override
            public void onSuccess(Object object) {
                final BaseBean baseBean= (BaseBean) object;
                if(baseBean.isSussess()){
                    face2.onSuccess();
                }else{
                    ToastUtil.showLong(baseBean.getDesc());
                }
            }

            @Override
            public void onFail() {

            }
        });
    }


    /**
     * 新增或编辑简历信息(简历特长)
     */
    public void saveOrUpdateSpeciality(AddSpecialtyP addSpecialtyP){
        DialogUtil.showProgress(activity,"数据加载中");
        HttpMethod.saveOrUpdateSpeciality(addSpecialtyP, new NetCallBack() {
            @Override
            public void onSuccess(Object object) {
                final BaseBean baseBean= (BaseBean) object;
                if(baseBean.isSussess()){

                    face3.onSuccess();

                }else{
                    ToastUtil.showLong(baseBean.getDesc());
                }
            }

            @Override
            public void onFail() {

            }
        });
    }





    public interface Face{
        void getMyResume(ResumeBean.Resume resume);
    }

    public interface Face2{

       void onSuccess();
    }

    public interface Face3{

        void onSuccess();
    }

}
