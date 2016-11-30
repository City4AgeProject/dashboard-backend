/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.mobile.bl;

import c4a.data.persistency.Items;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EMantziou
 */
public class C4AServiceGetItemssListResponse {

    private final List<Integer> items = new ArrayList<Integer>();


    public C4AServiceGetItemssListResponse(List<Items> itemssparamsList) {
        
        for (Items item : itemssparamsList) {

            items.add(item.getData_item());
        }

    }

    public List<Integer> getItems() {
        return items;
    }

}//end class
