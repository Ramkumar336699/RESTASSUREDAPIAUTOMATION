package RESTAssuredAPIAutomation.GSON_Jackson.Exam3;

import RESTAssuredAPIAutomation.GSON_Jackson.Exam2.Jackson_Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONArrayDemo {

    public static void main(String[] args) throws JsonProcessingException {

        //JSONArray, Array of Employee

        Jackson_Employee emp1 = new Jackson_Employee();
        emp1.setFirstName("Ram kumar");
        emp1.setLastName("Penkey");
        emp1.setAge(30);
        emp1.setGender("Male");
        emp1.setSalary(100000.00);
        emp1.setMarried(true);

        Jackson_Employee emp2 = new Jackson_Employee();
        emp2.setFirstName("Nikitha");
        emp2.setLastName("Penkey");
        emp2.setAge(25);
        emp2.setGender("Female");
        emp2.setSalary(89000.00);
        emp2.setMarried(true);

        List<Jackson_Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        System.out.println(list);

        // Serialize
        ObjectMapper objMapper = new ObjectMapper();
        String json = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        System.out.println(json);

        // Deserialize
        ObjectMapper objMapper1 = new ObjectMapper();
        List<Jackson_Employee> allEmployeeDetails = objMapper.readValue(json, new TypeReference<List<Jackson_Employee>>() {
        });
        for(Jackson_Employee je : allEmployeeDetails){
            System.out.println(je.getFirstName());
        }



    }
}
