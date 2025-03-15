package Airlines;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateAirlinePayload(String firstName, String lastName, int totalPrice, boolean depositPaid, Map<String, String> bookingDates, String additionalNeeds) {

        return "{\n" +
                "    \"firstname\": \"" + firstName + "\",\n" +
                "    \"lastname\": \"" + lastName + "\",\n" +
                "    \"totalprice\": " + totalPrice + ",\n" +
                "    \"depositpaid\": " + depositPaid + ",\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"" + bookingDates.get("checkin") + "\",\n" +
                "        \"checkout\": \"" + bookingDates.get("checkout") + "\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"" + additionalNeeds + "\"\n" +
                "}";
    }


    public static Map<String, Object> getCreateAirlinePayloadAsMap(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkInDate, String checkoutDate, String additionalNeeds) {
        HashMap<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", checkInDate);
        bookingDates.put("checkout", checkoutDate);
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", firstName);
        payload.put("lastname", lastName);
        payload.put("totalprice", totalPrice);
        payload.put("depositpaid", depositPaid);
        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", additionalNeeds);

        return payload;
    }


}
