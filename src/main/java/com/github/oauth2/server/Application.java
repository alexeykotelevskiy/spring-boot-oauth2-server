/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oauth2.server;

import com.github.oauth2.server.pojo.InvalidAmountException;
import com.github.oauth2.server.pojo.Record;
import com.github.oauth2.server.pojo.Response;
import com.github.oauth2.server.pojo.State;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Response> createPayment( @RequestHeader("Content-Type") String contentType,
                                                   @RequestBody Record record) {
        System.out.println(record.getTransaction().getDescription());
        if (contentType.equals("application/json")) {
            return new ResponseEntity<Response>(new Response(record.getId() + "", "time", State.CREATED), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity validateFail()
    {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
