package com.realstaq.testcases.houses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.realstaq.pojo.DbData;
import com.realstaq.pojo.House;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetHousesApiTest {
    private List<House> housesDb;

    @BeforeClass
    public void beforeClass() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();

        File jsonFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("db.json")).toURI());
        DbData dbData = objectMapper.readValue(jsonFile, new TypeReference<>() {
        });

        this.housesDb = dbData.getHouses();
    }

    @Test
    public void testSuccessResponseWithQueryParameters() {

        String city = "Austin";
        int price_gte = 450000;
        int price_lte = 666000;

        List<House> expectedHouses = this.housesDb.stream()
                .filter(house -> house.getCity().equals(city) && house.getPrice() >= price_gte && house.getPrice() <= price_lte)
                .collect(Collectors.toList());

        String uri = "http://localhost:3000/houses?price_gte=" + price_gte + "&price_lte=" + price_lte + "&city=" + city;
        Response response = RestAssured.get(uri);
        Assert.assertEquals(response.getStatusCode(), 200);
        List<House> houses = response.as(new TypeRef<>() {
        });

        for (int i = 0; i < houses.size(); i++) {
            Assert.assertEquals(houses.get(i).getBathrooms(), expectedHouses.get(i).getBathrooms(),"Bathrooms not valid");
            Assert.assertEquals(houses.get(i).getBedrooms(), expectedHouses.get(i).getBedrooms(),"Bedrooms not valid");
            Assert.assertEquals(houses.get(i).getId(), expectedHouses.get(i).getId(),"ID not valid");
            Assert.assertEquals(houses.get(i).getCity(), expectedHouses.get(i).getCity(),"City not valid");
            Assert.assertEquals(houses.get(i).getMls_id(), expectedHouses.get(i).getMls_id(),"Mls_ID not valid");
            Assert.assertEquals(houses.get(i).getMls_listing_id(), expectedHouses.get(i).getMls_listing_id(),"Mls_listing_ID not valid");
            Assert.assertEquals(houses.get(i).getProperty_type(), expectedHouses.get(i).getProperty_type(),"Property_type not valid");
            Assert.assertEquals(houses.get(i).getFormatted_address(), expectedHouses.get(i).getFormatted_address(),"Formatted_adress not valid");
            Assert.assertEquals(houses.get(i).getAddress(), expectedHouses.get(i).getAddress(),"Adress not valid");
            Assert.assertEquals(houses.get(i).getZip(), expectedHouses.get(i).getZip(),"Zip not valid");
            Assert.assertEquals(houses.get(i).getState(), expectedHouses.get(i).getState(),"State not valid");
            Assert.assertEquals(houses.get(i).getLocation(), expectedHouses.get(i).getLocation(),"Location not valid");
            Assert.assertEquals(houses.get(i).getMls_update_date(), expectedHouses.get(i).getMls_update_date(),"Mls_update_date not valid");
            Assert.assertEquals(houses.get(i).getPrice_display(), expectedHouses.get(i).getPrice_display(),"Price_display not valid");
            Assert.assertEquals(houses.get(i).getPrice(), expectedHouses.get(i).getPrice(),"Price not valid");
            Assert.assertEquals(houses.get(i).getSquare_feet(), expectedHouses.get(i).getSquare_feet(),"Square_feet not valid");



        }


    }

    @Test
    public void testEmptyResultSetOnInvalidQueryParameter() {
        String uri = "http://localhost:3000/houses?city=INVALID_VALUE";
        Response response = RestAssured.get(uri);
        Assert.assertEquals(response.getStatusCode(), 200);

        List<House> houses = response.as(new TypeRef<>() {
        });

        Assert.assertEquals(houses.size(), 0);
    }

    @Test
    public void testEmptyResultSetOnInvalidPriceParameters() {
        String city = "Austin";
        int price_gte = 450000;
        int price_lte = 200;
        String uri = "http://localhost:3000/houses?price_gte=" + price_gte + "&price_lte=" + price_lte + "&city=" + city;
        Response response = RestAssured.get(uri);
        Assert.assertEquals(response.getStatusCode(), 200);

        List<House> houses = response.as(new TypeRef<>() {
        });

        Assert.assertEquals(houses.size(), 0);
    }

    @Test
    public void testSuccessWithCorrectNumberOfHouses() {
        String uri = "http://localhost:3000/houses";
        Response response = RestAssured.get(uri);
        Assert.assertEquals(response.getStatusCode(), 200);

        List<House> houses = response.as(new TypeRef<>() {
        });

        Assert.assertEquals(houses.size(), this.housesDb.size());
    }

}
