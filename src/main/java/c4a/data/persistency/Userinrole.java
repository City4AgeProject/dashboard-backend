/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.persistency;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "userinrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userinrole.findAll", query = "SELECT u FROM Userinrole u"),
    @NamedQuery(name = "Userinrole.findByUserInRoleId", query = "SELECT u FROM Userinrole u WHERE u.userInRoleId = :userInRoleId"),
    @NamedQuery(name = "Userinrole.findByPilotId", query = "SELECT u FROM Userinrole u WHERE u.pilotId = :pilotId"),
    @NamedQuery(name = "Userinrole.findByValidFrom", query = "SELECT u FROM Userinrole u WHERE u.validFrom = :validFrom"),
    @NamedQuery(name = "Userinrole.findByValidTo", query = "SELECT u FROM Userinrole u WHERE u.validTo = :validTo"),
    @NamedQuery(name = "Userinrole.findByStakeholderId", query = "SELECT u FROM Userinrole u WHERE u.stakeholderId = :stakeholderId"),
    @NamedQuery(name = "Userinrole.findBySummary", query = "SELECT u FROM Userinrole u WHERE u.summary = :summary")})
public class Userinrole implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userinrole")
    private CareProfile careProfile;


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_in_role_id")
    private Integer userInRoleId;
    @Column(name = "pilot_id")
    private Integer pilotId;
    @Column(name = "valid_from")
    @Temporal(TemporalType.DATE)
    private Date validFrom;
    @Column(name = "valid_to")
    @Temporal(TemporalType.DATE)
    private Date validTo;
    @Size(max = 20)
    @Column(name = "stakeholder_id")
    private String stakeholderId;
    @Size(max = 500)
    @Column(name = "summary")
    private String summary;
   

    public Userinrole() {
    }

    public Userinrole(Integer userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public Integer getUserInRoleId() {
        return userInRoleId;
    }

    public void setUserInRoleId(Integer userInRoleId) {
        this.userInRoleId = userInRoleId;
    }

    public Integer getPilotId() {
        return pilotId;
    }

    public void setPilotId(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getStakeholderId() {
        return stakeholderId;
    }

    public void setStakeholderId(String stakeholderId) {
        this.stakeholderId = stakeholderId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
        if (!(object instanceof Userinrole)) {
            return false;
        }
        Userinrole other = (Userinrole) object;
        if ((this.userInRoleId == null && other.userInRoleId != null) || (this.userInRoleId != null && !this.userInRoleId.equals(other.userInRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c4a.data.persistency.Userinrole[ userInRoleId=" + userInRoleId + " ]";
    }

    public CareProfile getCareProfile() {
        return careProfile;
    }

    public void setCareProfile(CareProfile careProfile) {
        this.careProfile = careProfile;
    }

 

    
}
