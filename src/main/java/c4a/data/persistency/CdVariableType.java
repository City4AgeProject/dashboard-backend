/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.persistency;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cd_variable_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CdVariableType.findAll", query = "SELECT c FROM CdVariableType c"),
    @NamedQuery(name = "CdVariableType.findByVariableType", query = "SELECT c FROM CdVariableType c WHERE c.variableType = :variableType"),
    @NamedQuery(name = "CdVariableType.findByVariableDescription", query = "SELECT c FROM CdVariableType c WHERE c.variableDescription = :variableDescription")})
public class CdVariableType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "variable_type")
    private String variableType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "variable_description")
    private String variableDescription;
    
    public CdVariableType() {
    }

    public CdVariableType(String variableType) {
        this.variableType = variableType;
    }

    public CdVariableType(String variableType, String variableDescription) {
        this.variableType = variableType;
        this.variableDescription = variableDescription;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public String getVariableDescription() {
        return variableDescription;
    }

    public void setVariableDescription(String variableDescription) {
        this.variableDescription = variableDescription;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (variableType != null ? variableType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdVariableType)) {
            return false;
        }
        CdVariableType other = (CdVariableType) object;
        if ((this.variableType == null && other.variableType != null) || (this.variableType != null && !this.variableType.equals(other.variableType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c4a.data.persistency.CdVariableType[ variableType=" + variableType + " ]";
    }
    
}
