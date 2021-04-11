package com.codesorbit.assesment.models;

public class NewsModel {
    private String mImageId;
    private String mDescription;

    public NewsModel(String mImageId, String mDescription) {
        this.mImageId = mImageId;
        this.mDescription = mDescription;
    }

    public String getmImageId() {
        return mImageId;
    }

    public void setmImageId(String mImageId) {
        this.mImageId = mImageId;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
