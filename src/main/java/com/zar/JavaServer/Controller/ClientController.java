package com.zar.JavaServer.Controller;

import com.zar.JavaServer.Entity.Client;
import com.zar.JavaServer.Entity.Document;
import com.zar.JavaServer.Entity.User;
import com.zar.JavaServer.Entity.UserClient;
import com.zar.JavaServer.Service.CalendarService;
import com.zar.JavaServer.Service.ClientService;
import com.zar.JavaServer.Service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Получаем имя файла и расширение
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileExtension = FilenameUtils.getExtension(fileName);

            // Проверяем, что файл имеет допустимое расширение
            if (!Arrays.asList("jpg", "jpeg", "png", "gif").contains(fileExtension.toLowerCase())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Недопустимый формат файла");
            }

            // Сохраняем файл на сервере
            String uploadDir = "/uploads/";
            String filePath = uploadDir + fileName;
            Path path = Paths.get(uploadDir);
            System.out.println(path);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            Files.write(Paths.get(filePath), file.getBytes());

            return ResponseEntity.ok("Файл успешно загружен");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка загрузки файла");
        }
    }

    @GetMapping(value = "/clientusers/{id}")
    public List getUsersByClientId(@PathVariable("id") Integer id) { return clientService.getUsersByClientId(id); }
}
