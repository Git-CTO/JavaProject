package view;

import util.eInputFields;

import java.util.*;

public class EmployeeCreationUi {
    Map<eInputFields, String> inputMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public Map<eInputFields, String> getInputFromUserToCreateEmployee(){
        System.out.print("First Name: ");
        inputMap.put(eInputFields.FirstName ,scanner.nextLine());
        System.out.print("Last Name: ");
        inputMap.put(eInputFields.LastName,scanner.nextLine());
        System.out.println("Gender:\n 0- Male\n1- Female");
        inputMap.put(eInputFields.Gender,scanner.nextLine());
        System.out.print("Personal Id: ");
        inputMap.put(eInputFields.PersonalId,scanner.nextLine());
        System.out.print("Age: ");
        inputMap.put(eInputFields.Age,scanner.nextLine());
        System.out.print("Phone number: ");
        inputMap.put(eInputFields.PhoneNumber,scanner.nextLine());
        System.out.print("Address: ");
        inputMap.put(eInputFields.Address,scanner.nextLine());
        System.out.print("Salary: ");
        inputMap.put(eInputFields.Salary,scanner.nextLine());

        return inputMap;
    }

}
