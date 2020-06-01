package com.example.demo.POJO;

import java.util.*;

public class DevelopmentSummaryRow {

    private Condition condition;
    private boolean conditionActiveDevelopment;
    private int year;
    List<Organization> organizations;
    List<AdministrationRoute> administrationRoutes;


    public DevelopmentSummaryRow() {
        this.condition = null;
        this.conditionActiveDevelopment = false;
        this.year = 2000;
        organizations = new ArrayList<>();
        administrationRoutes = new ArrayList<>();
    }

    public int getYear() {
        return year;
    }

    public Condition getCondition(){
        return condition;
    }

}
