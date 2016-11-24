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
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author EMantziou
 */
@Entity
//@Table(name = "series_data", schema="public")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "SeriesData.findAll", query = "SELECT s FROM SeriesData s"),
//    @NamedQuery(name = "SeriesData.findById", query = "SELECT s FROM SeriesData s WHERE s.id = :id"),
//    @NamedQuery(name = "SeriesData.findByName", query = "SELECT s FROM SeriesData s WHERE s.name = :name"),
//    @NamedQuery(name = "SeriesData.findByData", query = "SELECT s FROM SeriesData s WHERE s.datas= :datas")})
@XmlRootElement
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
