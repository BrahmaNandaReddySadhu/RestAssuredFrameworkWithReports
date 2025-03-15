package Airlines;

import java.util.Map;

public class Payloads {

    public static String getCreateAirlinePayload(String firstName, String lastName, int totalPrice , boolean depositPaid, Map<String,String> bookingDates, String additionalNeeds ){

        return "{\n" +
                "    \"firstname\": \""+firstName+"\",\n" +
                "    \"lastname\": \""+lastName+"\",\n" +
                "    \"totalprice\": "+totalPrice+",\n" +
                "    \"depositpaid\": "+depositPaid+",\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \""+bookingDates.get("checkin")+"\",\n" +
                "        \"checkout\": \""+bookingDates.get("checkout")+"\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \""+additionalNeeds+"\"\n" +
                "}";
    }



}
