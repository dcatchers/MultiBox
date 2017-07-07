package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wyf on 2016/8/29.
 */
public class ProductInfoResult implements Serializable{

    /**
     * prodName : 2
     * price : 0.00
     * prodId : 1079087
     * prodPhotoPath : /productPhoto/1079087.png
     * prodMemo : 2
     */

    @SerializedName("prodName")
    private String prodName;
    @SerializedName("prodId")
    private String prodId;
    @SerializedName("prodPhotoPath")
    private String prodPhotoPath;
    @SerializedName("prodMemo")
    private String prodMemo;

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdPhotoPath() {
        return prodPhotoPath;
    }

    public void setProdPhotoPath(String prodPhotoPath) {
        this.prodPhotoPath = prodPhotoPath;
    }

    public String getProdMemo() {
        return prodMemo;
    }

    public void setProdMemo(String prodMemo) {
        this.prodMemo = prodMemo;
    }

    @Override
    public String toString() {
        return "ProductInfoResult{" +
                "prodName='" + prodName + '\'' +
                ", prodId='" + prodId + '\'' +
                ", prodPhotoPath='" + prodPhotoPath + '\'' +
                ", prodMemo='" + prodMemo + '\'' +
                '}';
    }
}
