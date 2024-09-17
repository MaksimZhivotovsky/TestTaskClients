package com.sevise.impl;

import com.dto.PhoneNumberDto;
import com.entity.Client;
import com.entity.PhoneNumber;
import com.mapper.PhoneNumberMapper;
import com.repository.ClientRepository;
import com.repository.PhoneNumberRepository;
import com.sevise.PhoneNumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;
    private final ClientRepository clientRepository;

    @Override
    public PhoneNumberDto createPhoneNumber(Long clientId, PhoneNumberDto phoneNumberDto) {

        Client client = clientRepository.findById(clientId);

        PhoneNumber phoneNumber = PhoneNumberMapper.toPhoneNumber(phoneNumberDto);
        phoneNumber.setClient(client);
        phoneNumberRepository.save(phoneNumber);
        return phoneNumberDto;
    }

    @Override
    public List<PhoneNumberDto> getAllByClientId(Long clientId, Integer offset, Integer limit) {

        List<PhoneNumber> phoneNumberList = phoneNumberRepository.findAllByClientId(
                clientId, PageRequest.of(offset, limit)
        ).stream().toList();

        return phoneNumberList.stream()
                .map(PhoneNumberMapper::toPhoneNumberDto)
                .toList();
    }
}
