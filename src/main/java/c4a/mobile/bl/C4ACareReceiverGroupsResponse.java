/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.mobile.bl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EMantziou
 */
public class C4ACareReceiverGroupsResponse {

    private String parentGroupName;
    private List<C4ServiceGetOverallScoreListResponse> items = new ArrayList<C4ServiceGetOverallScoreListResponse>();

    public C4ACareReceiverGroupsResponse(String parentGroupName, List<C4ServiceGetOverallScoreListResponse> items) {
        this.parentGroupName = parentGroupName;
        this.items = items;
    }

    public C4ACareReceiverGroupsResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<C4ServiceGetOverallScoreListResponse> getItems() {
        return items;
    }

    public String getParentGroupName() {
        return parentGroupName;
    }

    public void setParentGroupName(String parentGroupName) {
        this.parentGroupName = parentGroupName;
    }

}
