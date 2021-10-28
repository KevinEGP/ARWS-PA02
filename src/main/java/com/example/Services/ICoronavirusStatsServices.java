package com.example.Services;


import com.example.Model.Case;

import java.util.List;

public interface ICoronavirusStatsServices {

    List<Case> getAllCases() throws CoronavirusStatsServicesException;

    List<Case> getCasesByCountry(String country) throws CoronavirusStatsServicesException;

}   