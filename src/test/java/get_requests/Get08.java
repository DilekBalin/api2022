package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {

    // De- Serialization: Json formatından Java objesine çevirmektir
    //Serialization: Java objesini JSON formatına çevirmek
    //De-Serialization ve Serialization 2 türlü yapılır.
    //Gson:(Google tarafından üretilmiştir, pek kullanmaaycağız)
    //Object Mapper: Daha popülerdir bunu kullanacağız





    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get01() {
        //1.Step: Step the url
        spec.pathParams("first", "todos", "second", 2);

        //2.step: Set the expected data
        Map<String, Object> expectedData = new HashMap<>();//key'ler String ancak value'ler karsik oldugu icin Object dedik
        //Map'in icersinie bekledigim datalari koyabilirim
        expectedData.put("userId", 1);
        //id 'yi yapmaya gerek yok
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        //Map'in icine digerlerini de ekleyebilirim
        expectedData.put("StatusCode", 200);
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        //assertion yapacagimiz tum datalari bir Map'in icine hapsettik


        //3.Step: Send the request and  get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualData = response.as(HashMap.class); //response icindekileri Map'e cevirdik
        response.prettyPrint();

        //4.Step: Do Assertion
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("StatusCode"), response.getStatusCode()); //ilkini Map'ten,digerini response'dan cagiriyprum
        assertEquals(expectedData.get("Via"), response.getHeader("Via"));
        assertEquals(expectedData.get("Server"), response.getHeader("Server"));

    }

    @Test
    public void get02() {
        //1.Step: Step the url
        spec.pathParams("first", "todos", "second", 2);

        //2.step: Set the expected data
        JsonPlaceHolderTestData expectedData=new JsonPlaceHolderTestData();
        Map<String,Object> expectedDataMap=expectedData.expectedDataWithAllKeys(1,"quis ut nam facilis et officia qui",false);
        expectedDataMap.put("StatusCode",200);
        expectedDataMap.put("Via","1.1 vegur");
        expectedDataMap.put("Server","cloudflare");

        //3.Step: Send the request and  get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        //4.Step:
        assertEquals(expectedDataMap.get("userId"), actualData.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualData.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualData.get("completed"));
        assertEquals(expectedDataMap.get("StatusCode"), response.getStatusCode()); //ilkini Map'ten,digerini response'dan cagiriyprum
        assertEquals(expectedDataMap.get("Via"), response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"), response.getHeader("Server"));

    }
}