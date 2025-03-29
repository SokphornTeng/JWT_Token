package com.SpringSecurity.My_Test.Practice_3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SecurityController {

    @GetMapping("/home")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("This is public user");
    }

    @GetMapping("/user")
    public ResponseEntity<String> userNormal(){
        return ResponseEntity.ok("I am user normal");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> userAdmin(){
        return ResponseEntity.ok("I am user admin");
    }

}
