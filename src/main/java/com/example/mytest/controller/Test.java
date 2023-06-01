package com.example.mytest.controller;

import com.example.mytest.login.User;
import com.example.mytest.resulters.Resulte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class Test {
    @Autowired
    RestTemplate restTemplate;
    @PostMapping("/login")
    public Resulte login(@RequestBody User user){
        return Resulte.sucess("");
    }
    @GetMapping("/home")
    public void home(){
        System.out.println("sucess!!");
    }
    @GetMapping("/msg")
    public String msg(@RequestParam String id){
        String str="http://localhost:8081/user?id="+id;
        String forObject = restTemplate.getForObject(str, String.class);
        return forObject;
    }
}
