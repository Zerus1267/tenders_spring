package com.skrekoza.tenders_spring.DAO;


import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.DBCollectionFindOptions;
import com.skrekoza.tenders_spring.dmodel.Tender;
import com.skrekoza.tenders_spring.dmodel.User;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DAO {

    private MongoClientURI uri = new MongoClientURI("mongodb+srv://skrekoza:855492@beginner-sutg2.azure.mongodb.net/tenderdata?retryWrites=true&w=majority");
    private MongoClient mongoClient = new MongoClient(uri);
    public DAO(){
        //MongoClientURI uri = new MongoClientURI("mongodb+srv://skrekoza:855492@beginner-sutg2.azure.mongodb.net/tenderdata?retryWrites=true&w=majority");
        //MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("tenderdata");
        System.out.println("Connected MongoDB successfully");
    }

    public User getUser(String username, String password){
        MongoDatabase database = mongoClient.getDatabase("tenderdata");
        MongoCollection<Document> users = database.getCollection("users");
        try {
            Document myDoc = users.find(eq("email", username)).first();
            assert myDoc != null;
            if(String.valueOf(myDoc.get("password")).equals(password)){
                List<DBRef> tenderList = (List<DBRef>) myDoc.get("tenderlist");

                MongoCollection<Document> tender_coll = database.getCollection("tenders");
                List<Tender> user_tender = new ArrayList<>();


                //DBObject query = new BasicDBObject("author.$id", String.valueOf(myDoc.get("_id")));


                for(Document tenderDoc : tender_coll.find(eq("author.$id", String.valueOf(myDoc.get("_id"))))){
                    //System.out.println(document);

                    //DATE FORMAT
                    /*Date starting_date = tenderDoc.getDate("starting_date");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy G 'at' HH:mm:ss z");
                    System.out.println("date: " + dateFormat.format( starting_date ) );*/
                    user_tender.add(new Tender(String.valueOf(tenderDoc.getObjectId("_id")),
                            tenderDoc.getString("tender_id"),
                            tenderDoc.getString("tender_type"),
                            tenderDoc.getInteger("price"),
                            tenderDoc.getString("vault"),
                            tenderDoc.getInteger("min_step_size"),
                            tenderDoc.getInteger("min_step_percentage"),
                            tenderDoc.getString("subjects"),
                            tenderDoc.getString("detailed_subject"),
                            //tenderDoc.getDate("creating_date"),
                            //tenderDoc.getDate("consider_date"),
                            //tenderDoc.getDate("starting_date"),
                            //tenderDoc.getDate("finishing_date"),
                            tenderDoc.getString("status")));
                }

               return new User(String.valueOf(myDoc.get("_id")),String.valueOf(myDoc.get("firstname")),String.valueOf(myDoc.get("lastname")),String.valueOf(myDoc.get("middlename"))
                       ,String.valueOf(myDoc.get("code")),String.valueOf(myDoc.get("phone")),String.valueOf(myDoc.get("email")),
                      String.valueOf(myDoc.get("password")),String.valueOf(myDoc.get("regplace")), user_tender);
            }
            else{
                return null;
            }
        }
        catch (NullPointerException e) {
            return null;
        }

    }

    public void addTender(Tender tender){
        MongoDatabase database = mongoClient.getDatabase("tenderdata");
        MongoCollection<Document> tenders = database.getCollection("tenders");
        Document document = new Document();
        document.put("tender_type", tender.getTender_type());
        document.put("price", tender.getPrice());
        document.put("vault", tender.getVault());
        document.put("min_step_size", tender.getMin_step_size());
        document.put("min_step_percentage", tender.getMin_step_percentage());
        document.put("subjects", tender.getSubjects());
        document.put("status", "Waiting");
        document.put("creating_date", new Date());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        document.put("tender_id", "UA-" + simpleDateFormat.format(date)+"-000"+tenders.countDocuments()+"-a");
        tenders.insertOne(document);
    }

    public String getAllUsers(){
        MongoDatabase database = mongoClient.getDatabase("tenderdata");
        MongoCollection<Document> users = database.getCollection("users");
        BasicDBObject query = new BasicDBObject();
        String rez = "";
        for(Document document : users.find()){

        }
        return rez;
    }

}
