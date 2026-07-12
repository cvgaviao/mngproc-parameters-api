package io.matrisk;

import java.util.Map;

public record ProcessParameters(
    String processName,
    Map<String, Map<String, String>> taskParameters
) {}
