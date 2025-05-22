package com.codeid.eshopay.model.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer userId;

    @Nonnull
    @Size(max = 15, message = "max char 15")
    private String userName;

    @Nonnull
    @Size(max = 80, message = "max char 80")
    private String userEmail;

    @Nonnull
    @Size(max = 125, message = "max char 125")
    private String userPassword;

    @Nonnull
    @Size(max = 25, message = "max char 25")
    private String userHandphone;

    private Integer locationId;
}
