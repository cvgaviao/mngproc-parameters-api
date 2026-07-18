package io.matrisk;

import java.util.List;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/processes")
public class ParametersResource {

    @GET
    @Path("{processId}/parameters")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcessParameters getProcessParameters(String processId) {
        return buildProcessParameters(processId);
    }

    private ProcessParameters buildProcessParameters(String processId) {

        if (processId == null || processId.isEmpty()) {
            throw new IllegalArgumentException(
                    "Process ID cannot be null or empty");
        }

        if (processId.equals("calculus_one")) {
            
            var taskOneParameter = new TasksParameters("TaskOne", Map.of("param11", "value1", "param12", "value2"));
            var taskTwoParameter = new TasksParameters("TaskTwo", Map.of("param1A", "valueA", "param1B", "valueB"));
            
            return new ProcessParameters(processId, List.of(taskOneParameter, taskTwoParameter));
        }
        var taskOneParameter = new TasksParameters("TaskOne", Map.of("param11", "value1", "param12", "value2"));
        var taskTwoParameter = new TasksParameters("TaskTwo", Map.of("param1A", "valueA", "param1B", "valueB"));
        var taskThreeParameter = new TasksParameters("TaskThree", Map.of("param3A", "valueA", "param3B", "valueB"));
        
        return new ProcessParameters(processId, List.of(taskOneParameter, taskTwoParameter, taskThreeParameter));

    }

}
