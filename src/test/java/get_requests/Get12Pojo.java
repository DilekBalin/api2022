package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12Pojo extends HerOkuAppBaseUrl {
   /* Given
    https://restful-booker.herokuapp.com/booking/18
    When
    I send GET Request to the URL
            Then
    Status code is 200
    And
    Response body is like {

    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 112,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": null
}


    */
    @Test
    public void getPojo01(){

        //1.Step: set the url
        spec.pathParams("first", "booking","second",18);

        //2. step: Set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2013-02-23","2014-10-23");
        BookingPojo bookingPojo=new BookingPojo("Sally","Brown",111,true,bookingDatesPojo,null);

        //3.Step: Send the GEt Request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //4.step: Do assertion
       BookingPojo actualPojo= response.as(BookingPojo.class);  //En buyuk pojo yu class olarak aliyoruz ve asil pojomuz budur
        assertEquals(200,response.getStatusCode());


       assertEquals(bookingPojo.getFirstname(),actualPojo.getFirstname());
       assertEquals(bookingPojo.getLastname(),actualPojo.getLastname());
       assertEquals(bookingPojo.getTotalprice(),actualPojo.getTotalprice());
       assertEquals(bookingPojo.getDepositpaid(),actualPojo.getDepositpaid());
       assertEquals(bookingPojo.getAdditinalneeds(),actualPojo.getAdditinalneeds());

       //1.Yol:
       assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBookingdates().getCheckin());
       assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBookingdates().getCheckout());

       //2.Yol:
        assertEquals(bookingDatesPojo.getCheckin(),actualPojo.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualPojo.getBookingdates().getCheckout());





    }

    }

