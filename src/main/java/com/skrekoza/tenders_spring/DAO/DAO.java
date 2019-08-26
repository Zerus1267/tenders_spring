package com.skrekoza.tenders_spring.DAO;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoOperations;

public class DAO {
    private MongoClientURI uri = new MongoClientURI("mongodb+srv://skrekoza:855492@beginner-sutg2.azure.mongodb.net/tenderdata?retryWrites=true&w=majority");
    private MongoClient mongoClient = new MongoClient(uri);
    public DAO(){
        //MongoClientURI uri = new MongoClientURI("mongodb+srv://skrekoza:855492@beginner-sutg2.azure.mongodb.net/tenderdata?retryWrites=true&w=majority");
        //MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("tenderdata");
        System.out.println("Connected MongoDB successfully");
    }

    public String getAllUsers(){
        MongoDatabase database = mongoClient.getDatabase("tenderdata");
        MongoCollection<Document> users = database.getCollection("users");
        String rez = "";
        for(Document document : users.find()){
            rez += document.toString();
        }
        return rez;
    }

}
