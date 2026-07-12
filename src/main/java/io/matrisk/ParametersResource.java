package io.matrisk;

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
            return new ProcessParameters(processId, Map.of("TaskOne",
                    Map.of("param11", "value1", "param12", "value2"), "TaskTwo",
                    Map.of("param1A", "valueA", "param1B", "valueB")));
        }
        return new ProcessParameters(processId, Map.of("TaskOne",
                Map.of("param21", "value1", "param22", "value2"), "TaskTwo",
                Map.of("param2A", "valueA", "param2B", "valueB")));

    }

}
