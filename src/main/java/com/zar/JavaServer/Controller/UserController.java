package com.zar.JavaServer.Controller;

import com.zar.JavaServer.Entity.TypeServicesPlan;
import com.zar.JavaServer.Entity.User;
import com.zar.JavaServer.Entity.UserClient;
import com.zar.JavaServer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/userslist")
    public List getUsers(){
        return userService.getUsersList();
    }

    @GetMapping(value = "/userslist/workers")
    public List getWorkers() { return userService.getWorkerList(); }
    @PostMapping(value = "/login")
    public Map<String,Object> getAuth(@RequestBody User user){
        Map<String,Object> map=new HashMap<>();
        System.out.println("PASS: " + user.getPassword() + " LOGIN: " + user.getId());
        User us = userService.getUserById(user.getId());
        if (us != null){
            map.put("auth",true);
            map.put("id", us.getId());
            map.put("login", us.getLogin());
            if (us.getIdRole().getName().equals("Администратор"))
                map.put("role", Roles.ADMIN);
            else if (us.getIdRole().getName().equals("Руководитель социальной службы"))
                map.put("role", Roles.HEAD_USER);
            else if (us.getIdRole().getName().equals("Социальный работник"))
                map.put("role", Roles.USER);
            else map.put("role", Roles.NONE);
            System.out.println(map.get("role"));
            return map;
        }
        else {
            map.put("auth",false);
            return map;
        }
    }

    @PostMapping(value="/adduserclient")
    public void addUserClient(@RequestBody UserClient userClient){
        userService.AddUserClient(userClient);
    }

    @PostMapping(value="/deluserclient")
    public void delUserClient(@RequestBody UserClient userClient){
        userService.DelUserClient(userClient);
    }
}

enum Roles {
    ADMIN,
    HEAD_USER,
    USER,
    NONE
}
