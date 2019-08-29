package com.skrekoza.tenders_spring.dmodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Field("firstname")
    private String firstname;
    @Field("lastname")
    private String lastname;
    @Field("midddlename")
    private String middlename;
    @Field("code")
    private String code;
    @Field("phone")
    private String phone;
    @Field("email")
    private String email;
    @Field("password")
    private String password;
    @Field("regplace")
    private String regplace;

    @DBRef
    @Field("tenderlist")
    private List<Tender> tenderlist;

    public User() {
    }

    public User(String id, String firstname, String lastname, String middlename, String code, String phone, String email, String password, String regplace) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.code = code;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.regplace = regplace;
    }

    public User(String id, String firstname, String lastname, String middlename, String code, String phone, String email, String password, String regplace, List<Tender> tenderlist) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.code = code;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.regplace = regplace;
        this.tenderlist = tenderlist;
    }

    private String showTenders(){
        StringBuilder tenders = new StringBuilder();
        for(Tender tender : tenderlist){
            tenders.append(tender.toString());
            tenders.append(" | ");
        }
        return String.valueOf(tenders);
    }

    @Override
    public String toString() {
        return "User [id = ]" + id + "; firstname = " + firstname + "; lastname = " + lastname + "; middlename = " + "; code = " + code + "; phone = " + phone + "; tenderlist: [" + showTenders() + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegplace() {
        return regplace;
    }

    public void setRegplace(String regplace) {
        this.regplace = regplace;
    }

    public List<Tender> getTenderlist() {
        return tenderlist;
    }

    public void setTenderlist(List<Tender> tenderlist) {
        this.tenderlist = tenderlist;
    }
}
