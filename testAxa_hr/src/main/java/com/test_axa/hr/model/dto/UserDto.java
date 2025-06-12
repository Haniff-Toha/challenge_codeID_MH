package com.test_axa.hr.model.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
    Long userId,

    @NonNull
    String username,

    @NotBlank(message = "Password is required")
    String password,

    @NotBlank(message = "Role ID is required")
    Long roleId
) {}

