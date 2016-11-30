/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.persistency;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "care_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CareProfile.findAll", query = "SELECT c FROM CareProfile c"),
    @NamedQuery(name = "CareProfile.findByUserInRoleId", query = "SELECT c FROM CareProfile c WHERE c.userInRoleId = :userInRoleId"),
    @NamedQuery(name = "CareProfile.findByDetectionSummary", query = "SELECT c FROM CareProfile c WHERE c.detectionSummary = :detectionSummary"),
    @NamedQuery(name = "CareProfile.findByFrailtyStatus", query = "SELECT c FROM CareProfile c WHERE c.frailtyStatus = :frailtyStatus"),
    @NamedQuery(name = "CareProfile.findByAttentionStatus", query = "SELECT c FROM CareProfile c WHERE c.attentionStatus = :attentionStatus"),
    @NamedQuery(name = "CareProfile.findByInterventionStatus", query = "SELECT c FROM CareProfile c WHERE c.interventionStatus = :interventionStatus"),
    @NamedQuery(name = "CareProfile.findByFrailtyNotice", query = "SELECT c FROM CareProfile c WHERE c.frailtyNotice = :frailtyNotice"),
    @NamedQuery(name = "CareProfile.findByCreated", query = "SELECT c FROM CareProfile c WHERE c.created = :created"),
    @NamedQuery(name = "CareProfile.findByLastUpdated", query = "SELECT c FROM CareProfile c WHERE c.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "CareProfile.findByLastDetection", query = "SELECT c FROM CareProfile c WHERE c.lastDetection = :lastDetection"),
    @NamedQuery(name = "CareProfile.findByLastIntervention", query = "SELECT c FROM CareProfile c WHERE c.lastIntervention = :lastIntervention"),
    @NamedQuery(name = "CareProfile.findByDetectionStatus", query = "SELECT c FROM CareProfile c WHERE c.detectionStatus = :detectionStatus")})
public class CareProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_in_role_id")
    private Integer userInRoleId;
    @Size(max = 2147483647)
    @Column(name = "detection_summary")
    private String detectionSummary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "frailty_status")
    private String frailtyStatus;
    @Size(max = 2147483647)
    @Column(name = "attention_status")
    private String attentionStatus;
    @Size(max = 2147483647)
    @Column(name = "intervention_status")
    private String interventionStatus;
    @Size(max = 200)
    @Column(name = "frailty_notice")
    private String frailtyNotice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    private long created;
    @Column(name = "last_updated")
    private long lastUpdated;
    @Column(name = "last_detection")
    private long lastDetection;
    @Column(name = "last_intervention")
    private long lastIntervention;
    @Size(max = 2147483647)
    @Column(name = "detection_status")
    private String detectionStatus;
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "user_in_role_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Userinrole userinrole;
    @JoinColumn(name = "created_by", referencedColumnName = "user_in_role_id")
    @ManyToOne
    private Userinrole createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_in_role_id")
    @ManyToOne
    private Userinrole lastUpdatedBy;

    public CareProfile() {
    }

    public CareProfile(Integer userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public CareProfile(Integer userInRoleId, String frailtyStatus, long created) {
        this.userInRoleId = userInRoleId;
        this.frailtyStatus = frailtyStatus;
        this.created = created;
    }

    public Integer getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(Integer userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public String getDetectionSummary() {
        return detectionSummary;
    }

    public void setDetectionSummary(String detectionSummary) {
        this.detectionSummary = detectionSummary;
    }

    public String getFrailtyStatus() {
        return frailtyStatus;
    }

    public void setFrailtyStatus(String frailtyStatus) {
        this.frailtyStatus = frailtyStatus;
    }

    public String getAttentionStatus() {
        return attentionStatus;
    }

    public void setAttentionStatus(String attentionStatus) {
        this.attentionStatus = attentionStatus;
    }

    public String getInterventionStatus() {
        return interventionStatus;
    }

    public void setInterventionStatus(String interventionStatus) {
        this.interventionStatus = interventionStatus;
    }

    public String getFrailtyNotice() {
        return frailtyNotice;
    }

    public void setFrailtyNotice(String frailtyNotice) {
        this.frailtyNotice = frailtyNotice;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getLastDetection() {
        return lastDetection;
    }

    public void setLastDetection(long lastDetection) {
        this.lastDetection = lastDetection;
    }

    public long getLastIntervention() {
        return lastIntervention;
    }

    public void setLastIntervention(long lastIntervention) {
        this.lastIntervention = lastIntervention;
    }

    public String getDetectionStatus() {
        return detectionStatus;
    }

    public void setDetectionStatus(String detectionStatus) {
        this.detectionStatus = detectionStatus;
    }

    public Userinrole getUserinrole() {
        return userinrole;
    }

    public void setUserinrole(Userinrole userinrole) {
        this.userinrole = userinrole;
    }

    public Userinrole getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Userinrole createdBy) {
        this.createdBy = createdBy;
    }

    public Userinrole getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Userinrole lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userInRoleId != null ? userInRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CareProfile)) {
            return false;
        }
        CareProfile other = (CareProfile) object;
        if ((this.userInRoleId == null && other.userInRoleId != null) || (this.userInRoleId != null && !this.userInRoleId.equals(other.userInRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c4a.data.persistency.CareProfile[ userInRoleId=" + userInRoleId + " ]";
    }
    
}
