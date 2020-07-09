package builder;

import model.Employee;
import model.TeamLeader;
import util.eRole;
import util.fields.eEmployeeInputFields;

import java.util.Map;

import static factory.EmployeeFactory.createEmployee;

public class TeamLeaderBuilder extends EmployeeBuilder {

    public static TeamLeader builderTeamLeader(Map<eEmployeeInputFields, String> inputMap){
        TeamLeader teamLeader = (TeamLeader) createEmployee(eRole.TeamLeader);
        EmployeeBuilder.buildEmployee(inputMap,teamLeader);

        return teamLeader;
    }

}
