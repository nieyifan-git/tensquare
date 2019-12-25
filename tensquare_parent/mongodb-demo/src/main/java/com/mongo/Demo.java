package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author 45775
 * @Date 2019/12/18 23:03
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        MongoCredential credential = MongoCredential.createCredential("root", "spitdb", "12345".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017), Arrays.asList(credential));
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        FindIterable<Document> documents = spit.find();
        for (Document document : documents) {
            System.out.println(document.getString("content"));
            System.out.println(document.getString("userId"));
            System.out.println(document.getInteger("vists"));
        }
        mongoClient.close();

    }
}
