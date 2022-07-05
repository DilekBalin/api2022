import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    1) Postman, manuel API testi icin kullanilir.
    2) API otomasyon testi icin Rest-Asured Library'i kullaniyoruz
    3) Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
      a) Gereksinimleri anlamak
      b) Test case'i yazmak
         i)Test case yazimi icin 'Gerkin Language' kullaniyoruz
             ii) 'Gerkin' bazi keyword'lere sahip.Bunlar:
                  >> Given: On kosullar icin kullaniyoruz
                  >> When: Aksiyonlar icin kullaniyoruz == Get,Put..
                  >> Then: Donutler icin kullaniyoruz  == Assert...
                  >> And: Coklu islemler icin kullaniyoruz


      c) Testing kodunun yazimi   >>> her api tyestinde bu stepleri izleyecegiz

           i) Set the URL
           ii) Set the expected data(POT-PUT-PATCH)
           iii) Type code to send request
           iv) Do Assertion


     */


    /*  >>> end point asagidaki gibidir ve sirket vermek zorunda bu kismi

    Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK >> iki tane and olmasinin sebebi then catisi altinda olmalaridir
     */

    @Test
    public void get01() {

        //   i) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/13";   //  Url'i string conteynira koyduk dinamik olmasi icin

        //  ii) Set the expected data(POT-PUT-PATCH)  >> adimi atladik cunku requestte yok
        //bu adimi atladik cunku bizden get to request istemis


        //  iii) Type code to send request
        Response response = given().when().get(url); //when'den sonra get request yapcaz,get icine url koymamizi istemis
        ///given(), when() birere method cunku arkasinda parantez var
        //kisacaasi url'i bize getircek bu bolum o yuzden response class'ina atadik
         response.prettyPrint();  //sout icine yazmadan bu sekilde consola yazdiririz
        // ve bize json formatinda bilgi getirir,biz id 'si 13 olani cagirdik
        /*

        konsolda bu sekilde verdi ,id yazmazsak tum booking'leri json formatinda verir
        {
    "firstname": "Jim2",
    "lastname": "Brown2",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
         */



        //  iv) Do Assertion  >> karsiilastima yapip dogrulama elde etcegimizi bolum
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //'Status Code' nasil yazdirilir:
        System.out.println("Status Code: "+ response.statusCode());


        //'Content Type ' nasil yazdirilir:
        System.out.println("Content Type: "+ response.contentType());


        //'Status Line' nasil yazdirilir:
        System.out.println("Status Line: "+ response.statusLine());

        //'Header' nasil yazdirilir?   >> hangi basligi yazmak istiyosak onu string seklnde belirtiriz
        System.out.println(response.header("Connection"));

        System.out.println("===========================");

        //'Headers' nasil yazdirilir?   >> tum basliklari getirir :key -value seklinde
        System.out.println("Headers: \n" +response.headers());
        System.out.println("===========================");

        //'Time' nasil yazdirilir?
        System.out.println(response.getTime());



    }


}