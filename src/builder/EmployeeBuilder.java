package builder;

import model.Employee;
import util.eGender;
import util.fields.eEmployeeInputFields;
import util.eRole;

import java.util.*;

import static factory.EmployeeFactory.createEmployee;

public class EmployeeBuilder {

    public static Employee builder(Map<eEmployeeInputFields, String> inputMap) {
        Employee employee = createEmployee(eRole.junior);
        employee.
                setSalary(inputMap.get(eEmployeeInputFields.Salary)).
                setAddress(inputMap.get(eEmployeeInputFields.Address)).
                setAge(Integer.parseInt(inputMap.get(eEmployeeInputFields.Age))).
                setGender(eGender.values()[Integer.parseInt(inputMap.get(eEmployeeInputFields.Gender))]).
                setFirstName(inputMap.get(eEmployeeInputFields.FirstName)).
                setLastName(inputMap.get(eEmployeeInputFields.LastName)).
                setPersonalId(inputMap.get(eEmployeeInputFields.PersonalId))
                .setPhoneNumber(inputMap.get(eEmployeeInputFields.PhoneNumber));

        return employee;
    }
}
