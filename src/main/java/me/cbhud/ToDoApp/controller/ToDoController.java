package me.cbhud.ToDoApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @GetMapping("/test")
    public String helloWorld(){
        return "Hello world!";
    }
}
