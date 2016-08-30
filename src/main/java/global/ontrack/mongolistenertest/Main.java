/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.ontrack.mongolistenertest;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.event.ServerListener;
import java.io.PrintWriter;
import org.bson.Document;

/**
 *
 * @author sanmedina
 */
public class Main {
    public static void main(String[] args) {
        final ServerListener listener = new MyServerListener();
        MongoClientOptions.Builder options = new MongoClientOptions.Builder()
                .addServerListener(listener);
        PrintWriter pw = new PrintWriter(System.out);
        try (MongoClient client = new MongoClient("localhost", options.build())) {
            MongoDatabase db = client.getDatabase("test");
            MongoCollection ttl_collection = db.getCollection("ttl_collection");
            Document doc = (Document) ttl_collection.find().first();
            System.out.println(doc.toJson());
        } catch (MongoException e) {
            e.printStackTrace(pw);
        }
    }
}
