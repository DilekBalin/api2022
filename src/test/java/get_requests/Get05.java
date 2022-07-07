package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Adamz" and last name is "Dear"
	  		//buradda sorgulama yapmamiz gerekiyor ,yani query paramtere yapariz
     */

    @Test
    public void test01() {
        //1. Step : Set the Url
        //https://restful-booker.herokuapp.com/booking?firstname=Selma&lastname=Christensen   -->booking 1.parametre, ? ise query parametrelerin basladigini gosterir
        spec.pathParam("first","booking").
                queryParams("firstname","Selma","lastname","Christensen");
        // bu sorgulamayi neden 1.tepte yaptik cunku 1.step'te url'i set etmemiz lazim

        // 2.Step: set the expected data
        // 3.Step: Send the request get the reponse
        Response response= given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4.Step: Do assertion
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));  //bu isme ait id var mi onu test ettik
    }}
