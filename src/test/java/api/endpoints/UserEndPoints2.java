package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

//Create to perform Create,Read,Update,Delete requests to the user API
public class UserEndPoints2 {

    //method created for getting url's from properties file
    static ResourceBundle getURL(){
        ResourceBundle routes = ResourceBundle.getBundle("routes"); //load properties file

        return routes;
    }
    public static Response createUser(User payload) {

        String post_url=getURL().getString("post_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);

        return response;
    }

    public static Response readUser(String username) {

        String get_url=getURL().getString("get_url");
        Response response = given()

                .pathParams("username", username)
                .when()
                .get(get_url);

        return response;
    }

    public static Response updateUser(User payload, String username) {
        String update_url=getURL().getString("update_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParams("username", username)
                .when()
                .put(update_url);

        return response;
    }

    public static Response deleteUser(String username) {
        String delete_url=getURL().getString("delete_url");
        Response response = given()

                .pathParams("username", username)
                .when()
                .delete(delete_url);

        return response;
    }
}
