package apiEndpoints;

/*
Swagger URI --> https://petstore.swagger.io

Create user(Post) -- https://petstore.swagger.io/v2/user
Get user (Get) -- https://petstore.swagger.io/v2/user/{username}
Update user(Put) -- https://petstore.swagger.io/v2/user/{username}
Delete user(Delete) -- https://petstore.swagger.io/v2/user/{username}

 */

public class Routes {

    public static String baseUrl = "https://petstore.swagger.io/v2";

    //User module
    public static String postUrl = baseUrl+"/user";
    public static String getUrl = baseUrl+"/user/{username}";
    public static String updateUrl = baseUrl+"/user/{username}";
    public static String deleteUrl = baseUrl+"/user/{username}";
    public static String postMultipleUsersUrl = baseUrl+"/user/createWithList";



    //Store module
    //--Here I will create Store module URL's

    //Pet module

    public static String postPetUrl = baseUrl+"/pet";
    public static String getPetIdUrl = baseUrl+"/pet/{petId}";
    public static String updatePetUrl = baseUrl+"/pet/{petId}";
    public static String deletePetUrl = baseUrl+"/pet/{petId}";
}
