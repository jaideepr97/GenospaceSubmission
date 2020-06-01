package com.example.demo.POJO;

class Organization {
    private int id;
    private String name;

    public Organization(){
        this.id = 0;
        this.name = "";
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
}
