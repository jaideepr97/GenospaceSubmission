package com.example.demo.services;

import com.example.demo.POJO.DrugRecord;
import com.example.demo.POJO.SearchSuggestion;
import com.example.demo.dao.DrugRecordsDao;

import java.util.List;

public class DrugRecordService {
    DrugRecordsDao dao;
    public DrugRecordService(){
        dao = new DrugRecordsDao();
    }

    public DrugRecord getDrugRecords(SearchSuggestion drug) {

        return dao.getDrugRecords(drug);
    }
}
