package com.example.demo.POJO;
import java.util.*;


public class DrugRecord {

    String mainName;
    int id;
    int type;
    List<NameCode> codeNames;
    List<NameBrand> brandNames;
    List<NameGeneric> genericNames;
    List<MechanismMolecular> mechanisms;
    DevelopmentSummary ds;

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<NameCode> getCodeNames() {
        return codeNames;
    }

    public void setCodeNames(List<NameCode> codeNames) {
        this.codeNames = codeNames;
    }

    public List<NameBrand> getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(List<NameBrand> brandNames) {
        this.brandNames = brandNames;
    }

    public List<NameGeneric> getGenericNames() {
        return genericNames;
    }

    public void setGenericNames(List<NameGeneric> genericNames) {
        this.genericNames = genericNames;
    }

    public List<MechanismMolecular> getMechanisms() {
        return mechanisms;
    }

    public void setMechanisms(List<MechanismMolecular> mechanisms) {
        this.mechanisms = mechanisms;
    }

    public DevelopmentSummary getDs() {
        return ds;
    }

    public void setDs(DevelopmentSummary ds) {
        this.ds = ds;
    }

    public DrugRecord() {
        this.mainName = "Dummy Drug record test";
        this.id = 0;
        this.type = 0;
        codeNames = new ArrayList<>();
        brandNames = new ArrayList<>();
        genericNames = new ArrayList<>();
        mechanisms = new ArrayList<>();

    }



}
