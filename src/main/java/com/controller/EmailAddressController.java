package com.controller;

import com.dto.EmailAddressDto;
import com.sevise.EmailAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/clients/{id}/email-address")
@Tag(name = "Получение объекта EmailAddress и работа с ним.")
@CrossOrigin
public class EmailAddressController {

    private final EmailAddressService emailAddressService;

    @Operation(summary  = "Добавление нового контакта клиента email адреса")
    @PostMapping
    public ResponseEntity<EmailAddressDto> saveEmailAddress(
            @PathVariable("id") Long clientId,
            @Valid @RequestBody EmailAddressDto emailAddressDto) {
        return new ResponseEntity<>(
                emailAddressService.createEmailAddress(clientId, emailAddressDto), HttpStatus.CREATED);
    }

    @Operation(summary  = "Получение списка контактов заданного типа заданного клиента")
    @GetMapping
    public ResponseEntity<List<EmailAddressDto>> getAllEmailAddressByClientId(
            @PathVariable("id") Long clientId,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit
    ) {
        return new ResponseEntity<>(
                emailAddressService.getAllByClientId(clientId, offset, limit), HttpStatus.CREATED);
    }
}
