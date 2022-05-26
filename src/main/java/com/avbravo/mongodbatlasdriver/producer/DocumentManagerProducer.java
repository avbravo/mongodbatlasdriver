package com.avbravo.mongodbatlasdriver.producer;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.bson.Document;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class DocumentManagerProducer  {
//public class DocumentManagerProducer implements Serializable {

//    private String uri = "mongodb+srv://javscazsd:4yCVcAwmTAatgVs0@cluster0.gjt6v.mongodb.net/?retryWrites=true&w=majority;";
    @Inject
    private Config config;

    @Inject
    @ConfigProperty(name = "mongodb.uri")
    private String mongodburi;
    @Inject
    @ConfigProperty(name = "testconnection")
    private Boolean testconnection;



    MongoClient mongoClient;

    @Produces
     @ApplicationScoped
    public MongoClient mongoClient() {
        System.out.println("------------>  @producer....");
        
        System.out.println("------------@producer mongodburi " + mongodburi);
        if (mongoClient == null) {
            try ( MongoClient mongoClient = MongoClients.create(mongodburi)) {

                try {
//                   if(testconnection){
//                        MongoDatabase database = mongoClient.getDatabase("autentification");
//                   
//                    MongoCollection<Document> collection = database.getCollection("user");
//                   
//                    Document doc = collection.find(eq("username", "aristides.villarreal")).first();
//                   
//                    System.out.println(doc.toJson());
//                   }
//                   

                    System.out.println("@Produces :{Connected successfully to server.}");
                    
//                       List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
//            databases.forEach(db -> System.out.println(db.toJson()));
//            
            
                } catch (MongoException me) {
                    System.err.println("An error occurred while attempting to run a command: " + me);
                }
                if (mongoClient == null) {
                    System.out.println("@producer mongoClient es null");
                } else {
                    System.out.println("@producer mongoclient no es null");
                }
                this.mongoClient = mongoClient;
                return mongoClient;
            }
        }
        else{
            System.out.println("@Produces --> MongoClient not is null");
        }
return mongoClient;
    }

}
