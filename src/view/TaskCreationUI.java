package view;

import util.fields.eTaskInputFields;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskCreationUI {
    public Map<eTaskInputFields, String> getInputFromUserToCreateTask(){
        Scanner scanner = new Scanner(System.in);
        Map<eTaskInputFields, String> inputMap = new HashMap<>();
        System.out.println("--Task Creation--");
        System.out.print("Project Name: ");
        inputMap.put(eTaskInputFields.ProjectName, scanner.nextLine());
        System.out.print("Details: ");
        inputMap.put(eTaskInputFields.Details, scanner.nextLine());
        System.out.print("Priority: \n0- High \n1-Medium \n3-Low ");
        inputMap.put(eTaskInputFields.Priority, scanner.nextLine());

        return inputMap;
    }
}
