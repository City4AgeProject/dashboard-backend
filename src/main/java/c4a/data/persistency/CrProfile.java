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
@Table(name = "cr_profile")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "CrProfile.findAll", query = "SELECT c FROM CrProfile c"),
//    @NamedQuery(name = "CrProfile.findById", query = "SELECT c FROM CrProfile c WHERE c.id = :id"),
//    @NamedQuery(name = "CrProfile.findByHeight", query = "SELECT c FROM CrProfile c WHERE c.height = :height"),
//    @NamedQuery(name = "CrProfile.findByWeight", query = "SELECT c FROM CrProfile c WHERE c.weight = :weight"),
//    @NamedQuery(name = "CrProfile.findByBloodP", query = "SELECT c FROM CrProfile c WHERE c.bloodP = :bloodP"),
//    @NamedQuery(name = "CrProfile.findByDate", query = "SELECT c FROM CrProfile c WHERE c.date = :date"),
//    @NamedQuery(name = "CrProfile.findByAge", query = "SELECT c FROM CrProfile c WHERE c.age = :age"),
//    @NamedQuery(name = "CrProfile.findByGender", query = "SELECT c FROM CrProfile c WHERE c.gender = :gender")})
public class CrProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "height")
    private Float height;
    @Column(name = "weight")
    private Float weight;
    @Column(name = "blood_p")
    private Float bloodP;
    @Column(name = "date")
    private BigInteger date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private boolean gender;
    @JoinColumn(name = "user_in_role_id", referencedColumnName = "user_in_role_id")
    @ManyToOne
    private Userinrole userInRoleId;

    public CrProfile() {
    }

    public CrProfile(Integer id) {
        this.id = id;
    }

    public CrProfile(Integer id, int age, boolean gender) {
        this.id = id;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getBloodP() {
        return bloodP;
    }

    public void setBloodP(Float bloodP) {
        this.bloodP = bloodP;
    }

    public BigInteger getDate() {
        return date;
    }

    public void setDate(BigInteger date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrProfile)) {
            return false;
        }
        CrProfile other = (CrProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c4a.data.persistency.CrProfile[ id=" + id + " ]";
    }
    
}
