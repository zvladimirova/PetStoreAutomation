package apiPayload;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class UserDataProvider {

//    @DataProvider(name = "data-provider")
//    public Object[][] dpMethod(){
//        return new Object[][]
//                {
//                        {"username","password"},
//                        {"username1","password1"},
//                        {"username2","password2"},
//                        {"username3","password3"}
//                };
//    }

    public User singleUser(){
        Faker faker = new Faker();
        User userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

       return userPayload;
    }

    public List<User> multipleUsers(){

        List<User> users = new ArrayList<>();
        for (int i = 0; i<3; i++)
        {
            User user = singleUser();

            users.add(user);
        }

        return users;
    }



}
