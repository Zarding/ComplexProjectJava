package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Client;
import com.zar.JavaServer.Entity.UserClient;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getClientsList();
    List<Client> getClientsListByUserId(short id);
    Client getClientById(Integer id);
    boolean AddClient(short id, Client client);
    List<UserClient> getUsersByClientId(Integer id);
}
