package com.example.paginationexamplejavacorrect.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Books {

    @Expose
    @SerializedName("image")
    private String image;
    @Expose
    @SerializedName("isbn13")
    private String unicStringValue;
    @Expose
    @SerializedName("price")
    private String price;
    @Expose
    @SerializedName("subtitle")
    private String subtitle;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("url")
    private String url;

    public String getUnicStringValue() {
        return unicStringValue;
    }

    public void setUnicStringValue(String unicStringValue) {
        this.unicStringValue = unicStringValue;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
