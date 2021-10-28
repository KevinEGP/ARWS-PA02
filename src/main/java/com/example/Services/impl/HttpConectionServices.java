package com.example.Services.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.example.Services.CoronavirusStatsServicesException;
import com.example.Services.IHttpConectionServices;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class HttpConectionServices implements IHttpConectionServices {

    public HttpConectionServices(){}


    @Override
    public JSONObject getAllCases() throws CoronavirusStatsServicesException {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://rapidapi.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                    .asString();
            return new JSONObject(response.getBody());
        } catch (Exception e) {
            throw new CoronavirusStatsServicesException(e.getMessage());
        }
    }

    @Override
    public JSONObject getCasesByCountry(String country) throws CoronavirusStatsServicesException {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://rapidapi.p.rapidapi.com/v1/stats?country="+country)
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            return jsonObject;
        } catch (Exception e) {
            throw new CoronavirusStatsServicesException(e.getMessage());
        }
    }

    @Override
    public JSONObject getCordsOfCountry (String country) throws CoronavirusStatsServicesException {
        try {
            HttpResponse<String> response = Unirest.get("https://rapidapi.p.rapidapi.com/name/"+country)
                    .header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", "3f5145eca7msh66558870ccb62b4p1cbbe5jsn27893ca387b7")
                    .asString();
            JSONObject jarray = new JSONArray(response.getBody()).getJSONObject(0);
            return jarray;
        } catch (UnirestException e) {
            throw new CoronavirusStatsServicesException(e.getMessage());
        }

    }
}