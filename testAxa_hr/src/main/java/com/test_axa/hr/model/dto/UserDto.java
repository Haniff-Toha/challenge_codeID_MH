package com.test_axa.hr.model.dto;

import io.micrometer.common.lang.NonNull;

public record UserDto(
    Long userId,

    @NonNull
    String username,

    // @NotBlank(message = "Password is required")
    String password,

    // @NotNull(message = "Role ID is required")
    Long roleId
) {}

