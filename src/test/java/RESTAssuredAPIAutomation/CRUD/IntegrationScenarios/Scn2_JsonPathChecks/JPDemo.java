package RESTAssuredAPIAutomation.CRUD.IntegrationScenarios.Scn2_JsonPathChecks;

import io.restassured.path.json.JsonPath;

public class JPDemo {

    public static void main(String[] args) {

        String jsonString = "{\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"doe\",\n" +
                "    \"age\": 26,\n" +
                "    \"address\": {\n" +
                "        \"streetAddress\": \"naist street\",\n" +
                "        \"city\": \"Nara\",\n" +
                "        \"postalCode\": \"630-0192\"\n" +
                "    },\n" +
                "    \"phoneNumbers\": [\n" +
                "        {\n" +
                "            \"type\": \"iPhone\",\n" +
                "            \"number\": \"0123-4567-8888\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"home\",\n" +
                "            \"number\": \"0123-4567-8910\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        JsonPath jsonPath = JsonPath.from(jsonString);
        System.out.println("First type of Phone number is "+jsonPath.getString("phoneNumbers[0].type"));
        System.out.println("Get the List of Phone Types" +jsonPath.getList("phoneNumbers.type"));


    }
}
