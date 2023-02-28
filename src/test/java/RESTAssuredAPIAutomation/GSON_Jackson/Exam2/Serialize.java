package RESTAssuredAPIAutomation.GSON_Jackson.Exam2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialize {

    public static void main(String[] args) throws JsonProcessingException {

        Jackson_Employee employee = new Jackson_Employee();

        employee.setFirstName("Ram kumar");
        employee.setLastName("Penkey");
        employee.setAge(30);
        employee.setSalary(100000);
        employee.setGender("Male");
        employee.setMarried(true);

        System.out.println(employee);

        //Doing Serialization through Jackson

        ObjectMapper objMapper = new ObjectMapper();
        String convertToJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(convertToJSON);



    }
}
