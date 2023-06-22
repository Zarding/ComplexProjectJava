package com.zar.JavaServer.Controller;

import com.zar.JavaServer.Entity.Client;
import com.zar.JavaServer.Entity.Document;
import com.zar.JavaServer.Entity.User;
import com.zar.JavaServer.Entity.UserClient;
import com.zar.JavaServer.Service.CalendarService;
import com.zar.JavaServer.Service.ClientService;
import com.zar.JavaServer.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    private final ClientService clientService;

    private final CalendarService calendarService;

    public ClientController(ClientService clientService, CalendarService calendarService, UserService userService) {
        super();
        this.clientService = clientService;
        this.calendarService = calendarService;
    }

    @GetMapping(value = "/clientslist")
    public List getClients(){
        return clientService.getClientsList();
    }

    @GetMapping(value = "/clientslist/{id}")
    public List getClientsByUserId(@PathVariable("id") short id){
        return clientService.getClientsListByUserId(id);
    }

    @GetMapping(value = "/client/{id}")
    public Client getClientById(@PathVariable("id") Integer id) { return clientService.getClientById(id); }

    @GetMapping(value = "/clientscalendar/{id}")
    public List getCalendarServicesByUserId(@PathVariable("id") short id) { return calendarService.getCalendarServicesByUserId(id); }

    @PostMapping(value="/addclient/{id}")
    public boolean saveClient(@PathVariable("id") short id, @RequestBody Client client){
        return this.clientService.AddClient(id, client);
    }

    @GetMapping(value = "/clientusers/{id}")
    public List getUsersByClientId(@PathVariable("id") Integer id) { return clientService.getUsersByClientId(id); }
}
