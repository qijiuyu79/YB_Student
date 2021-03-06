package com.zxdc.utils.library.bean;

import java.io.Serializable;
import java.util.List;

public class EducationBean extends BaseBean {

    private List<Education> data;

    public List<Education> getData() {
        return data;
    }

    public void setData(List<Education> data) {
        this.data = data;
    }

    public static class Education implements Serializable{
        private int id;
        private int ltype;
        private int type;
        private int sid;
        private String sname;
        private int facultyid;
        private String facultyname;
        private int majorid;
        private String majorname;
        private int rid;
        private int education;
        private String grades;
        private String admissiontime;
        private String region;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLtype() {
            return ltype;
        }

        public void setLtype(int ltype) {
            this.ltype = ltype;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getFacultyid() {
            return facultyid;
        }

        public void setFacultyid(int facultyid) {
            this.facultyid = facultyid;
        }

        public int getMajorid() {
            return majorid;
        }

        public void setMajorid(int majorid) {
            this.majorid = majorid;
        }

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }

        public int getEducation() {
            return education;
        }

        public void setEducation(int education) {
            this.education = education;
        }

        public String getGrades() {
            return grades;
        }

        public void setGrades(String grades) {
            this.grades = grades;
        }

        public String getAdmissiontime() {
            return admissiontime;
        }

        public void setAdmissiontime(String admissiontime) {
            this.admissiontime = admissiontime;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getFacultyname() {
            return facultyname;
        }

        public void setFacultyname(String facultyname) {
            this.facultyname = facultyname;
        }

        public String getMajorname() {
            return majorname;
        }

        public void setMajorname(String majorname) {
            this.majorname = majorname;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }
}
