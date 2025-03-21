package Airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reportings.SetUp;

import java.io.IOException;
import java.util.Map;

@Listeners(SetUp.class)
public class AirlineTests extends AirlineAPI {

    @Test
    public void createAirline() throws IOException {


        // String baseUri= "https://restful-booker.herokuapp.com/booking";

//        String payload = "{\n" +
//                "    \"firstname\": \"Jim\",\n" +
//                "    \"lastname\": \"Brown\",\n" +
//                "    \"totalprice\": 111,\n" +
//                "    \"depositpaid\": true,\n" +
//                "    \"bookingdates\": {\n" +
//                "        \"checkin\": \"2018-01-01\",\n" +
//                "        \"checkout\": \"2019-01-01\"\n" +
//                "    },\n" o+
//                "    \"additionalneeds\": \"Breakfast\"\n" +
//                "}";--

//        Map<String,String> bookingDates= new HashMap<>();
//        bookingDates.put("checkin","2018-01-01");
//        bookingDates.put("checkout","2019-01-01");
//
        //      String payload=Payloads.getCreateAirlinePayload("Jim","Brown",111,true,bookingDates,"Breakfast");


//        String env =System.getProperty("env")== null ? "dev": System.getProperty("env");
//        Map<String,Object> data = JsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
//        String baseUri=data.get("createAirLineEndpoint").toString();
        Map<String, Object> payload = Payloads.getCreateAirlinePayloadAsMap("Jim", "Brown", 111, true, "2018-01-01", "2019-01-01", "Breakfast");
//       Response response =RestUtils.performPost(baseUri,payload,new HashMap<>());
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createAirlineWithFail() {
        Map<String, Object> payload = Payloads.getCreateAirlinePayloadAsMap("Jim", "Brown", 111, true, "2018-01-01", "2019-01-01", "Breakfast");
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 201);
    }


}

