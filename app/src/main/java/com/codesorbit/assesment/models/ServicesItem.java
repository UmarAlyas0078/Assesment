package com.codesorbit.assesment.models;

import java.util.List;

public class ServicesItem {
    private String itemTitle;
    private List<SubServicesItem> subItemList;

    public ServicesItem(String itemTitle, List<SubServicesItem> subItemList) {
        this.itemTitle = itemTitle;
        this.subItemList = subItemList;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public List<SubServicesItem> getSubItemList() {
        return subItemList;
    }

    public void setSubItemList(List<SubServicesItem> subItemList) {
        this.subItemList = subItemList;
    }
}
