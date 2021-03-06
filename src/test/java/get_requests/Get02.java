package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {
 /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */
@Test
    public void get01(){
    // 1.Step:  Set the Url
    String url=" https://restful-booker.herokuapp.com/booking/3";

    // 2.Step:  ii) Set the expected data(POT-PUT-PATCH)

    // 3.step: Type code to send request
    Response response=given().when().get(url);
  response.prettyPrint();
    //4.Step: Do Assertion
    response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

    //response body'de bulunana spesifik bir veri nasil assert edilir:
    //assertTrue() methodu parantezin icindeki deger true ise testi gecirir
    assertTrue(response.asString().contains("Not Found"));


    //response body'de spesifik bir verinin bulunmadigi nasil assert edilir:
    //assertFalse() methodu parantezin icindeki deger false ise testi gecirir
    assertFalse(response.asString().contains("TechProEd"));


    assertEquals("Cowboy",response.header("Server")); //server header altinda yer aliyor
 // Server burda bir key ve value'si Cowboy'dur.
    //value'si Cowboy olan headr est midir Cowboy'a? cevap evet ve test passed

    System.out.println(response.header(("Server")));   // Cowboy


}

}
