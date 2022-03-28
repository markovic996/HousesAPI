package com.realstaq.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DbData {
    @JsonProperty("houses")
    private List<House> houses;

    public List<House> getHouses() {
        return houses;
    }

    public DbData setHouses(List<House> houses) {
        this.houses = houses;
        return this;
    }
}
