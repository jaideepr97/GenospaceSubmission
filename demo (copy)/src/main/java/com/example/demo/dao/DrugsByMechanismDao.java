package com.example.demo.dao;

import com.example.demo.POJO.MechanismMolecular;
import com.example.demo.POJO.SearchSuggestion;

import java.util.ArrayList;
import java.util.List;

public class DrugsByMechanismDao {
    public DrugsByMechanismDao(){
    }

    public List<SearchSuggestion> getDrugsByMechanism(MechanismMolecular mechanism) {
        System.out.println("reached mechanism dao");
        List<SearchSuggestion> daoResponse = new ArrayList<>();
        SearchSuggestion dummyResponse = new SearchSuggestion();
        dummyResponse.setName("This is a dummy response 1");
        dummyResponse.setId(123);
        daoResponse.add(dummyResponse);
        SearchSuggestion dummyResponse2 = new SearchSuggestion();
        dummyResponse2.setName("This is a dummy response 2");
        dummyResponse2.setId(324);
        daoResponse.add(dummyResponse2);
        return daoResponse;
    }
}
