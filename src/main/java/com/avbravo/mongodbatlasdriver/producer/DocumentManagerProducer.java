package com.avbravo.mongodbatlasdriver.producer;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
//@Singleton
//@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class DocumentManagerProducer implements Serializable {
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
            MongoClient mongoClient = MongoClients.create(mongodburi);
            System.out.println("@Produces :{Connected successfully to server.}");
        }

//                try {
        if (testconnection) {
//                        MongoDatabase database = mongoClient.getDatabase("autentification");
//                   
//                    MongoCollection<Document> collection = database.getCollection("user");
//                   
//                    Document doc = collection.find(eq("username", "aristides.villarreal")).first();
//                   
//                    System.out.println(doc.toJson());

//                               List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
//            databases.forEach(db -> System.out.println(db.toJson()));
//            
        }
//                   

//                } catch (MongoException me) {
//                    System.err.println("An error occurred while attempting to run a command: " + me);
//                }
        this.mongoClient = mongoClient;
        return mongoClient;

    }
//    @Produces
//   @ApplicationScoped
//    public MongoClient mongoClient() {
//        System.out.println("------------>  @producer....");
//        
//        System.out.println("------------@producer mongodburi " + mongodburi);
//   
//            try ( MongoClient mongoClient = MongoClients.create(mongodburi)) {
//
//                try {
//                   if(testconnection){
////                        MongoDatabase database = mongoClient.getDatabase("autentification");
////                   
////                    MongoCollection<Document> collection = database.getCollection("user");
////                   
////                    Document doc = collection.find(eq("username", "aristides.villarreal")).first();
////                   
////                    System.out.println(doc.toJson());
//                    
////                               List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
////            databases.forEach(db -> System.out.println(db.toJson()));
////            
//                   }
////                   
//
//                    System.out.println("@Produces :{Connected successfully to server.}");
//                    
//            
//            
//                } catch (MongoException me) {
//                    System.err.println("An error occurred while attempting to run a command: " + me);
//                }
//
//          this.mongoClient = mongoClient;
//                return mongoClient;
//            }
//       
//
//    }

    public void close(@Disposes final MongoClient mongoClient) {
        System.out.println("[@Disposes] .....");
        mongoClient.close();
    }

}
