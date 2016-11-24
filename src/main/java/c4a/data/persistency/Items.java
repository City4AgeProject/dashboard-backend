/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.persistency;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMantziou
 */
@Entity

@XmlRootElement
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer item_id;

    private Integer data_item;
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    @ManyToOne

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id")
    private Series id;

    public Items() {
    }

    public Items(Integer itemId) {
        this.item_id = itemId;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getData_item() {
        return data_item;
    }

    public void setData_item(Integer data_item) {
        this.data_item = data_item;
    }

    public Series getId() {
        return id;
    }

    public void setId(Series id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (item_id != null ? item_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.item_id == null && other.item_id != null) || (this.item_id != null && !this.item_id.equals(other.item_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "c4a.data.persistency.Items[ itemId=" + item_id + " ]";
    }

}
