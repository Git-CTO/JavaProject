package factory;

import model.CEO;
import model.Employee;
import model.TeamLeader;
import util.eRole;

public class EmployeeFactory {
    public static Employee createEmployee(eRole role){
        switch (role){
            case CEO:
                return new CEO();
            case TeamLeader:
                return new TeamLeader();
            default:
                return new Employee();
        }
    }
}
