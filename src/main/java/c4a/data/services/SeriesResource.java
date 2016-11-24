/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.data.services;

import c4a.data.persistency.Items;
import c4a.data.persistency.Series;
import c4a.data.util.HibernateUtil;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import otn.mobile.bl.C4ASeriesResponse;
import otn.mobile.bl.C4AServiceGetItemssListResponse;

/**
 *
 * @author EMantziou
 */
@Stateless
@Path("series")
public class SeriesResource {

    private static Session session = HibernateUtil.getSessionFactory().openSession();

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
        if (!session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        if (!session.getTransaction().isActive()) {
            session.beginTransaction();
        }

        series = (Series) session.get(Series.class, 3);

        query = (TypedQuery) session.createQuery("SELECT i FROM Items i WHERE  i.id.id = :seriesId ");
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
        //close session
        session.close();
        HibernateUtil.shutdown();

        return response;
    }

}//end class
