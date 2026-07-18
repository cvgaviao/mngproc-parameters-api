package io.matrisk;

import java.util.Map;

public record TasksParameters(
    String name,
    Map<String, String> parameters
) {}
