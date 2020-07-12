package builder;

import model.Task;
import util.ePriority;
import util.eStatus;
import util.fields.eTaskInputFields;

import java.util.GregorianCalendar;
import java.util.Map;

public class TaskBuilder {
    public static Task taskBuilder(Map<eTaskInputFields, String> inputMap) {
        Task task = new Task();

        task
                .setProjectName(inputMap.get(eTaskInputFields.ProjectName))
                .setDetails(inputMap.get(eTaskInputFields.Details))
                .setStatus(eStatus.Not_Started)
                .setEndDate(new GregorianCalendar(2030, 1, 20).getTime())
                .setPriority(ePriority.values()[Integer.parseInt(inputMap.get(eTaskInputFields.Priority))])
                .setTaskId(inputMap.get(eTaskInputFields.TaskId));

        return task;
    }
}
