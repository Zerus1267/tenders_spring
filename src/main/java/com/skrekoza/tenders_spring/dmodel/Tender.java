package com.skrekoza.tenders_spring.dmodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "tenders")
public class Tender {

    @Id
    private String id;
    @Field("tender_id")
    private String tender_id;
    @Field("tender_type")
    private String tender_type;
    @Field("price")
    private int price;
    @Field("vault")
    private String vault;
    @Field("min_step_size")
    private int min_step_size;
    @Field("min_step_percentage")
    private int min_step_percentage;
    @Field("subjects")
    private String subjects;
    @Field("detailed_subject")
    private String detailed_subject;
/*    @Field("subject_category")
    private Category subject_category;*/
    @Field("creating_date")
    private Date creating_date;
    @Field("consider_date")
    private Date consider_date;
    @Field("starting_date")
    private Date starting_date;
    @Field("finishing_date")
    private Date finishing_date;
    /*private String documents;*/
    @Field("status")
    private String status;

    public Tender(String id, String tender_id, String tender_type, int price, String vault, int min_step_size, int min_step_percentage, String subjects, String detailed_subject, String status) {
        this.id = id;
        this.tender_id = tender_id;
        this.tender_type = tender_type;
        this.price = price;
        this.vault = vault;
        this.min_step_size = min_step_size;
        this.min_step_percentage = min_step_percentage;
        this.subjects = subjects;
        this.detailed_subject = detailed_subject;
        this.status = status;
    }

    public Tender(String tender_type, int price, String vault, int min_step_size, int min_step_percentage, String subjects) {
        this.tender_type = tender_type;
        this.price = price;
        this.vault = vault;
        this.min_step_size = min_step_size;
        this.min_step_percentage = min_step_percentage;
        this.subjects = subjects;
    }

    public Tender(String id, String tender_id, String tender_type, Integer price, String vault, Integer min_step_size, Integer min_step_percentage, String subjects, String detailed_subject, Date creating_date, Date consider_date, Date starting_date, Date finishing_date, String status) {
        this.id = id;
        this.tender_id = tender_id;
        this.tender_type = tender_type;
        this.price = price;
        this.vault = vault;
        this.min_step_size = min_step_size;
        this.min_step_percentage = min_step_percentage;
        this.subjects = subjects;
        this.creating_date = creating_date;
        this.consider_date = consider_date;
        this.starting_date = starting_date;
        this.finishing_date = finishing_date;
        this.status = status;
    }

    public Tender(String id, String tender_id, String tender_type, int price, String vault, int min_step_size, int min_step_percentage, String subjects, Date creating_date, Date consider_date, Date starting_date, Date finishing_date, String status) {
        this.id = id;
        this.tender_id = tender_id;
        this.tender_type = tender_type;
        this.price = price;
        this.vault = vault;
        this.min_step_size = min_step_size;
        this.min_step_percentage = min_step_percentage;
        this.subjects = subjects;
        this.creating_date = creating_date;
        this.consider_date = consider_date;
        this.starting_date = starting_date;
        this.finishing_date = finishing_date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "id = " + id + "; tender_id = " + tender_id + "; price = " + price + "; status = " + status;
    }

    public String getPriceString(){
        return price + " " + vault;
    }

    public String getDetailed_subject() {
        return detailed_subject;
    }

    public void setDetailed_subject(String detailed_subject) {
        this.detailed_subject = detailed_subject;
    }

    public String getVault() {
        return vault;
    }

    public void setVault(String vault) {
        this.vault = vault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTender_id() {
        return tender_id;
    }

    public void setTender_id(String tender_id) {
        this.tender_id = tender_id;
    }

    public String getTender_type() {
        return tender_type;
    }

    public void setTender_type(String tender_type) {
        this.tender_type = tender_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMin_step_size() {
        return min_step_size;
    }

    public void setMin_step_size(int min_step_size) {
        this.min_step_size = min_step_size;
    }

    public int getMin_step_percentage() {
        return min_step_percentage;
    }

    public void setMin_step_percentage(int min_step_percentage) {
        this.min_step_percentage = min_step_percentage;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

   /* public Category getSubject_category() {
        return subject_category;
    }

    public void setSubject_category(Category subject_category) {
        this.subject_category = subject_category;
    }*/

    public Date getCreating_date() {
        return creating_date;
    }

    public void setCreating_date(Date creating_date) {
        this.creating_date = creating_date;
    }

    public Date getConsider_date() {
        return consider_date;
    }

    public void setConsider_date(Date consider_date) {
        this.consider_date = consider_date;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public Date getFinishing_date() {
        return finishing_date;
    }

    public void setFinishing_date(Date finishing_date) {
        this.finishing_date = finishing_date;
    }

    /*public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
