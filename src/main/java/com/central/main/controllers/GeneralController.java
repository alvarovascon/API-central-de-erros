package com.central.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GeneralController {

    @GetMapping
    public ResponseEntity<String> SendBaseResponse() {
        return new ResponseEntity<>("<h2>Acesse " +
                "<a href=https://api-central-de-erros-java.herokuapp.com/swagger-ui.html#/> " +
                "https://api-central-de-erros-java.herokuapp.com/swagger-ui.html#/</a> " +
                "para conferir a documentação</h2>", HttpStatus.OK);
    }
}
