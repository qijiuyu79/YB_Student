package com.zxdc.utils.library.bean;

import java.io.Serializable;

public class UserInfo extends BaseBean {

    private UserBean data;

    public UserBean getData() {
        return data;
    }

    public void setData(UserBean data) {
        this.data = data;
    }

    public static class UserBean implements Serializable {

        private int id;
        private int ctype;
        private String idnum;
        private String name="";
        private String sex="";
        private String birthday="";
        private String address="";
        private String nation="";
        private String nationality="";
        private String photo="";
        private int education;
        private String residenceaddress="";
        private String qq="";
        private String wechat="";
        private String validitystarttime="";
        private String validityendtime="";
        private String phone="";
        private String email="";
        private boolean isbfchildren;
        private String ucphone;
        private int inschoolstatus;//学生在校状态 0-正常 1-异常

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCtype() {
            return ctype;
        }

        public void setCtype(int ctype) {
            this.ctype = ctype;
        }

        public String getIdnum() {
            return idnum;
        }

        public void setIdnum(String idnum) {
            this.idnum = idnum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex==null ? "" : sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday==null ? "" : birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getNation() {
            return nation==null ? "" : nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getNationality() {
            return nationality==null ? "" : nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getResidenceaddress() {
            return residenceaddress;
        }

        public void setResidenceaddress(String residenceaddress) {
            this.residenceaddress = residenceaddress;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getValiditystarttime() {
            return validitystarttime==null ? "" : validitystarttime;
        }

        public void setValiditystarttime(String validitystarttime) {
            this.validitystarttime = validitystarttime;
        }

        public String getValidityendtime() {
            return validityendtime==null ? "" : validityendtime;
        }

        public void setValidityendtime(String validityendtime) {
            this.validityendtime = validityendtime;
        }

        public boolean isIsbfchildren() {
            return isbfchildren;
        }

        public void setIsbfchildren(boolean isbfchildren) {
            this.isbfchildren = isbfchildren;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email==null ? "" : email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getEducation() {
            return education;
        }

        public void setEducation(int education) {
            this.education = education;
        }

        public String getUcphone() {
            return ucphone;
        }

        public void setUcphone(String ucphone) {
            this.ucphone = ucphone;
        }

        public int getInschoolstatus() {
            return inschoolstatus;
        }

        public void setInschoolstatus(int inschoolstatus) {
            this.inschoolstatus = inschoolstatus;
        }
    }


    public static class Parent implements Serializable{
        private String phone;
        private String tel;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }

}
