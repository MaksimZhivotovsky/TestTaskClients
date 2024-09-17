package com.mapper;

import com.dto.ClientDto;
import com.dto.ContactDto;
import com.dto.EmailAddressDto;
import com.dto.PhoneNumberDto;
import com.entity.Client;
import com.entity.Contact;
import com.entity.EmailAddress;
import com.entity.PhoneNumber;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ClientMapper {

    private ClientMapper() {}

    public static ClientDto toClientDto(Client client) {

        List<EmailAddressDto> emailAddressDtoList = client.getContactList().stream()
                .filter(contact -> contact instanceof EmailAddress)
                .map((Contact emailAddress) -> EmailAddressMapper.toEmailAddressDto((EmailAddress) emailAddress))
                .toList();
        List<PhoneNumberDto> phoneNumberDtoList = client.getContactList().stream()
                .filter(contact -> contact instanceof PhoneNumber)
                .map((Contact phoneNumber) -> PhoneNumberMapper.toPhoneNumberDto((PhoneNumber) phoneNumber))
                .toList();

        List<ContactDto> contactList = new ArrayList<>();
        contactList.addAll(phoneNumberDtoList);
        contactList.addAll(emailAddressDtoList);

        return ClientDto.builder()
                .name(client.getName())
                .contactList(contactList)
                .build();

    }

    public static Client toClient(ClientDto clientDto) {

        List<EmailAddress> emailAddressDtoList = clientDto.getContactList().stream()
                .filter(contact -> contact instanceof EmailAddressDto)
                .map((ContactDto emailAddressDto) -> EmailAddressMapper.toEmailAddress((EmailAddressDto) emailAddressDto))
                .toList();
        List<PhoneNumber> phoneNumberDtoList = clientDto.getContactList().stream()
                .filter(contact -> contact instanceof PhoneNumberDto)
                .map((ContactDto phoneNumberDto) -> PhoneNumberMapper.toPhoneNumber((PhoneNumberDto) phoneNumberDto))
                .toList();

        List<Contact> contactList = new ArrayList<>();
        contactList.addAll(phoneNumberDtoList);
        contactList.addAll(emailAddressDtoList);

        return Client.builder()
                .name(clientDto.getName())
                .contactList(contactList)
                .build();
    }
}
