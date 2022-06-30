/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository.implementations;

import com.avbravo.mongodbatlasdriver.model.Pais;
import com.avbravo.mongodbatlasdriver.repository.PaisRepository;
import com.avbravo.mongodbatlasdriver.repository.PaisRepository;
import com.avbravo.mongodbatlasdriver.repository.PaisRepository;
import com.avbravo.mongodbatlasdriver.supplier.PaisSupplier;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
//@Stateless
public class PaisRepositoryImpl implements PaisRepository {

    // <editor-fold defaultstate="collapsed" desc="metodo">

    @Inject
    private Config config;

    @Inject
    @ConfigProperty(name = "mongodb.uri")
    private String mongodburi;
 
    @Inject
    MongoClient mongoClient;
// </editor-fold>
    @Override
    public List<Pais> findAll() {

        List<Pais> list = new ArrayList<>();
        try {
            MongoDatabase database = mongoClient.getDatabase("world");    
            MongoCollection<Document> collection = database.getCollection("pais");
            MongoCursor<Document> cursor = collection.find().iterator();
            
            try {
                while (cursor.hasNext()) {
                    Pais pais = PaisSupplier.get(Pais::new,cursor.next());
                    list.add(pais);
                }
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }
        return list;
    }

    @Override
    public Optional<Pais> findById(String id) {

        try {
            MongoDatabase database = mongoClient.getDatabase("world");
            MongoCollection<Document> collection = database.getCollection("pais");
            Document doc = collection.find(eq("idpais", id)).first();
            
              Pais pais = PaisSupplier.get(Pais::new,doc);
//            Jsonb jsonb = JsonbBuilder.create();
//            Pais pais = jsonb.fromJson(doc.toJson(), Pais.class);
            return Optional.of(pais);
        } catch (Exception e) {
            System.out.println("findById() " + e.getLocalizedMessage());
        }

        return Optional.empty();
    }

    @Override
    public Pais save(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pais> findByPais(String contry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
