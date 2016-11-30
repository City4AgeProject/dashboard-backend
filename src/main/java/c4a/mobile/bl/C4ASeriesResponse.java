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
public class C4ASeriesResponse {

    private String message;

    private int responseCode;
    
    private String SeriesName;

    private List<C4AServiceGetItemssListResponse> ItemList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getSeriesName() {
        return SeriesName;
    }

    public void setSeriesName(String SeriesName) {
        this.SeriesName = SeriesName;
    }
    
    public List<C4AServiceGetItemssListResponse> getItemList() {
        return ItemList;
    }

    public void setItemList(List<C4AServiceGetItemssListResponse> ItemList) {
        this.ItemList = ItemList;
    }

}//end class
