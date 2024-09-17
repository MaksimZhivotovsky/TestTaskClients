package com.controller;

import com.dto.PhoneNumberDto;
import com.sevise.PhoneNumberService;
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
@RequestMapping(value = "/api/v1/clients/{id}/phone-number")
@Tag(name = "Получение объекта PhoneNumber и работа с ним.")
@CrossOrigin
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    @Operation(summary  = "Добавление нового контакта клиента телефонного номера")
    @PostMapping
    public ResponseEntity<PhoneNumberDto> savePhoneNumber(
            @PathVariable("id") Long clientId,
            @Valid @RequestBody PhoneNumberDto phoneNumberDto) {

        return new ResponseEntity<>(
                phoneNumberService.createPhoneNumber(clientId, phoneNumberDto), HttpStatus.CREATED);
    }

    @Operation(summary  = "Получение списка контактов заданного типа заданного клиента")
    @GetMapping
    public ResponseEntity<List<PhoneNumberDto>> getAllPhoneNumberByClientId(
            @PathVariable("id") Long clientId,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit
    ) {

        return new ResponseEntity<>(
                phoneNumberService.getAllByClientId(clientId, offset, limit), HttpStatus.CREATED);
    }
}
