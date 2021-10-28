package com.example.Model;

import java.io.Serializable;

/**
 * The type Case.
 */
public class Case implements Serializable {

    private String city;
    private String province;
    private String country;
    private String lastUpdate;
    private String keyId;
    private int confirmed;
    private int deaths;
    private int recovered;
    private Location location;

    /**
     * Instantiates a new Case.
     */
    public Case(){}

    /**
     * Instantiates a new Case.
     *
     * @param city       the city
     * @param province   the province
     * @param country    the country
     * @param lastUpdate the last update
     * @param keyId      the key id
     * @param confirmed  the confirmed
     * @param deaths     the deaths
     * @param recovered  the recovered
     */
    public Case(String city, String province, String country, String lastUpdate, String keyId, int confirmed, int deaths, int recovered) {
        this.city = city;
        this.province = province;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.keyId = keyId;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.location = new Location(0,0);
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets province.
     *
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets province.
     *
     * @param province the province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets last update.
     *
     * @return the last update
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets last update.
     *
     * @param lastUpdate the last update
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * Gets key id.
     *
     * @return the key id
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * Sets key id.
     *
     * @param keyId the key id
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    /**
     * Gets confirmed.
     *
     * @return the confirmed
     */
    public int getConfirmed() {
        return confirmed;
    }

    /**
     * Sets confirmed.
     *
     * @param confirmed the confirmed
     */
    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * Gets deaths.
     *
     * @return the deaths
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * Sets deaths.
     *
     * @param deaths the deaths
     */
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    /**
     * Gets recovered.
     *
     * @return the recovered
     */
    public int getRecovered() {
        return recovered;
    }

    /**
     * Sets recovered.
     *
     * @param recovered the recovered
     */
    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    /**
     * Gets latlng.
     *
     * @return the latlng
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets latlng.
     *
     * @param latlng the latlng
     */
    public void setLatlng(Location location) {
        this.location = location;
    }
}