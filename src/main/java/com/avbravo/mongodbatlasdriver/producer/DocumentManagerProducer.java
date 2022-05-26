package com.avbravo.mongodbatlasdriver.producer;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.bson.Document;

@ApplicationScoped
public class DocumentManagerProducer {

    private String uri = "mongodb+srv://javscazsd:4yCVcAwmTAatgVs0@cluster0.gjt6v.mongodb.net/?retryWrites=true&w=majority;";
//    @Inject
//    @ConfigProperty(name = "document")
//    private DocumentCollectionManager manager;
//


    @Produces
    public MongoClient mongoClient() {
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            System.out.println("------------> llego al @producer....");

            try {
                System.out.println("...> paso 1");
                MongoDatabase database = mongoClient.getDatabase("autentification");
                System.out.println("...> paso 2");
                MongoCollection<Document> collection = database.getCollection("user");
                System.out.println("...> paso 3");
                Document doc = collection.find(eq("username", "aristides.villarreal")).first();
                System.out.println("...> paso 4");
                System.out.println(doc.toJson());

                System.out.println("Connected successfully to server.");
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
            if (mongoClient == null) {
                System.out.println(" mongoClient es null");
            } else {
                System.out.println(" mongoclient no es null");
            }
            return mongoClient;
        }

//          System.out.println("-->paso 1");
//                MongoClientURI uri = new MongoClientURI(mongodbsrv);
//                System.out.println("-->paso 2");
//MongoClient mongoClient = new MongoClient(uri);
//System.out.println("-->paso 3");
////MongoDatabase database = mongoClient.getDatabase("test");
//MongoDatabase database = mongoClient.getDatabase("autentification");
//System.out.println("-->paso 4");
//       return manager;
    }
//
//    public void destroy(@Disposes DocumentCollectionManager manager) {
//        manager.close();
//    }
}
