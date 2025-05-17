package com.security.userauthservice.Controller;

import com.security.userauthservice.DTO.AuthenticationRequest;
import com.security.userauthservice.DTO.AuthenticationResponse;
import com.security.userauthservice.DTO.RegisterRequest;
import com.security.userauthservice.DTO.RegisterResponse;
import com.security.userauthservice.service.AppUserAuthenticationService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/noauth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private final AppUserAuthenticationService authenticationService;
    @PostMapping(
            path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request
    ){
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
    }
    @PostMapping(
            path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ) throws Exception {
        return new ResponseEntity<>(authenticationService.authenticate(request), HttpStatus.OK);
    }
    @GetMapping(value = "/greet", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> greet(){
        return new ResponseEntity<>("greetings fella",HttpStatus.OK);
    }
}
