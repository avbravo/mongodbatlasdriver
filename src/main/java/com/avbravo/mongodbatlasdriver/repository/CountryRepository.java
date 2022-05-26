/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.avbravo.mongodbatlasdriver.model.Country;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.bson.Document;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class CountryRepository implements Serializable{
   @Inject
    private Config config;

    @Inject
    @ConfigProperty(name = "testconnection")
    private Boolean testconnection;
    @Inject
    MongoClient mongoClient;
    
     public List<Country> findAll() {
         System.out.println("[    CountryRepository    ]");
        List<Country> list = new ArrayList<>();
        try {
                 
            if (testconnection) {
                System.out.println("...............testconecction...............");
                MongoDatabase database = mongoClient.getDatabase("autentification");
                 System.out.println(".----getDatabase");
                MongoCollection<Document> collection = database.getCollection("user");
                System.out.println(".----collection");
                Document doc = collection.find(eq("username", "iris.higera")).first();

                System.out.println(doc.toJson());
                System.out.println("##############################################");
            }

            MongoDatabase database = mongoClient.getDatabase("autentification");
            System.out.println("...> paso 2...");
            MongoCollection<Document> collection = database.getCollection("country");
            System.out.println("...> paso 3...");
            if (collection == null) {
                System.out.println("---> collection is null.....");
            } else {
                System.out.println("---contando documentos");
                System.out.println("collection.countDocuments() " + collection.countDocuments());
            }
            Document doc = collection.find(eq("idcountry", "PA")).first();
            System.out.println("...> paso 4...");

            Jsonb jsonb = JsonbBuilder.create();
            Country country = jsonb.fromJson(doc.toJson(), Country.class);
            System.out.println("...> paso 5...");
            list.add(country);
        } catch (Exception e) {
            System.out.println("gCountryController.et() " + e.getLocalizedMessage());
        }
System.out.println("$$$$$$$$$$$$$$$ CountryRepository $$$$$$$$$$$$$$$$$$$$$");
        return list;
    }
    
}
