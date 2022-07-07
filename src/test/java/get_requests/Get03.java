package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */

    @Test
    public void get01() {
        //1. Set the url
        // String url="https://jsonplaceholder.typicode.com/todos/23"; //onerilmiyor hard coding oldugu icin

        spec.pathParams("first", "todos", "second", 23);
        //pathParams() ===> parametrelerin kisa yolu anlamindadir ve icin istedigimiz parametreleri sirayla ve isimlerini yazarak getiririz.
        //cunku spec ==> bize sadece base url' i getirir


        //2.  Step: set the expected data == bu adimi yapmiyoruz cunku data ile ilgili islem yapmamiz burda henuz istenmiyor


        //3. Step: Send the Request and get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        // spec(spec) ==> base url'i getirir ,get() ise parametreleri getirir,key'leri yazmaliyiz >>>  /{}   ile kac taneyse her biri icin bu yapilir


        //4. Step: Do Assertion
        //1. Yol
        response.then().assertThat().statusCode(200).contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));


        //2. Yol:
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON). // ContenType classindan JSON'i sectik  daha clear oldu
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),
                        "userId", equalTo(2));
        // equalTo() methodu karsilastirma yapar  ornegin  "userId" 2 ye esit mi gibi...
        //"title","completed" ve "userId" bunlar body icinde olduklari icin hepsin body parantezine aldik


        /*
        Note1:
        Assertion yaparken Java calismayi durdurdugunda hata sonrasi kodlar calismaz
        Boylece hata sonrasi assertion'lar hakkinda bilgi sahibi olamayiz
        Fakat  hata oncesi assertion'lar gecmistir.

        Note2:
        Eger kodumuzu hata noktasinda duracak sekilde yazarsak "Hard Assertion" yapmis oluyoruz.

        Note3:
        Eger kodumuzu hata noktasinda durmayacak sekilde yazarsak "Soft Assertion" yapmis oluyoruz.

        Note4:
        Eger coklu body() methodu icinde assert yaparsak "Hard Assertion" olur
        Tek body() methodu icinde yaparsak "Soft Assertion" olur

         */

    }
}
