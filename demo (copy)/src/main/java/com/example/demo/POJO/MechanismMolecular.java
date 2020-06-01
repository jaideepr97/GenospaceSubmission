package com.example.demo.POJO;

public class MechanismMolecular {

    private String name;
    private int Id;

    public MechanismMolecular(){
        this.name = "";
        this.Id = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int Id){
        this.Id = Id;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.Id;
    }
}
