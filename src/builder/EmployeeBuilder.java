package builder;

import controller.Controller;
import model.CEO;
import model.Employee;
import model.TeamLeader;
import util.eGender;
import util.fields.eEmployeeInputFields;
import util.eRole;

import java.util.*;

import static factory.EmployeeFactory.createEmployee;

public class EmployeeBuilder {

    public static Employee builder(Map<eEmployeeInputFields, String> inputMap) {
        eRole role = eRole.values()[Integer.parseInt(inputMap.get(eEmployeeInputFields.Role))];
        Employee employee = createEmployee(role);
        switch (role){
            case CEO:
                    ((CEO) employee).setTeamLeadersIds(Controller.getAllTeamLeadersIds());

                    break;
            case TeamLeader:
                ((TeamLeader) employee).setEmployeesTeam(new ArrayList<>());
                    break;
        }
        return buildEmployee(inputMap, employee);
    }

    private static Employee buildEmployee(Map<eEmployeeInputFields, String> inputMap, Employee employee) {
        employee.
                setSalary(inputMap.get(eEmployeeInputFields.Salary)).
                setRole(eRole.values()[Integer.parseInt(inputMap.get(eEmployeeInputFields.Role))]).
                setAddress(inputMap.get(eEmployeeInputFields.Address)).
                setAge(Integer.parseInt(inputMap.get(eEmployeeInputFields.Age))).
                setGender(eGender.values()[Integer.parseInt(inputMap.get(eEmployeeInputFields.Gender))]).
                setFirstName(inputMap.get(eEmployeeInputFields.FirstName)).
                setLastName(inputMap.get(eEmployeeInputFields.LastName)).
                setPersonalId(inputMap.get(eEmployeeInputFields.PersonalId)).
                setPhoneNumber(inputMap.get(eEmployeeInputFields.PhoneNumber));

        return employee;
    }
}
