package apiEndpoints;

import static io.restassured.RestAssured.*;

import apiPayload.Pet;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

import java.awt.*;

public class PetEndPoints {

    public static Response addNewPet(Pet payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postPetUrl);

        return response;
    }

    public static Response getIdPet(int petId) {
        Response response = given()
                .pathParam("petId", petId)
                .when()
                .get(Routes.getPetIdUrl);

                return response;
    }

    public static Response updatePet(int petId, String nameN){

       Response response = given()
                .contentType(ContentType.URLENC)
                .accept(ContentType.JSON)
                .formParam("name", nameN)
                .pathParam("petId",petId)
                //.body(payload)
                .when()
                .post(Routes.updatePetUrl);

        return response;


    }

    public static Response deletePetById(int petId) {
        Response response = given()
                .pathParam("petId", petId)
                .when()
                .delete(Routes.deletePetUrl);

        return response;
    }

}
