package RESTAssuredAPIAutomation.DiffTypePayloads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POSTWithListMap {

    public static void main(String[] args) {

        /*
           {
            "firstname" : "Ram kumar",
            "lastname" : "Penkey",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
            "checkin" : "2022-12-25",
            "checkout" : "2022-12-30"
            },
            "additionalneeds" : "Breakfast"
            }
            {
            "firstname" : "Nikitha",
            "lastname" : "Penkey",
            "totalprice" : 112,
            "depositpaid" : false,
            "bookingdates" : {
            "checkin" : "2022-12-20",
            "checkout" : "2022-12-25"
            },
            "additionalneeds" : "Lunch and Dinner"
            }
       */

        // List of Two - Item1 , Item2 --> ArrayList
        // Item 1 - String, String - Map
        // Item 2 - String, String - Map
        // List of Map (Item 1, Item 2)

        Map<String,Object> item1 = new HashMap<>();
        item1.put("firstname","Ram kumar");
        item1.put("lastname","Penkey");
        item1.put("totalprice",111);
        item1.put("depositpaid",true);

        Map<String,String> bookingDateMap1 = new HashMap<>();
        bookingDateMap1.put("checkin","2022-12-25");
        bookingDateMap1.put("checkout","2022-12-30");

        item1.put("bookingdates",bookingDateMap1);
        item1.put("additionalneeds","Breakfast");
        System.out.println(item1);


        Map<String,Object> item2 = new HashMap<>();
        item2.put("firstname","Nikitha");
        item2.put("lastname","Penkey");
        item2.put("totalprice",112);
        item2.put("depositpaid",false);

        Map<String,String> bookingDateMap2 = new HashMap<>();
        bookingDateMap2.put("checkin","2022-12-20");
        bookingDateMap2.put("checkout","2022-12-30");

        item2.put("bookingdates",bookingDateMap2);
        item2.put("additionalneeds","Lunch and Dinner");
        System.out.println(item2);

        List<Map<String,Object>> myList = new ArrayList<>();
        myList.add(item1);
        myList.add(item2);

        System.out.println(myList);


    }
}
