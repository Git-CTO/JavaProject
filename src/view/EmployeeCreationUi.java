package view;

import util.fields.eEmployeeInputFields;

import java.util.*;

public class EmployeeCreationUi {
    Map<eEmployeeInputFields, String> inputMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public Map<eEmployeeInputFields, String> getInputFromUserToCreateEmployee(){
        System.out.print("First Name: ");
        inputMap.put(eEmployeeInputFields.FirstName ,scanner.nextLine());
        System.out.print("Last Name: ");
        inputMap.put(eEmployeeInputFields.LastName,scanner.nextLine());
        System.out.println("Gender:\n0- Male \n1- Female");
        inputMap.put(eEmployeeInputFields.Gender,scanner.nextLine());
        System.out.print("Personal Id: ");
        inputMap.put(eEmployeeInputFields.PersonalId,scanner.nextLine());
        System.out.print("Age: ");
        inputMap.put(eEmployeeInputFields.Age,scanner.nextLine());
        System.out.print("Phone number: ");
        inputMap.put(eEmployeeInputFields.PhoneNumber,scanner.nextLine());
        System.out.print("Address: ");
        inputMap.put(eEmployeeInputFields.Address,scanner.nextLine());
        System.out.print("Salary: ");
        inputMap.put(eEmployeeInputFields.Salary,scanner.nextLine());
        System.out.println("Role:");
        System.out.println("0- Minor Worker \n1- Team Leader \n2- CEO");
        inputMap.put(eEmployeeInputFields.Role,scanner.nextLine());

        return inputMap;
    }

}
