package com.zxdc.utils.library.bean;

import android.text.TextUtils;

import com.zxdc.utils.library.util.ToastUtil;

import java.io.Serializable;

public class AddFamily implements Serializable {

    private int relation;
    private String relationname;
    private int whethersupport;
    private String name;
    private String company;
    private String occupation;
    private String incomesource;

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationname() {
        return relationname;
    }

    public void setRelationname(String relationname) {
        this.relationname = relationname;
    }

    public int getWhethersupport() {
        return whethersupport;
    }

    public void setWhethersupport(int whethersupport) {
        this.whethersupport = whethersupport;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getIncomesource() {
        return incomesource;
    }

    public void setIncomesource(String incomesource) {
        this.incomesource = incomesource;
    }


    public boolean check(){
        if(relation==0){
            ToastUtil.showLong("请选择与本人的关系");
            return false;
        }
        if(TextUtils.isEmpty(name)){
            ToastUtil.showLong("请输入姓名");
            return false;
        }
        if(TextUtils.isEmpty(company)){
            ToastUtil.showLong("请输入单位");
            return false;
        }
        if(TextUtils.isEmpty(occupation)){
            ToastUtil.showLong("请输入职业");
            return false;
        }
        if(TextUtils.isEmpty(incomesource)){
            ToastUtil.showLong("请输入收入来源");
            return false;
        }
        return true;
    }
}
