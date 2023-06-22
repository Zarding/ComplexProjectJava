package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Service;
import com.zar.JavaServer.Entity.TypeService;
import com.zar.JavaServer.Entity.User;

import java.util.List;

public interface AdminService {
    List<User> getUsers();

    List<Service> getServices();
    List<TypeService> getTypeServices();
}
