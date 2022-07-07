package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec;
    // RequestSpecification  request'i daha spesifik hale getirir
    // protected koyduk ki child'ler kullanabilsin

    @Before  // her test method'undan once @Before sayesinde setUp() methodu calisacak
    public void setUp(){

        spec= new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
        //RequestSpecBuilder() bu constructor sayesinde setBaseUri() kullanarak base url'i set edebiliyorum
        // ve build() ile olusturmus oldum
    }
}
