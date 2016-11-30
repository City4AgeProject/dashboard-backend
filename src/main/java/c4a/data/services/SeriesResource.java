/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.services;

import c4a.data.persistency.Items;
import c4a.data.persistency.Series;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import c4a.mobile.bl.C4ASeriesResponse;
import c4a.mobile.bl.C4AServiceGetItemssListResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author EMantziou
 */
@Stateless
@Path("series")
public class SeriesResource {

 @PersistenceContext(unitName = "c4AServicesPlatformPU")
    private EntityManager em;

    public void init() {
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("c4AServicesPlatformPU");
        em = factory.createEntityManager();
    }
    
    @GET
    @Path("test/{SeriesID}")
    @Consumes("application/json")
    @Produces("application/json")
    public C4ASeriesResponse getJson(@PathParam("SeriesID") String SeriesID  ) throws IOException {
        /**
         * ****************Variables*************
         */
        C4ASeriesResponse response = new C4ASeriesResponse();
        TypedQuery query;

        List<Items> itemssparamsList;
        Series series;
        ArrayList<C4AServiceGetItemssListResponse> itemList = null;

        /**
         * ****************Action*************
         */
        
        if (em == null) {
            init();
        }


        series = (Series) em.find(Series.class, 3);

        query = (TypedQuery) em.createQuery("SELECT i FROM Items i WHERE  i.id.id = :seriesId ");
        query.setParameter("seriesId", Integer.parseInt(SeriesID));

        if (series == null) {
            response.setMessage("No series found");
            response.setResponseCode(0);
            response.setSeriesName("");
            response.setItemList(null);
            return response;
        }

        //we use list to avoid "not found" exception
        itemssparamsList = query.getResultList();

        if (itemssparamsList.isEmpty()) {
            response.setMessage("No items found for this serie");
            response.setResponseCode(0);
            response.setSeriesName("");
            response.setItemList(null);
        } else {
            response.setMessage("success");
            response.setResponseCode(10);
            response.setSeriesName(series.getName());

            itemList = new ArrayList<C4AServiceGetItemssListResponse>();
            itemList.add(new C4AServiceGetItemssListResponse(itemssparamsList));
            response.setItemList(itemList);
        }
       

        return response;
    }

}//end class
