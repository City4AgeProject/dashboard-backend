/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.services;

import c4a.data.persistency.CareProfile;
import c4a.data.persistency.CrProfile;
import c4a.data.persistency.DetectionVariable;
import c4a.data.persistency.GereatricFactor;
import c4a.data.persistency.Userinrole;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import c4a.mobile.bl.C4ACareReceiverListResponse;
import c4a.mobile.bl.C4ACareReceiversResponse;
import c4a.mobile.bl.C4AGroupsResponse;
import c4a.mobile.bl.C4ServiceGetOverallScoreListResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author EMantziou
 */
@Stateless
@Path("careReceiversData")
public class OverallGroupScoreRersource {

    @PersistenceContext(unitName = "c4AServicesPlatformPU")
    private EntityManager em;

    public void init() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("c4AServicesPlatformPU");
        em = factory.createEntityManager();
    }

    public OverallGroupScoreRersource() {

    }

    @GET
    @Path("getGroups")
    @Consumes("application/json")
    @Produces("application/json")
    public C4AGroupsResponse getJson(@QueryParam("careReceiverId") String careReceiverId, @QueryParam("parentFactorId") String parentFactorId) throws IOException {
        /**
         * ****************Variables*************
         */
        C4AGroupsResponse response = new C4AGroupsResponse();
        TypedQuery query;

        TypedQuery query_groups;

        List<GereatricFactor> gereatricfactparamsList;
        List<DetectionVariable> detectionvarsparamsList;
        ArrayList<C4ServiceGetOverallScoreListResponse> itemList;

        /**
         * ****************Action*************
         */
        if (em == null) {
            init();
        }

        if (Integer.parseInt(parentFactorId) == -1) {
            query_groups = (TypedQuery) em.createQuery("SELECT d FROM DetectionVariable d WHERE d.detectionVariableType.variableType = :gefType ");
            query_groups.setParameter("gefType", "FGR");
        } else {
            query_groups = (TypedQuery) em.createQuery("SELECT d FROM DetectionVariable d WHERE d.parentFactorId.detectionVariableId = :gefType ");
            query_groups.setParameter("gefType", parentFactorId);
        }

        detectionvarsparamsList = query_groups.getResultList();

        if (detectionvarsparamsList.isEmpty()) {
            response.setMessage("No detection variables found");
            response.setResponseCode(0);
            return response;
        } else {
            itemList = new ArrayList<C4ServiceGetOverallScoreListResponse>();
            for (DetectionVariable types : detectionvarsparamsList) {

                System.out.println("id " + types.getDetectionVariableId()
                        + "name " + types.getDetectionVariableName()
                        + " type name " + types.getDetectionVariableType().getVariableType());

                query = (TypedQuery) em.createQuery("SELECT g FROM GereatricFactor g WHERE g.detectionVariableId.detectionVariableId = :varId "
                        + "and g.userInRoleId.userInRoleId = :userId");
                query.setParameter("varId", types.getDetectionVariableId());
                query.setParameter("userId", Integer.parseInt(careReceiverId));

                //we use list to avoid "not found" exception
                gereatricfactparamsList = query.getResultList();
                //
                if (gereatricfactparamsList.isEmpty()) {
                    response.setMessage("No factors for this group");
                    response.setResponseCode(0);
                    response.setCareReceiverName("");
                    response.setItemList(null);
                } else {

//                    for (GereatricFactor factors : gereatricfactparamsList) {
//
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
//                        String date = sdf.format(new Date(factors.getTimeIntervalId().getIntervalStart() * 1000));
//
////               
//                        System.out.println("variable type " + factors.getDetectionVariableId().getDetectionVariableName()
//                                + " of group " + factors.getDetectionVariableId().getDetectionVariableType().getVariableType()
//                                + " when " + date
//                                + " value " + factors.getGefValue());
//
//                    }
                    response.setMessage("success");
                    response.setResponseCode(10);

                    response.setCareReceiverName(gereatricfactparamsList.get(0).getUserInRoleId().getStakeholderId());

                    itemList.add(new C4ServiceGetOverallScoreListResponse(gereatricfactparamsList));
                    response.setItemList(itemList);

                }

            }//detectionVariables loop        

        }//end detectionVariables is empty

        return response;

    }//end method

    @GET
    @Path("getCareReceivers")
    @Consumes("application/json")
    @Produces("application/json")
    public C4ACareReceiversResponse getJson() throws IOException {
        /**
         * ****************Variables*************
         */
        C4ACareReceiversResponse response = new C4ACareReceiversResponse();
        TypedQuery query;
        TypedQuery query_crProfile;
        TypedQuery query_users;

        List<Userinrole> userinroleparamsList;
        List<CrProfile> crprofileparamsList;
        List<CareProfile> careprofileparamsList;
        ArrayList<C4ACareReceiverListResponse> itemList;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        /**
         * ****************Action*************
         */
        if (em == null) {
            init();
        }

        query_users = (TypedQuery) em.createQuery("SELECT u FROM Userinrole u Where u.summary IS NOT NULL");

        userinroleparamsList = query_users.getResultList();

        if (userinroleparamsList.isEmpty()) {
            response.setMessage("No users found");
            response.setResponseCode(0);
            return response;
        } else {
            itemList = new ArrayList<C4ACareReceiverListResponse>();
            for (Userinrole users : userinroleparamsList) {
                response.setMessage("success");
                response.setResponseCode(10);
//                System.out.println("id " + users.getStakeholderId()
//                        + "name " + users.getUserInRoleId());

                query_crProfile = (TypedQuery) em.createQuery("SELECT c FROM CrProfile c Where c.userInRoleId.userInRoleId = :userId ");
                query_crProfile.setParameter("userId", users.getUserInRoleId());

                //we use list to avoid "not found" exception
                crprofileparamsList = query_crProfile.getResultList();
                int age = 0;
                if (!crprofileparamsList.isEmpty()) {
                    age = crprofileparamsList.get(0).getAge();
//                    System.out.println("user name " + crprofileparamsList.get(0).getUserInRoleId().getUserInRoleId()
//                            + " age " + crprofileparamsList.get(0).getAge());
                }

                query = (TypedQuery) em.createQuery("SELECT c FROM CareProfile c WHERE c.userInRoleId = :userId ");
                query.setParameter("userId", users.getUserInRoleId());

                //we use list to avoid "not found" exception
                careprofileparamsList = query.getResultList();
                //**************************************
                String frailtyStatus = null;
                String frailtyNotice = null;
                String attention = null;
                String textline = null;
                String interventionstatus = null;
                String interventionDate = null;
                String detectionStatus = null;
                String detectionDate = null;
                if (!careprofileparamsList.isEmpty()) {
                    frailtyStatus = careprofileparamsList.get(0).getFrailtyStatus();
                    frailtyNotice = careprofileparamsList.get(0).getFrailtyNotice();
                    attention = careprofileparamsList.get(0).getAttentionStatus();
                    textline = careprofileparamsList.get(0).getDetectionSummary();
                    interventionstatus = careprofileparamsList.get(0).getInterventionStatus();
                    interventionDate = sdf.format(new Date(careprofileparamsList.get(0).getLastIntervention() * 1000));
                    detectionStatus = careprofileparamsList.get(0).getDetectionStatus();
                    detectionDate = sdf.format(new Date(careprofileparamsList.get(0).getLastDetection() * 1000));
//                    System.out.println("user id " + careprofileparamsList.get(0).getUserInRoleId()
//                            + " frailty status " + careprofileparamsList.get(0).getFrailtyStatus());
                }

                itemList.add(new C4ACareReceiverListResponse(users.getUserInRoleId(), age, frailtyStatus, frailtyNotice, attention, textline,
                        interventionstatus, interventionDate, detectionStatus, detectionDate));
            }//detectionVariables loop    
            response.setItemList(itemList);

        }//end detectionVariables is empty

        return response;

    }//end method
}//end class
