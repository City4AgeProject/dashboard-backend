/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.persistency;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "detection_variable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetectionVariable.findAll", query = "SELECT d FROM DetectionVariable d"),
    @NamedQuery(name = "DetectionVariable.findByDetectionVariableId", query = "SELECT d FROM DetectionVariable d WHERE d.detectionVariableId = :detectionVariableId"),
    @NamedQuery(name = "DetectionVariable.findByDetectionVariableName", query = "SELECT d FROM DetectionVariable d WHERE d.detectionVariableName = :detectionVariableName"),
    @NamedQuery(name = "DetectionVariable.findByValidFrom", query = "SELECT d FROM DetectionVariable d WHERE d.validFrom = :validFrom"),
    @NamedQuery(name = "DetectionVariable.findByValidTo", query = "SELECT d FROM DetectionVariable d WHERE d.validTo = :validTo")})
public class DetectionVariable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detection_variable_id")
    private Integer detectionVariableId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "detection_variable_name")
    private String detectionVariableName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valid_from")
    private long validFrom;
    @Column(name = "valid_to")
    private BigInteger validTo;
    
    @JoinColumn(name = "detection_variable_type", referencedColumnName = "variable_type")
    @ManyToOne(optional = false)
    private CdVariableType detectionVariableType;
   
    @JoinColumn(name = "parent_factor_id", referencedColumnName = "detection_variable_id")
    @ManyToOne
    private DetectionVariable parentFactorId;

    public DetectionVariable() {
    }

    public DetectionVariable(Integer detectionVariableId) {
        this.detectionVariableId = detectionVariableId;
    }

    public DetectionVariable(Integer detectionVariableId, String detectionVariableName, long validFrom) {
        this.detectionVariableId = detectionVariableId;
        this.detectionVariableName = detectionVariableName;
        this.validFrom = validFrom;
    }

    public Integer getDetectionVariableId() {
        return detectionVariableId;
    }

    public void setDetectionVariableId(Integer detectionVariableId) {
        this.detectionVariableId = detectionVariableId;
    }

    public String getDetectionVariableName() {
        return detectionVariableName;
    }

    public void setDetectionVariableName(String detectionVariableName) {
        this.detectionVariableName = detectionVariableName;
    }

    public long getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(long validFrom) {
        this.validFrom = validFrom;
    }

    public BigInteger getValidTo() {
        return validTo;
    }

    public void setValidTo(BigInteger validTo) {
        this.validTo = validTo;
    }

   
    public CdVariableType getDetectionVariableType() {
        return detectionVariableType;
    }

    public void setDetectionVariableType(CdVariableType detectionVariableType) {
        this.detectionVariableType = detectionVariableType;
    }

    public DetectionVariable getParentFactorId() {
        return parentFactorId;
    }

    public void setParentFactorId(DetectionVariable parentFactorId) {
        this.parentFactorId = parentFactorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detectionVariableId != null ? detectionVariableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetectionVariable)) {
            return false;
        }
        DetectionVariable other = (DetectionVariable) object;
        if ((this.detectionVariableId == null && other.detectionVariableId != null) || (this.detectionVariableId != null && !this.detectionVariableId.equals(other.detectionVariableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c4a.data.persistency.DetectionVariable[ detectionVariableId=" + detectionVariableId + " ]";
    }
    
}
