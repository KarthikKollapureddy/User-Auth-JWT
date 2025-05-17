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
public class RegisterResponse {
    @Schema(description = "Register success message", example = "user with email john.doe@example.com register successfully", defaultValue = "user with email john.doe@example.com register successfully")
    private String message;
}
