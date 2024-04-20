package com.SE330.Demo.Controller;

import com.SE330.Demo.Model.ResponseObject;
import com.SE330.Demo.Model.User;
import com.SE330.Demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("")
    ResponseEntity<ResponseObject> addUser(@RequestBody User user){
        User userNew = userService.addUser(user);
        if(userNew!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","User added successfully",userNew)
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseObject("INTERNAL SERVER ERROR","User not added successfully","")
            );
        }
    }
    @GetMapping("")
    ResponseEntity<ResponseObject> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get all users successfully",userService.getAllUser())
        );
    }
}
