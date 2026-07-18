package io.matrisk;

import java.util.List;

public record ProcessParameters(
    String processName,
    List<TasksParameters> taskParameters
) {}
