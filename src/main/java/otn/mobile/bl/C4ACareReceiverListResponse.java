/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otn.mobile.bl;

/**
 *
 * @author EMantziou
 */
public class C4ACareReceiverListResponse {
    private int userId;
    
    private int age;
    
    private String frailtyStatus;
    
    private String frailtyNotice;
    
    private String attention;
    
    private String textline;
    
    private String interventionstatus;
    
    private String interventionDate;
    
    private String detectionStatus;
    
    private String detectionDate;


    public C4ACareReceiverListResponse(int userId, int age, String frailtyStatus, String frailtyNotice, String attention, String textline, String interventionstatus, String interventionDate, String detectionStatus, String detectionDate) {
        this.userId = userId;
        this.age = age;
        this.frailtyStatus = frailtyStatus;
        this.frailtyNotice = frailtyNotice;
        this.attention = attention;
        this.textline = textline;
        this.interventionstatus = interventionstatus;
        this.interventionDate = interventionDate;
        this.detectionStatus = detectionStatus;
        this.detectionDate = detectionDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFrailtyStatus() {
        return frailtyStatus;
    }

    public void setFrailtyStatus(String frailtyStatus) {
        this.frailtyStatus = frailtyStatus;
    }

    public String getFrailtyNotice() {
        return frailtyNotice;
    }

    public void setFrailtyNotice(String frailtyNotice) {
        this.frailtyNotice = frailtyNotice;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getTextline() {
        return textline;
    }

    public void setTextline(String textline) {
        this.textline = textline;
    }

    public String getInterventionstatus() {
        return interventionstatus;
    }

    public void setInterventionstatus(String interventionstatus) {
        this.interventionstatus = interventionstatus;
    }

    public String getInterventionDate() {
        return interventionDate;
    }

    public void setInterventionDate(String interventionDate) {
        this.interventionDate = interventionDate;
    }

    public String getDetectionStatus() {
        return detectionStatus;
    }

    public void setDetectionStatus(String detectionStatus) {
        this.detectionStatus = detectionStatus;
    }

    public String getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(String detectionDate) {
        this.detectionDate = detectionDate;
    }
    
    
    
}//end class
