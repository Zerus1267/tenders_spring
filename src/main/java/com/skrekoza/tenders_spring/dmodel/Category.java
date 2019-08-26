package com.skrekoza.tenders_spring.dmodel;

import org.springframework.data.annotation.Id;

public class Category {

    @Id
    private String id;

    private String code;
    private String ukr_name;
    private String en_name;

    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUkr_name() {
        return ukr_name;
    }

    public void setUkr_name(String ukr_name) {
        this.ukr_name = ukr_name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }
}
