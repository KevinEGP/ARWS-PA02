package com.example.Cache.impl;

import com.example.Cache.ICoronavirusStatsCache;
import com.example.Model.Case;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.javatuples.Pair;
import org.springframework.stereotype.Service;

/**
 * The type Coronavirus stats cache.
 */
@Service
public class CoronavirusStatsCache implements ICoronavirusStatsCache {

    private Map< String, Pair<Date, List<Case>> > cache;

    /**
     * Instantiates a new Coronavirus stats cache.
     */
    public CoronavirusStatsCache ( ) {
        this.cache = new ConcurrentHashMap<String,Pair<Date, List<Case>>>();
    }

    @Override
    public void addCache(String name, List<Case> data){
        Pair<Date, List<Case> > tuple = new Pair<Date, List<Case> > (new Date(), data);
        cache.put(name, tuple);
    }

    @Override
    public List<Case> getCacheByName (String name){
        return cache.get(name).getValue1();
    }

    @Override
    public Date getCreationDate (String name){
        return cache.get(name).getValue0();
    }

    @Override
    public void updateCacheData (String name, List<Case> newData){
        Pair<Date, List<Case> > tuple = new Pair<Date, List<Case> > (new Date(), newData);
        cache.put(name, tuple);
    }

    @Override
    public boolean containsCache(String name) {
        return cache.containsKey(name);
    }

}