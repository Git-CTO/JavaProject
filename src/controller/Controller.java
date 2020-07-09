package controller;

import builder.EmployeeBuilder;
import builder.TaskBuilder;
import database.DataService;
import model.Employee;
import model.Task;
import view.EmployeeCreationUi;
import view.TaskCreationUI;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    public static Employee newEmployee() {
        Employee employee = EmployeeBuilder.builder(new EmployeeCreationUi().getInputFromUserToCreateEmployee());
        DataService.addEmployee(employee);

        return employee;
    }

    public static Employee getEmployeeByID(String employeeId) {
        List<Employee> employeeByIdList = getEmployeeList().stream().filter(
                employee -> employee.getPersonalId().equals(employeeId) || employee.getEmployeeId().equals(employeeId))
                .collect(Collectors.toList());

        return employeeByIdList.get(0);
    }

    public static List<Employee> getEmployeeList(){
        return DataService.getEmployeeList();
    }


    public static Task createTaskForEmployeeById(String id) {
        Task task = TaskBuilder.taskBuilder(new TaskCreationUI().getInputFromUserToCreateTask());
        List<Task> tasksFromDB = DataService.getTasksFromDB();
        task.setEmployeeId(id);
        tasksFromDB.add(task);
        DataService.saveTaskToDB(tasksFromDB);
        initTasksToEmployees();
        getEmployeeList().forEach(System.out::println);

        return task;
    }

    public static void initTasksToEmployees() {
        List<Task> tasksFromDB = DataService.getTasksFromDB();

        tasksFromDB.forEach(task -> getEmployeeByID(task.getEmployeeId()).addTask(task));
    }
}
