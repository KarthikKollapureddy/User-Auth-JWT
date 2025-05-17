package com.security.userauthservice.service;

import com.security.userauthservice.DTO.AuthenticationRequest;
import com.security.userauthservice.DTO.AuthenticationResponse;
import com.security.userauthservice.DTO.RegisterRequest;
import com.security.userauthservice.DTO.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface AppUserAuthenticationService {
    RegisterResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
