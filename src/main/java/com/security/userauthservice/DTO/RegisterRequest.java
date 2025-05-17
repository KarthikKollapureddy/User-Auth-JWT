package com.security.userauthservice.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterRequest {
    @NotNull(message = "First name is required")
    @NotBlank(message = "First name should not be blank")
    @Schema(description = "First name of the user", example = "John", defaultValue = "John")
    private String firstName;
    @Schema(description = "Last name of the user", example = "Doe", defaultValue = "Doe")
    @NotNull(message = "Last name is required")
    @NotBlank(message = "Last name should not be blank")
    private String lastName;
    @NotNull(message = "Email is required")
    @NotBlank(message = "Email can not be blank or empty")
    @Email(message = "Email should be valid")
    @Schema(description = "Email address", example = "john.doe@example.com", defaultValue = "john.doe@example.com")
    private String email;
    @NotNull(message = "Password is required")
    @Schema(description = "User's password", example = "password123", defaultValue = "password123")
    private String password;
    @Schema(description = "User's gender", example = "Male", defaultValue = "Male")
    @NotNull(message = "Gender is required")
    private String gender;
    @NotNull(message = "DOB is required")
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Schema(description = "Date of birth", example = "01/01/2000", defaultValue = "01/01/2000")
    private LocalDate date;
}
