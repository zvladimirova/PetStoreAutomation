package apiTest;

import apiEndpoints.UserEndPoints;

import apiPayload.User;
import apiPayload.UserDataProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OldUserTests {
    Faker faker;
    User userPayload;
    @BeforeClass
    public void setupData() {
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());


    }
    @Test(priority = 1)
    public void testPostUser() {

        Response response = UserEndPoints.createUser(userPayload);
        System.out.println("resssss - " + response.toString());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUserByName() {

        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test(priority = 3)
    public void testUpdateUserByName() {

        //update data using payload

        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);
        //response.then().log().body().statusCode(200);

        //checking data after update
        Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
        responseAfterUpdate.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName() {

        Response response =  UserEndPoints.deleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),201);



    }

}
