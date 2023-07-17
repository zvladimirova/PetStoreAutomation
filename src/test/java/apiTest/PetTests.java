package apiTest;

import apiEndpoints.PetEndPoints;


import apiPayload.Pet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PetTests {

    Faker faker;
    Pet petPayload;

    @BeforeClass
    public void setData() {
        faker = new Faker();
        petPayload = new Pet();

        petPayload.setId(faker.idNumber().hashCode());
        petPayload.setName("Victoria");
        petPayload.setStatus("available");

        HashMap<String,String> categoryyy = new HashMap<>();
        categoryyy.put("id","90");
        categoryyy.put("name", "cat");
        petPayload.setCategory(categoryyy);

        String photoUrls[] = {"SomePhotoCat","SecondPhotoCat"};
        petPayload.setPhotoUrls(photoUrls);



        HashMap<String,String> tagsss = new HashMap<>();
        tagsss.put("id","1");
        tagsss.put("name","BigCitty");
        petPayload.setTags(tagsss);

    }

    @Test(priority = 1)
    public void testAddPet() throws JsonProcessingException {
//  convert payload to json
//        ObjectMapper mapper = new ObjectMapper();
//        //Converting the Object to JSONString
//        String jsonString = mapper.writeValueAsString(petPayload);
//        System.out.println(jsonString);

        Response response = PetEndPoints.addNewPet(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

//    @Test(priority = 2)
//    public void testGetPetByID() {
//        Response response = PetEndPoints.getIdPet(this.petPayload.getId());
//        response.then().log().all();
//        //String body = response.getBody().asString();
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertEquals(response.body().path("name"), "Angel");
//        Assert.assertEquals(response.body().path("status"), "available");
//    }

//    @Test(priority = 3)
//    public void testUpdatePetById() {
//
//        String newName= "Gavril";
//
//        Response response = PetEndPoints.updatePet(this.petPayload.getId(), newName);
//        System.out.println("this is ---------------"+this.petPayload.getId());
//        System.out.println("this is ---------------"+petPayload.getName());
//        response.then().log().body();
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertEquals(response.body().path("type"), "unknown");
//
//    }

//    @Test(priority = 4)
//    public void deleteGetPetByID() {
//        Response response = PetEndPoints.getIdPet(this.petPayload.getId());
//        response.then().log().all();
//        Assert.assertEquals(response.getStatusCode(), 200);
//    }

}
