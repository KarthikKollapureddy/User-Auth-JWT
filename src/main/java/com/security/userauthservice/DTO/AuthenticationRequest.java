package com.security.userauthservice.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationRequest {
    @NotNull(message = "Email is required")
    @NotBlank(message = "Email can not be blank or empty")
    @Email(message = "Email should be valid")
    @Schema(description = "Email address", example = "john.doe@example.com", defaultValue = "john.doe@example.com")
    private String email;
    @NotNull(message = "Password is required")
    @Schema(description = "User's password", example = "password123", defaultValue = "password123")
    private String password;
}
