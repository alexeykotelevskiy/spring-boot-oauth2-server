/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oauth2.server;

import com.github.oauth2.server.pojo.Record;
import com.github.oauth2.server.pojo.Responce;
import com.github.oauth2.server.pojo.State;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Aldwin Delgado
 */
@SpringBootApplication
@Controller
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(
            value = "/"
    )
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("{\"message\":\"Home!\"}", HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payments/payment",
            method = RequestMethod.POST
    )
    public ResponseEntity<Responce> createPayment(Record record) {
        return new ResponseEntity<Responce>(new Responce(record.getId()+"", "time", State.CREATED), HttpStatus.OK);
    }
}
