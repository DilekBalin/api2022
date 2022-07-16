package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {
/*    Given
    https://jsonplaceholder.typicode.com/todos
    When
    I send GET Request to the URL
            Then
			 1)Status code is 200
            2)Print all ids greater than 190 on the console
    Assert that there are 10 ids greater than 190
            3)Print all userIds whose ids are less than 5 on the console
    Assert that the number of userIds whose ids are less than 5 is 4
            4)Print all titles whose ids are less than 5
    Assert that "delectus aut autem" is one of the titles whose id is less than 5
            */

    @Test
    public void get01() {
        //1.Step:set the url:
        spec.pathParam("first", "todos");

        //2.step: set the expected data

        //3.Step: Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        //4.step: Do Assertion
       response.then().assertThat().statusCode(200);

       // Print all ids greater than 190 on the console
        JsonPath json=response.jsonPath();
        List<Integer> ids=json.getList("findAll{it.id>190}.id"); //Groovy Language = Java temelli bir programlama dili
        //it--> javadaki this keywordu gibi bi gorev ustlenmistir,bu dosyadaki id'lerden 190 'dan buyuk olanlari cek
        //dis kisma da id yazdik cunku ,id'leri getirmek istiyoruz (title deseydik title'lari getirirdi)ve list konteynirina koyuyoruz

        System.out.println(ids);  // bu calissin diye yukaridaki prettyPrinti yorum yap


     //   Assert that there are 10 ids greater than 190
        assertEquals(10,ids.size());// 10 tane bekliyoruz ve ids'nin size ile karsilastiracagiz

       // 3)Print all userIds whose ids are less than 5 on the console
        List<Integer> ids2=json.getList("findAll{it.id<5}.userId");
        System.out.println(ids2);


        //   Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals(4,ids2.size()); //4 tane bekliyoruzz ve ids2'nun size ile karsilastiracagiz
        System.out.println(ids2);



      // 4) Print all titles whose ids are less than 5
    List<String> titles=json.getList("findAll{it.id<5}.title");
        System.out.println(titles);

      //    Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue(titles.contains("delectus aut autem"));
        //title'lar list'in icinde oldugu icin bizzat contain kullanabildik


    }


}
