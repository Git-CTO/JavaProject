package database;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.Employee;
import model.Task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataService {

    static List<Employee> employeeList;

    public static void init(){
        employeeList = getEmployeesFromDB();
    }

    public static List<Employee> getEmployeesFromDB() {
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader("resources\\employees.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JsonElement jsonElements = JsonParser.parseReader(reader);
        if (!jsonElements.isJsonNull()) {
            Type employeeListType = new TypeToken<List<Employee>>() {
            }.getType();
            employeeList = gson.fromJson(jsonElements, employeeListType);
        } else {
            employeeList = new ArrayList<>();
        }

        return employeeList;
    }

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static List<Task> getTasksFromDB() {
        Gson gson = new Gson();
        JsonReader reader = null;
        List<Task> taskList;

        try {
            reader = new JsonReader(new FileReader("resources\\tasks.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        JsonElement jsonElements = JsonParser.parseReader(reader);
        if (!jsonElements.isJsonNull()) {
            Type TaskListType = new TypeToken<List<Task>>() {
            }.getType();
            taskList = gson.fromJson(jsonElements, TaskListType);
        } else {
            taskList = new ArrayList<>();
        }

        return taskList;
    }

    public static void addEmployee(Employee employee) {
        List<Employee> employeeList = getEmployeesFromDB();
        if (employeeList.size()>0){
            String lastId = employeeList.get(employeeList.size()-1).getEmployeeId();
            employee.setEmployeeId((Integer.parseInt(lastId)+ 1) + "");
        }
        else {
            employee.setEmployeeId("1");
        }
        employeeList.add(employee);
        saveEmployeesToDB(employeeList);
        createNewUserForEmployeeToLogin(employee);
    }

    private static void createNewUserForEmployeeToLogin(Employee employee) {
        Map<String, String> usersFromDB = getUsersFromDB();
        usersFromDB.put(employee.getEmployeeId()+"@hit",employee.getPersonalId());
        saveUsersToDB(usersFromDB);
    }

    public static void saveEmployeesToDB(List<Employee> employeeList) {
        Gson gson = new Gson();

        try (FileWriter file = new FileWriter("resources\\employees.json")) {
            file.write(gson.toJson(employeeList));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTasksToDB(List<Task> task) {
        Gson gson = new Gson();

        try (FileWriter file = new FileWriter("resources\\tasks.json")) {
            file.write(gson.toJson(task));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getUsersFromDB() {
        Gson gson = new Gson();
        JsonReader reader = null;
        Map<String, String> usersMap;

        try {
            reader = new JsonReader(new FileReader("resources\\users.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        JsonElement jsonElements = JsonParser.parseReader(reader);
        if (!jsonElements.isJsonNull()) {
            Type TaskListType = new TypeToken<Map<String, String>>() {
            }.getType();
            usersMap = gson.fromJson(jsonElements, TaskListType);
        } else {
            usersMap = new HashMap<>();
        }

        return usersMap;
    }

    public static void saveUsersToDB(Map<String, String> usersMap) {
        Gson gson = new Gson();

        try (FileWriter file = new FileWriter("resources\\users.json")) {
            file.write(gson.toJson(usersMap));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
