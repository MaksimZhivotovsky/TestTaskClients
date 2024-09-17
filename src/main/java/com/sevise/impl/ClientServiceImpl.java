package com.sevise.impl;

import com.dto.ClientDto;
import com.dto.ContactDto;
import com.entity.Client;
import com.mapper.ClientMapper;
import com.repository.ClientRepository;
import com.sevise.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto) {

        Client client = ClientMapper.toClient(clientDto);
        clientRepository.save(client);
        return clientDto;
    }

    @Override
    public List<ClientDto> getAllClients(Integer offset, Integer limit) {

        List<Client> clientList = clientRepository.findAll(PageRequest.of(offset, limit)).stream().toList();

        return clientList.stream()
                .map(ClientMapper::toClientDto)
                .toList();
    }

    @Override
    public ClientDto getById(Long id) {
        return ClientMapper.toClientDto(clientRepository.findById(id));
    }

    @Override
    public List<ContactDto> getAllContactByClientId(Long id) {

        Client client = clientRepository.findById(id);

        return ClientMapper.toClientDto(client).getContactList();
    }
}
