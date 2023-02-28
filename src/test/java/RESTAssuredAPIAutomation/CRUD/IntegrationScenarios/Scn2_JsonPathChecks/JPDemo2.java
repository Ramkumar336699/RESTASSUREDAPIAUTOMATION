package RESTAssuredAPIAutomation.CRUD.IntegrationScenarios.Scn2_JsonPathChecks;

import io.restassured.path.json.JsonPath;

public class JPDemo2 {

    public static void main(String[] args) {

        String jsonString = "[\n" +
                "\t{\n" +
                "\t\t\"id\": \"1\",\n" +
                "\t\t\"firstName\": \"Tom\",\n" +
                "\t\t\"lastName\": \"Cruise\",\n" +
                "\t\t\"age\": \"50\",\n" +
                "\t\t\"gender\": \"Male\",\n" +
                "\t\t\"IsMarried\": \"Married\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"2\",\n" +
                "\t\t\"firstName\": \"Maria\",\n" +
                "\t\t\"lastName\": \"Sharapova\",\n" +
                "\t\t\"age\": \"45\",\n" +
                "\t\t\"gender\": \"Female\",\n" +
                "\t\t\"IsMarried\": \"Single\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"3\",\n" +
                "\t\t\"firstName\": \"James\",\n" +
                "\t\t\"lastName\": \"Bond\",\n" +
                "\t\t\"age\": \"55\",\n" +
                "\t\t\"gender\": \"Male\",\n" +
                "\t\t\"IsMarried\": \"Married\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"4\",\n" +
                "\t\t\"firstName\": \"Ravi\",\n" +
                "\t\t\"lastName\": \"Teja\",\n" +
                "\t\t\"age\": \"45\",\n" +
                "\t\t\"gender\": \"Male\",\n" +
                "\t\t\"IsMarried\": \"Married\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"5\",\n" +
                "\t\t\"firstName\": \"Rest\",\n" +
                "\t\t\"lastName\": \"API\",\n" +
                "\t\t\"age\": \"30\",\n" +
                "\t\t\"gender\": \"Female\",\n" +
                "\t\t\"IsMarried\": \"Single\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": \"6\",\n" +
                "\t\t\"firstName\": \"Tarun\",\n" +
                "\t\t\"lastName\": \"TP\",\n" +
                "\t\t\"age\": \"25\",\n" +
                "\t\t\"gender\": \"Male\",\n" +
                "\t\t\"IsMarried\": \"Single\"\n" +
                "\t}\n" +
                "]";


        JsonPath jsonPath = JsonPath.from(jsonString);
        System.out.println("First name of all employees : " +jsonPath.getList("firstName"));
        System.out.println("Age of all Female employees" +jsonPath.getList("findAll{it.gender=='Female'}.age"));
        System.out.println("Last name of all male employees" +jsonPath.getList("findAll{it.gender=='Male'}.lastName"));
        System.out.println("Total number of employees : "+jsonPath.getString("size()"));




    }
}
