package com.security.userauthservice.service;

import com.security.userauthservice.DTO.AuthenticationRequest;
import com.security.userauthservice.DTO.AuthenticationResponse;
import com.security.userauthservice.DTO.RegisterRequest;
import com.security.userauthservice.DTO.RegisterResponse;
import com.security.userauthservice.dao.AppUserRepository;
import com.security.userauthservice.entity.AppUser;
import com.security.userauthservice.entity.Roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppUserAuthenticationServiceImpl implements AppUserAuthenticationService {
    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public RegisterResponse register(RegisterRequest request) {
        AppUser user = AppUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .gender(request.getGender())
                .date(request.getDate())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.USER)
                .build();
        userRepository.save(user);
//        String token = jwtService.generateToken(user);
        log.info("User registered successfully");
        return RegisterResponse.builder()
                .message("user with email "+user.getEmail()+" register successfully")
                .build();
    }
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
//        System.out.println("user valid");
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .name(user.getFirstName()+" "+user.getLastName())
                .message("login successful")
                .build();
    }
}
