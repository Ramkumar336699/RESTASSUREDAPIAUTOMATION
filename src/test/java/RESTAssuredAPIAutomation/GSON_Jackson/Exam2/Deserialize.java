package RESTAssuredAPIAutomation.GSON_Jackson.Exam2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialize  {

    public static void main(String[] args) throws JsonProcessingException {

    String payload = "{\n" +
            "    \"firstName\": \"Ram kumar\",\n" +
            "    \"lastName\": \"Penkey\",\n" +
            "    \"gender\": \"Male\",\n" +
            "    \"age\": 30,\n" +
            "    \"salary\": 100000,\n" +
            "    \"married\": true\n" +
            "  }";

    ObjectMapper objMapper1 = new ObjectMapper();
    Jackson_Employee employee = objMapper1.readValue(payload, Jackson_Employee.class);

    System.out.println(employee.getFirstName());
    System.out.println(employee.getSalary());


    }
}
