package database;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class DataService {

    public static List<Employee> takeDataFromDb() {
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader("resources\\employees.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
        Type employeeListType = new TypeToken<List<Employee>>(){}.getType();
        List<Employee> employeeList = gson.fromJson(jsonArray, employeeListType);

        return employeeList;
    }

    public static void addEmployee(Employee employee) {
        List<Employee> employeeList = takeDataFromDb();
        employeeList.add(employee);
        saveToDB(employeeList);
    }

    public static void saveToDB(List<Employee> employeeList) {
        Gson gson = new Gson();

        try (FileWriter file = new FileWriter("resources\\employees.json")) {
            file.write(gson.toJson(employeeList));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
