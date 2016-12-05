/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.mobile.bl;

import c4a.data.persistency.GereatricFactor;
import c4a.data.persistency.Items;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EMantziou
 */
public class C4ServiceGetOverallScoreListResponse {

    private final List<C4AServiceGetGereatricFactorsResponse> items;
    private final List<Float> ItemList = new ArrayList<Float>();
    private final List<String> dateList = new ArrayList<String>();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");

    private String groupName;

    private String parentGroupName;

    public C4ServiceGetOverallScoreListResponse(List<GereatricFactor> gereatricfactparamsList) {
//         groupName = gereatricfactparamsList.get(0).getDetectionVariableId().getDetectionVariableName();
        items = new ArrayList<C4AServiceGetGereatricFactorsResponse>();
        for (GereatricFactor factors : gereatricfactparamsList) {
            ItemList.add(factors.getGefValue());

            String date = sdf.format(new Date(factors.getTimeIntervalId().getIntervalStart() * 1000));

            dateList.add(date);
            groupName = factors.getDetectionVariableId().getDetectionVariableName();

        }
        if (gereatricfactparamsList.get(0).getDetectionVariableId().getParentFactorId() != null) {
            parentGroupName = gereatricfactparamsList.get(0).getDetectionVariableId().getParentFactorId().getDetectionVariableName();
        } else {
            parentGroupName = "";
        }
        items.add(new C4AServiceGetGereatricFactorsResponse(groupName, ItemList, dateList));

    }

    public List<C4AServiceGetGereatricFactorsResponse> getItems() {
        return items;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getParentGroupName() {
        return parentGroupName;
    }

    public void setParentGroupName(String parentGroupName) {
        this.parentGroupName = parentGroupName;
    }

}//end class
