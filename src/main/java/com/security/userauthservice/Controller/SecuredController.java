package com.security.userauthservice.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/secure")
@RestController
@CrossOrigin(origins = "*")
public class SecuredController {
//    this ReST end point can be accessible only after user login post supplying valid JWT token
    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello World");
    }
}
