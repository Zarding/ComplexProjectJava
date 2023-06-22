package com.zar.JavaServer.Controller;

import com.zar.JavaServer.Service.AdminService;
import com.zar.JavaServer.Service.CalendarService;
import com.zar.JavaServer.Service.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "/admin/users")
    public List getClients(){
        return adminService.getUsers();
    }

    @GetMapping(value = "/admin/services")
    public List getServices(){
        return adminService.getServices();
    }

    @GetMapping(value = "/typeservices")
    public List getTypeServices(){
        return adminService.getTypeServices();
    }
}
