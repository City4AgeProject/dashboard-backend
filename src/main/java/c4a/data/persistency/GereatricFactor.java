/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.persistency;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "gereatric_factor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GereatricFactor.findAll", query = "SELECT g FROM GereatricFactor g"),
    @NamedQuery(name = "GereatricFactor.findByGereatricFactorId", query = "SELECT g FROM GereatricFactor g WHERE g.gereatricFactorId = :gereatricFactorId"),
    @NamedQuery(name = "GereatricFactor.findByGefValue", query = "SELECT g FROM GereatricFactor g WHERE g.gefValue = :gefValue")})
public class GereatricFactor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gereatric_factor_id")
    private Integer gereatricFactorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gef_value")
    private float gefValue;
    @JoinColumn(name = "detection_variable_id", referencedColumnName = "detection_variable_id")
    @ManyToOne(optional = false)
    private DetectionVariable detectionVariableId;
    @JoinColumn(name = "time_interval_id", referencedColumnName = "time_interval_id")
    @ManyToOne(optional = false)
    private TimeInterval timeIntervalId;
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "user_in_role_id")
    @ManyToOne(optional = false)
    private Userinrole userInRoleId;

    public GereatricFactor() {
    }

    public GereatricFactor(Integer gereatricFactorId) {
        this.gereatricFactorId = gereatricFactorId;
    }

    public GereatricFactor(Integer gereatricFactorId, float gefValue) {
        this.gereatricFactorId = gereatricFactorId;
        this.gefValue = gefValue;
    }

    public Integer getGereatricFactorId() {
        return gereatricFactorId;
    }

    public void setGereatricFactorId(Integer gereatricFactorId) {
        this.gereatricFactorId = gereatricFactorId;
    }

    public float getGefValue() {
        return gefValue;
    }

    public void setGefValue(float gefValue) {
        this.gefValue = gefValue;
    }

    public DetectionVariable getDetectionVariableId() {
        return detectionVariableId;
    }

    public void setDetectionVariableId(DetectionVariable detectionVariableId) {
        this.detectionVariableId = detectionVariableId;
    }

    public TimeInterval getTimeIntervalId() {
        return timeIntervalId;
    }

    public void setTimeIntervalId(TimeInterval timeIntervalId) {
        this.timeIntervalId = timeIntervalId;
    }

    public Userinrole getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(Userinrole userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gereatricFactorId != null ? gereatricFactorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GereatricFactor)) {
            return false;
        }
        GereatricFactor other = (GereatricFactor) object;
        if ((this.gereatricFactorId == null && other.gereatricFactorId != null) || (this.gereatricFactorId != null && !this.gereatricFactorId.equals(other.gereatricFactorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c4a.data.persistency.GereatricFactor[ gereatricFactorId=" + gereatricFactorId + " ]";
    }
    
}
