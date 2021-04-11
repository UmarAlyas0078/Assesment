package com.codesorbit.assesment.models;

public class SubServicesItem {
    private String subItemImage;
    private String subItemTitle;
    private String typeOfData;

    public SubServicesItem(String subItemImage, String subItemTitle, String typeOfData) {
        this.subItemImage = subItemImage;
        this.subItemTitle = subItemTitle;
        this.typeOfData = typeOfData;
    }

    public String getTypeOfData() {
        return typeOfData;
    }

    public void setTypeOfData(String typeOfData) {
        this.typeOfData = typeOfData;
    }

    public String getSubItemImage() {
        return subItemImage;
    }

    public void setSubItemImage(String subItemImage) {
        this.subItemImage = subItemImage;
    }

    public String getSubItemTitle() {
        return subItemTitle;
    }

    public void setSubItemTitle(String subItemTitle) {
        this.subItemTitle = subItemTitle;
    }
}
