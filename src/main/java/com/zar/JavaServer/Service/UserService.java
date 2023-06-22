package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.User;
import com.zar.JavaServer.Entity.UserClient;

import java.util.List;


public interface UserService {
    //User getUserByLoginAndPassword(String login, String password);

    List<User> getUsersList();

    User getUserById(short id);

    List<User> getWorkerList();
    List<User> getWorkerList(Integer id);

    void AddUserClient(UserClient userClient);

    void DelUserClient(UserClient userClient);
}
