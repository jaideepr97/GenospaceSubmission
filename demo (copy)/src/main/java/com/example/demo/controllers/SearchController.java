package com.example.demo.controllers;

import com.example.demo.POJO.DrugRecord;
import com.example.demo.POJO.MechanismMolecular;
import com.example.demo.services.DrugRecordService;
import com.example.demo.services.DrugsByMechcanismService;
import com.example.demo.services.SearchSuggestionService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.POJO.SearchSuggestion;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {
    @RequestMapping(value = "/getSearchSuggestions", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<SearchSuggestion> SuggestionResponse(@RequestParam(name = "searchQuery") String searchq) {
        System.out.println(searchq);
        SearchSuggestionService service = new SearchSuggestionService();
        List<SearchSuggestion> suggestions = service.getSearchSuggestions(searchq);

        return suggestions;
    }



}