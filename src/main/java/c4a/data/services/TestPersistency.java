/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.services;

import c4a.data.persistency.CareProfile;
import c4a.data.persistency.CdVariableType;
import c4a.data.persistency.CrProfile;
import c4a.data.persistency.DetectionVariable;
import c4a.data.persistency.GereatricFactor;
import c4a.data.persistency.Items;
import c4a.data.persistency.Series;
import c4a.data.persistency.Userinrole;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author EMantziou
 */
public class TestPersistency {

    @PersistenceContext(unitName = "c4AServicesPlatformPU")
    private EntityManager em;

    public void init() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("c4AServicesPlatformPU");
        em = factory.createEntityManager();
    }

    public List<Items> items() {
        if (em == null) {
            init();
        }
        TypedQuery query;

        List<Items> itemssparamsList;
//        Transaction tx = session.beginTransaction();

        query = (TypedQuery) em.createQuery("SELECT i FROM Items i WHERE  i.id.id = :seriesId ");
        query.setParameter("seriesId", 3);

        //we use list to avoid "not found" exception
        itemssparamsList = query.getResultList();

        //close session
        return itemssparamsList;
    }

    public List<DetectionVariable> detectionVariables() {
        TypedQuery query;

        List<DetectionVariable> detectionvarsparamsList;
//        Transaction tx = session.beginTransaction();

        if (em == null) {
            init();
        }

        query = (TypedQuery) em.createQuery("SELECT d FROM DetectionVariable d WHERE d.parentFactorId.detectionVariableId = :gefType ");
        query.setParameter("gefType", 1);

        //we use list to avoid "not found" exception
        detectionvarsparamsList = query.getResultList();

        return detectionvarsparamsList;
    }

    public List<GereatricFactor> gereatricFactor() {
        TypedQuery query;

        List<GereatricFactor> gereatricfactparamsList;
//        Transaction tx = session.beginTransaction();

        if (em == null) {
            init();
        }

        query = (TypedQuery) em.createQuery("SELECT g FROM GereatricFactor g WHERE g.detectionVariableId.detectionVariableId = :varId "
                + "and g.userInRoleId.userInRoleId = :userId");
        query.setParameter("varId", 13);
        query.setParameter("userId", 1);

        //we use list to avoid "not found" exception
        gereatricfactparamsList = query.getResultList();

        return gereatricfactparamsList;
    }

    public static void main(String[] args) throws ParseException {

        Series series;
        List<DetectionVariable> detectionVarsList;

        List<GereatricFactor> gereatricFactList;
        TestPersistency test = new TestPersistency();
        //Make some seriesData for storing in database
//        seriesData.setId(1);
//        seriesData.setName("COKE");
//        seriesData.setCode("C001");
//        seriesData.setPrice(new BigDecimal("18.00"));
//
//        //Save seriesData to database
//        Integer productId =(Integer) session.save(seriesData);
//        session.getTransaction().commit();
        //get data from  database

//        Userinrole userinrole = (Userinrole) em.find(Userinrole.class, 2);
////
//        System.out.println("**************************");
//        System.out.println("username " + userinrole.getStakeholderId());
//        CareProfile careProfile = (CareProfile) session.get(CareProfile.class, 2);
//        System.out.println("**************************");
//        System.out.println("status  " + careProfile.getFrailtyStatus());
//        CrProfile crProfile = (CrProfile) session.get(CrProfile.class, 2);
////
//        System.out.println("**************************");
//        System.out.println("age  " + crProfile.getAge());
//        CdVariableType variableType = (CdVariableType) session.get(CdVariableType.class, "GEF");
//        System.out.println("**************************");
//        System.out.println("variable type " + variableType.getVariableDescription());
        detectionVarsList = test.detectionVariables();

        if (detectionVarsList.isEmpty()) {
            System.out.println(" no resutls");
        } else {

            System.out.println("we have results!!!");
            for (DetectionVariable types : detectionVarsList) {
                System.out.println("name " + types.getDetectionVariableName()
                        + " type name " + types.getDetectionVariableType().getVariableType()
                        + " parent " + types.getParentFactorId().getDetectionVariableName());

            }
        }
//        gereatricFactList = TestPersistency.gereatricFactor();
//
//        if (gereatricFactList.isEmpty()) {
//            System.out.println(" no resutls");
//        } else {
//
//            System.out.println("we have results!!!");
//            for (GereatricFactor factors : gereatricFactList) {
//
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
//                String date = sdf.format(new Date(factors.getTimeIntervalId().getIntervalStart() * 1000));
//
////                Calendar calendar = Calendar.getInstance();
////                Timestamp currentTimestamp = new java.sql.Timestamp(factors.getTimeIntervalId().getIntervalStart() * 1000);
////                System.out.println("timestamp "+currentTimestamp);
//                System.out.println("variable type " + factors.getDetectionVariableId().getDetectionVariableName()
//                        + " of group " + factors.getDetectionVariableId().getDetectionVariableType().getVariableType()
//                        + " when " + date
//                        + " value " + factors.getGefValue());
//
//            }
//        }
//        if (session.getSessionFactory().isOpen()) {
//            System.out.println("yes it's open");
//            session.getSessionFactory().close();
//        } else {
//            System.out.println("not open");
//        }
//        items = (Items) session.get(Items.class, 1);
//        System.out.println("gereatric_item data " + items.getData_item());
        }

    }
