/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.resources;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.avbravo.mongodbatlasdriver.model.Country;
import com.avbravo.mongodbatlasdriver.repository.CountryRepository;
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
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
@Path("/country")
//@Tag(name = "Config Retrieval service", description = "Get the value for user")
public class CountryController {


    @Inject
    CountryRepository countryRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Country> get() {
        List<Country> list = new ArrayList<>();
        try {
            System.out.println("****** CountryController ****");
            list = countryRepository.findAll();

        } catch (Exception e) {
            System.out.println("CountryController.get() " + e.getLocalizedMessage());
        }

        return list;
    }
//    @GET
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Country> get() {
//        List<Country> list = new ArrayList<>();
//        try {
//            System.out.println("****** CountryController ****");
//            System.out.println("...> paso 1....");
//
//          
//            if (testconnection) {
//                System.out.println("##############################################");
//                MongoDatabase database = mongoClient.getDatabase("autentification");
//
//                MongoCollection<Document> collection = database.getCollection("user");
//
//                Document doc = collection.find(eq("username", "iris.higera")).first();
//
//                System.out.println(doc.toJson());
//                System.out.println("##############################################");
//            }
//
//            MongoDatabase database = mongoClient.getDatabase("autentification");
//            System.out.println("...> paso 2...");
//            MongoCollection<Document> collection = database.getCollection("country");
//            System.out.println("...> paso 3...");
//            if (collection == null) {
//                System.out.println("---> collection is null.....");
//            } else {
//                System.out.println("---contando documentos");
//                System.out.println("collection.countDocuments() " + collection.countDocuments());
//            }
//            Document doc = collection.find(eq("idcountry", "PA")).first();
//            System.out.println("...> paso 4...");
//
//            Jsonb jsonb = JsonbBuilder.create();
//            Country country = jsonb.fromJson(doc.toJson(), Country.class);
//            System.out.println("...> paso 5...");
//            list.add(country);
//        } catch (Exception e) {
//            System.out.println("gCountryController.et() " + e.getLocalizedMessage());
//        }
//
//        return list;
//    }

}
