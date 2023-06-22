package com.zar.JavaServer.Service;

import com.zar.JavaServer.ClientRepository;
import com.zar.JavaServer.DocumentRepository;
import com.zar.JavaServer.Entity.Client;
import com.zar.JavaServer.Entity.Document;
import com.zar.JavaServer.Entity.User;
import com.zar.JavaServer.Entity.UserClient;
import com.zar.JavaServer.UserClientRepository;
import com.zar.JavaServer.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final UserClientRepository userClientRepository;
    private final UserRepository userRepository;
    private final DocumentRepository documentRepository;

    public ClientServiceImpl(ClientRepository clientRepository, UserClientRepository userClientRepository, UserRepository userRepository, DocumentRepository documentRepository) {
        super();
        this.clientRepository = clientRepository;
        this.userClientRepository = userClientRepository;
        this.userRepository = userRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Client> getClientsList() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> getClientsListByUserId(short id) {
        return clientRepository.findClientsByUserId(id);
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findByIdClient(id);
    }

    @Override
    public boolean AddClient(short id, Client client) {
        try {
            clientRepository.save(client);
            UserClient usClient = new UserClient();
            usClient.setIdClient(client);
            usClient.setIdUser(this.userRepository.findById(id));
            userClientRepository.save(usClient);
            for (Iterator<Document> it = client.getDocuments().iterator(); it.hasNext(); ) {
                Document f = it.next();
                documentRepository.save(f);
            }
            return true;
        }
        catch (Exception e) {

        }
        return false;
    }

    @Override
    public List<UserClient> getUsersByClientId(Integer id) {
        return userClientRepository.findUsersByClientId(id);
    }
}
