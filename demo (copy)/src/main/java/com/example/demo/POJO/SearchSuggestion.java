package com.example.demo.POJO;

public class SearchSuggestion {
    private String name;
    private String name_type;
    private int id;
    private int type;


    public SearchSuggestion(){
        this.name = "";
        this.name_type = "";
        this.id = 0;
        this.type = 0;
    }
    public String getName(){
        return this.name;
    }

    public String getNameType(){
        return this.name_type;
    }

    public int getId(){
        return this.id;
    }

    public int getType(){
        return this.type;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNameType(String name_type){
        this.name_type = name_type;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setType(int type){
        this.type = type;

    }

    public boolean equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            SearchSuggestion obj = (SearchSuggestion) object;
            if (this.id == obj.getId() && this.type == obj.getType() && this.name.equals(obj.getName()) && this.name_type.equals(obj.getNameType())) {
                result = true;
            }
        }
        return result;
    }

}
