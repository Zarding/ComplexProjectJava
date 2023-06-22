package com.zar.JavaServer;

import com.zar.JavaServer.Entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long> {
    @Query("select c from Client c where c.id = ?1")
    Client findByIdClient(Integer id);
    @Query("select c from Client c inner join c.userClients userClients where userClients.idUser = ?1")
    List<Client> findClientsByUserId(short idUser);
    List<Client> findAll();
}
