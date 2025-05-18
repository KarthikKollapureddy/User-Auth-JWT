package com.security.userauthservice.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    @Schema(description = "JWT token", example = "Example JWT Token", defaultValue = "JWT Token")
    private String token;
    @Schema(description = "Nane of the user", example = "John doe", defaultValue = "John doe")
    private String name;
    @Schema(description = "login success message", example = "login successful", defaultValue = "login successful")
    private String message;
}
