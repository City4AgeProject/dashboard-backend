/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.persistency;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author EMantziou
 */
@Entity
@Table(name = "series", schema="public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Series.findAll", query = "SELECT s FROM Series s"),
    @NamedQuery(name = "Series.findById", query = "SELECT s FROM Series s WHERE s.id = :id"),
    @NamedQuery(name = "Series.findByName", query = "SELECT s FROM Series s WHERE s.name = :name"),
    @NamedQuery(name = "Series.findByData", query = "SELECT s FROM Series s WHERE s.datas= :datas")})

public class Series implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer id;
   
    private String name;
  
    private String datas;

    public Series() {
    }

    public Series(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

   
    
}
