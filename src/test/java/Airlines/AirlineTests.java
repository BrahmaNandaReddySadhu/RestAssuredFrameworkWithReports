package Airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineTests {

    @Test
    public void createAirline() {

        String baseUri= "https://restful-booker.herokuapp.com/booking";

//        String payload = "{\n" +
//                "    \"firstname\": \"Jim\",\n" +
//                "    \"lastname\": \"Brown\",\n" +
//                "    \"totalprice\": 111,\n" +
//                "    \"depositpaid\": true,\n" +
//                "    \"bookingdates\": {\n" +
//                "        \"checkin\": \"2018-01-01\",\n" +
//                "        \"checkout\": \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\": \"Breakfast\"\n" +
//                "}";

//        Map<String,String> bookingDates= new HashMap<>();
//        bookingDates.put("checkin","2018-01-01");
//        bookingDates.put("checkout","2019-01-01");
//
  //      String payload=Payloads.getCreateAirlinePayload("Jim","Brown",111,true,bookingDates,"Breakfast");

        Map<String,Object>  payload=Payloads.getCreateAirlinePayloadAsMap("Jim","Brown",111,true,"2018-01-01","2019-01-01","Breakfast");

        Response response =RestUtils.performPost(baseUri,payload,new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);


    }

}
