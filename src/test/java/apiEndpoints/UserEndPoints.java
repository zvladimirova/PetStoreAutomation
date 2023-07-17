package apiEndpoints;
import static io.restassured.RestAssured.*;

import apiPayload.User;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

import java.util.List;


//UserEndPoints.java
//Created for perform Create, Read, Update, Delete requests the user API.

public class UserEndPoints {

    public static Response createUser(User payload){


        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postUrl);

        return response;
    }


    public static Response readUser(String userName){

        Response response = given()
                .pathParam("username",userName)

                .when()
                .get(Routes.getUrl);

        return response;
    }


    public static Response updateUser(String userName, User payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)
                .when()
                .put(Routes.updateUrl);

        return response;
    }

    public static Response deleteUser(String userName){

        Response response = given()
                .pathParam("username",userName)

                .when()
                .delete(Routes.deleteUrl);

        return response;
    }

  public static Response createMultipleUser(List<User> payload){


        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postMultipleUsersUrl);

        return response;
    }

}
