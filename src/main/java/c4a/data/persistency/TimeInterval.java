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
@Table(name = "time_interval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeInterval.findAll", query = "SELECT t FROM TimeInterval t"),
    @NamedQuery(name = "TimeInterval.findByTimeIntervalId", query = "SELECT t FROM TimeInterval t WHERE t.timeIntervalId = :timeIntervalId"),
    @NamedQuery(name = "TimeInterval.findByIntervalStart", query = "SELECT t FROM TimeInterval t WHERE t.intervalStart = :intervalStart"),
    @NamedQuery(name = "TimeInterval.findByIntervalEnd", query = "SELECT t FROM TimeInterval t WHERE t.intervalEnd = :intervalEnd"),
    @NamedQuery(name = "TimeInterval.findByTypicalPeriod", query = "SELECT t FROM TimeInterval t WHERE t.typicalPeriod = :typicalPeriod")})
public class TimeInterval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "time_interval_id")
    private Integer timeIntervalId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interval_start")
    private long intervalStart;
    @Column(name = "interval_end")
    private BigInteger intervalEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "typical_period")
    private String typicalPeriod;
   
    public TimeInterval() {
    }

    public TimeInterval(Integer timeIntervalId) {
        this.timeIntervalId = timeIntervalId;
    }

    public TimeInterval(Integer timeIntervalId, long intervalStart, String typicalPeriod) {
        this.timeIntervalId = timeIntervalId;
        this.intervalStart = intervalStart;
        this.typicalPeriod = typicalPeriod;
    }

    public Integer getTimeIntervalId() {
        return timeIntervalId;
    }

    public void setTimeIntervalId(Integer timeIntervalId) {
        this.timeIntervalId = timeIntervalId;
    }

    public long getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(long intervalStart) {
        this.intervalStart = intervalStart;
    }

    public BigInteger getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(BigInteger intervalEnd) {
        this.intervalEnd = intervalEnd;
    }

    public String getTypicalPeriod() {
        return typicalPeriod;
    }

    public void setTypicalPeriod(String typicalPeriod) {
        this.typicalPeriod = typicalPeriod;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeIntervalId != null ? timeIntervalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeInterval)) {
            return false;
        }
        TimeInterval other = (TimeInterval) object;
        if ((this.timeIntervalId == null && other.timeIntervalId != null) || (this.timeIntervalId != null && !this.timeIntervalId.equals(other.timeIntervalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c4a.data.persistency.TimeInterval[ timeIntervalId=" + timeIntervalId + " ]";
    }
    
}
