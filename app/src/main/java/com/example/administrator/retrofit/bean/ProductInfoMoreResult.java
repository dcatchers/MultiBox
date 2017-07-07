package com.example.administrator.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wyf on 2016/8/30.
 */
public class ProductInfoMoreResult implements Serializable{

    /**
     * price : 500.00
     * prodSubMemo : 我是子描述
     * prodPhotoPath : /image/productPhoto/689402.jpg
     * prodChargeCycle : 1
     * prodChargeUnit : 3
     */
    @SerializedName("price")
    private String price;
    @SerializedName("prodSubMemo")
    private String prodSubMemo;
    @SerializedName("prodPhotoPath")
    private String prodPhotoPath;
    /**
     * 产品的计费周期
     */
    @SerializedName("prodChargeCycle")
    private String prodChargeCycle;
    /**
     * 产品的计费周期单位
     1: 按天计费
     2: 按月计费
     3: 按年计费
     */
    @SerializedName("prodChargeUnit")
    private String prodChargeUnit;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProdSubMemo() {
        return prodSubMemo;
    }

    public void setProdSubMemo(String prodSubMemo) {
        this.prodSubMemo = prodSubMemo;
    }

    public String getProdPhotoPath() {
        return prodPhotoPath;
    }

    public void setProdPhotoPath(String prodPhotoPath) {
        this.prodPhotoPath = prodPhotoPath;
    }

    public String getProdChargeCycle() {
        return prodChargeCycle;
    }

    public void setProdChargeCycle(String prodChargeCycle) {
        this.prodChargeCycle = prodChargeCycle;
    }

    public String getProdChargeUnit() {
        return prodChargeUnit;
    }

    public void setProdChargeUnit(String prodChargeUnit) {
        this.prodChargeUnit = prodChargeUnit;
    }

    @Override
    public String toString() {
        return "ProductInfoMoreResult{" +
                "price='" + price + '\'' +
                ", prodSubMemo='" + prodSubMemo + '\'' +
                ", prodPhotoPath='" + prodPhotoPath + '\'' +
                ", prodChargeCycle='" + prodChargeCycle + '\'' +
                ", prodChargeUnit='" + prodChargeUnit + '\'' +
                '}';
    }
}
