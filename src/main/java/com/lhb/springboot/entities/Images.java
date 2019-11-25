package com.lhb.springboot.entities;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 08:44 2019/11/13
 */
public class Images {
    private String imgUuid;
    private String imgName;
    private String imgUrl;
    private String imgZipurl;
    private String userUuid;
    private String diseaseUuid;
    private String stateCode;
    private String msg;

    public Images() {
    }

    public Images(String imgName) {
        this.imgName = imgName;
    }

    public Images(String imgUuid, String imgName, String imgUrl, String imgZipurl,
                  String userUuid, String diseaseUuid, String stateCode, String msg) {
        this.imgUuid = imgUuid;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.imgZipurl = imgZipurl;
        this.userUuid = userUuid;
        this.diseaseUuid = diseaseUuid;
        this.stateCode = stateCode;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Images{" +
                "imgUuid='" + imgUuid + '\'' +
                ", imgName='" + imgName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgZipurl='" + imgZipurl + '\'' +
                ", userUuid='" + userUuid + '\'' +
                ", diseaseUuid='" + diseaseUuid + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getImgUuid() {
        return imgUuid;
    }

    public void setImgUuid(String imgUuid) {
        this.imgUuid = imgUuid;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgZipurl() {
        return imgZipurl;
    }

    public void setImgZipurl(String imgZipurl) {
        this.imgZipurl = imgZipurl;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getDiseaseUuid() {
        return diseaseUuid;
    }

    public void setDiseaseUuid(String diseaseUuid) {
        this.diseaseUuid = diseaseUuid;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
