package com.realstaq.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.naming.LinkLoopException;

public class House {

    @JsonProperty("id")
    private String id;

    @JsonProperty("mls_id")
    private double mls_id;

    @JsonProperty("mls_listing_id")
    private String mls_listing_id;

    @JsonProperty("property_type")
    private String property_type;

    @JsonProperty("formatted_address")
    private String formatted_address;

    @JsonProperty("address")
    private String address;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("location")
    private double[] location;

    @JsonProperty("bedrooms")
    private double bedrooms;

    @JsonProperty("bathrooms")
    private double bathrooms;

    @JsonProperty("list_date")
    private String list_date;

    @JsonProperty("mls_update_date")
    private String mls_update_date;

    @JsonProperty("price_display")
    private String price_display;

    @JsonProperty("price")
    private double price;

    @JsonProperty("square_feet")
    private double square_feet;

    @JsonProperty("hero")
    private HeroImage hero = null;

    public String getId() {
        return id;
    }

    public double getMls_id() {
        return mls_id;
    }

    public String getMls_listing_id() {
        return mls_listing_id;
    }

    public String getProperty_type() {
        return property_type;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public double[] getLocation() {
        return location;
    }

    public double getBedrooms() {
        return bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public String getList_date() {
        return list_date;
    }

    public String getMls_update_date() {
        return mls_update_date;
    }

    public String getPrice_display() {
        return price_display;
    }

    public double getPrice() {
        return price;
    }

    public double getSquare_feet() {
        return square_feet;
    }

    public House setId(String id) {
        this.id = id;
        return this;
    }

    public House setMls_id(double mls_id) {
        this.mls_id = mls_id;
        return this;
    }

    public House setMls_listing_id(String mls_listing_id) {
        this.mls_listing_id = mls_listing_id;
        return this;
    }

    public House setProperty_type(String property_type) {
        this.property_type = property_type;
        return this;
    }

    public House setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
        return this;
    }

    public House setAddress(String address) {
        this.address = address;
        return this;
    }

    public House setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public House setCity(String city) {
        this.city = city;
        return this;
    }

    public House setState(String state) {
        this.state = state;
        return this;
    }

    public House setLocation(double[] location) {
        this.location = location;
        return this;
    }

    public House setBedrooms(double bedrooms) {
        this.bedrooms = bedrooms;
        return this;
    }

    public House setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
        return this;
    }

    public House setList_date(String list_date) {
        this.list_date = list_date;
        return this;
    }

    public House setMls_update_date(String mls_update_date) {
        this.mls_update_date = mls_update_date;
        return this;
    }

    public House setPrice_display(String price_display) {
        this.price_display = price_display;
        return this;
    }

    public House setPrice(double price) {
        this.price = price;
        return this;
    }

    public House setSquare_feet(double square_feet) {
        this.square_feet = square_feet;
        return this;
    }

    public HeroImage getHero() {
        return hero;
    }

    public House setHero(HeroImage hero) {
        this.hero = hero;
        return this;
    }
}
