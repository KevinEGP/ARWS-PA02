package com.example.Services;

import org.json.JSONObject;

public interface IHttpConectionServices {

    JSONObject getAllCases() throws CoronavirusStatsServicesException;

    JSONObject getCasesByCountry(String country) throws CoronavirusStatsServicesException;

    JSONObject getCordsOfCountry (String country) throws CoronavirusStatsServicesException;

}