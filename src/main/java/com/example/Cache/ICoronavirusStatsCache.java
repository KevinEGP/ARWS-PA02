package com.example.Cache;

import com.example.Model.Case;

import java.util.Date;
import java.util.List;

/**
 * The interface Coronavirus stats cache.
 */
public interface ICoronavirusStatsCache {

    /**
     * Add cache.
     *
     * @param name the name
     * @param data the data
     */
    void addCache(String name, List<Case> data);

    /**
     * Gets cache by name.
     *
     * @param name the name
     * @return the cache by name
     */
    List<Case> getCacheByName (String name);

    /**
     * Gets creation date.
     *
     * @param name the name
     * @return the creation date
     */
    Date getCreationDate (String name);

    /**
     * Update cache data.
     *
     * @param name    the name
     * @param newData the new data
     */
    void updateCacheData (String name, List<Case> newData);

    /**
     * Contains cache boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean containsCache (String name);

}