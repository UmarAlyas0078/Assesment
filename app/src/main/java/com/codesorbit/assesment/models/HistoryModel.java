package com.codesorbit.assesment.models;

public class HistoryModel {
    private String mImageId;
    private String mHistory;

    public HistoryModel(String mImageId, String mHistory) {
        this.mImageId = mImageId;
        this.mHistory = mHistory;
    }

    public String getmImageId() {
        return mImageId;
    }

    public void setmImageId(String mImageId) {
        this.mImageId = mImageId;
    }

    public String getmHistory() {
        return mHistory;
    }

    public void setmHistory(String mHistory) {
        this.mHistory = mHistory;
    }
}
