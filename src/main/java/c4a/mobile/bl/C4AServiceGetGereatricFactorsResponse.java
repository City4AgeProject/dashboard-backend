/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.mobile.bl;

import java.util.List;

/**
 *
 * @author EMantziou
 */
public class C4AServiceGetGereatricFactorsResponse {

    private String groupName;
    private List<Float> ItemList;
    private List<String> dateList ;

    C4AServiceGetGereatricFactorsResponse(String groupName, List<Float> itemList, List<String> dateList) {
        this.groupName = groupName;
        this.ItemList = itemList;
        this.dateList = dateList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Float> getItemList() {
        return ItemList;
    }

    public void setItemList(List<Float> ItemList) {
        this.ItemList = ItemList;
    }

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    
}//end class
