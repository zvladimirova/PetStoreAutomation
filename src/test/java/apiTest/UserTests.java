package apiTest;

import apiEndpoints.UserEndPoints;
import apiPayload.UserDataProvider;
import apiPayload.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class UserTests {
    Faker faker;
    User userPayload;
    UserDataProvider userDataProvider;
    public Logger logger;

    //
    @BeforeClass
    public void setupData() {

        this.userDataProvider = new UserDataProvider();
        faker = new Faker();
        userPayload = this.userDataProvider.singleUser();
        logger = (Logger) LogManager.getLogger(this.getClass());
        logger.debug("----debug message------");
    }

    @Test(priority = 1)
    public void testPostUser() {
        logger.info("---Create user-------------");

        Response response = UserEndPoints.createUser(this.userPayload);
        System.out.println("resssss - " + response.toString());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("---User is created-------------");
    }

    @Test(priority = 2)
    public void testGetUserByName() {
        logger.info("---Reading  user information-------------");
        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("---User info is displayed-------------");
    }


    @Test(priority = 3)
    public void testUpdateUserByName() {
        logger.info("---Update user-------------");

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
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("---User is updated-------------");
    }

    @Test(priority = 4)
    public void testDeleteUserByName() {
        logger.info("---Delete user-------------");

       Response response =  UserEndPoints.deleteUser(this.userPayload.getUsername());
       Assert.assertEquals(response.getStatusCode(),200);
        logger.info("---User is deleted-------------");

    }


//    @Test(priority = 5)
//    public void testPostUsers() throws JsonProcessingException {
//
//        List<User> users = this.userDataProvider.multipleUsers();


    // If you want to see payload in json format
//         ObjectMapper mapper = new ObjectMapper();
//        //Converting the Object to JSONString
//        String jsonString = mapper.writeValueAsString(users);
//        System.out.println(jsonString);

//        Response response = UserEndPoints.createMultipleUser(users);
//        response.then().log().all();
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//    }


}
