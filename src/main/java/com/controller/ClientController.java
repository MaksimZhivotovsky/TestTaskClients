package com.controller;

import com.dto.ContactDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.dto.ClientDto;
import com.sevise.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/clients")
@Tag(name = "Получение объекта Client и работа с ним.")
@CrossOrigin
public class ClientController {
    
    private final ClientService clientService;

    @Operation(summary  = "Добавление нового клиента")
    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@Valid @RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(clientService.createClient(clientDto), HttpStatus.CREATED);
    }

    @Operation(summary  = "Получение информации по заданному клиенту (по id)")
    @GetMapping(value = "/{clientId}")
    public ResponseEntity<ClientDto> getClient(@PathVariable("clientId") Long clientId) {
        return new ResponseEntity<>(clientService.getById(clientId), HttpStatus.OK);
    }

    @Operation(summary  = "Получение списка клиентов")
    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClient(
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit
    ) {
        return new ResponseEntity<>(clientService.getAllClients(offset, limit), HttpStatus.OK);
    }

    @Operation(summary  = "Получение списка контактов заданного клиента")
    @GetMapping(value = "/{clientId}/all-contacts")
    public ResponseEntity<List<ContactDto>> getAllContacts(
            @PathVariable("clientId") Long clientId
    ) {
        return new ResponseEntity<>(clientService.getAllContactByClientId(clientId), HttpStatus.OK);
    }

}
