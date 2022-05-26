/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.resources;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.avbravo.mongodbatlasdriver.model.Country;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@Path("/country")
//@Tag(name = "Config Retrieval service", description = "Get the value for user")
public class CountryController {

    @Inject
    MongoClient mongoClient;
    


    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Country> get() {
        System.out.println("...> paso 1");
        MongoDatabase database = mongoClient.getDatabase("autentification");
        System.out.println("...> paso 2");
        MongoCollection<Document> collection = database.getCollection("country");
        System.out.println("...> paso 3");
        Document doc = collection.find(eq("idcountry", "PA")).first();
        System.out.println("...> paso 4");
        //  System.out.println(doc.toJson());
        Jsonb jsonb = JsonbBuilder.create();
        Country country = jsonb.fromJson(doc.toJson(), Country.class);
        List<Country> list = new ArrayList<>();
        list.add(country);
        return list;
    }

}
