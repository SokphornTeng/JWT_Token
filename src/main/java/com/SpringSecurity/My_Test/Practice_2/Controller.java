package com.SpringSecurity.My_Test.Practice_2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/admin")
    public ResponseEntity<String> userAdmin(){
        return ResponseEntity.ok("I am user admin");
    }

}
