package com.example.demo.services;

import com.example.demo.POJO.MechanismMolecular;
import com.example.demo.POJO.SearchSuggestion;
import com.example.demo.dao.DrugsByMechanismDao;

import java.util.List;

public class DrugsByMechcanismService {
    DrugsByMechanismDao dao;
    public DrugsByMechcanismService(){
        dao = new DrugsByMechanismDao();
    }

    public List<SearchSuggestion> getDrugsByMechanism(MechanismMolecular mechanism) {
        return dao.getDrugsByMechanism(mechanism);
    }
}
