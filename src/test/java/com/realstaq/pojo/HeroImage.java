package com.realstaq.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroImage {
    @JsonProperty("small")
    private String small;

    @JsonProperty("medium")
    private String medium;

    public String getSmall() {
        return small;
    }

    public HeroImage setSmall(String small) {
        this.small = small;
        return this;
    }

    public String getMedium() {
        return medium;
    }

    public HeroImage setMedium(String medium) {
        this.medium = medium;
        return this;
    }
}
