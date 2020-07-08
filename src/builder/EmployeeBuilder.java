package builder;

import model.Employee;
import util.eGender;
import util.eInputFields;
import util.eRole;

import java.util.*;

import static factory.EmployeeFactory.createEmployee;

public class EmployeeBuilder {

    public static Employee builder(Map<eInputFields, String> inputMap) {
        Employee employee = createEmployee(eRole.junior);
        employee.
                setSalary(inputMap.get(eInputFields.Salary)).
                setAddress(inputMap.get(eInputFields.Address)).
                setAge(Integer.parseInt(inputMap.get(eInputFields.Age))).
                setGender(eGender.values()[Integer.parseInt(inputMap.get(eInputFields.Gender))]).
                setFirstName(inputMap.get(eInputFields.FirstName)).
                setLastName(inputMap.get(eInputFields.LastName)).
                setPersonalId(inputMap.get(eInputFields.PersonalId))
                .setPhoneNumber(inputMap.get(eInputFields.PhoneNumber));

        return employee;
    }
}
