package com.mapper;

import com.dto.PhoneNumberDto;
import com.entity.PhoneNumber;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PhoneNumberMapper {

    private PhoneNumberMapper() {}

    public static  PhoneNumberDto toPhoneNumberDto(PhoneNumber phoneNumber) {
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setPhoneNumber(phoneNumber.getPhoneNumber());
        return phoneNumberDto;
    };

    public static  PhoneNumber toPhoneNumber(PhoneNumberDto phoneNumberDto) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNumber(phoneNumberDto.getPhoneNumber());
        return phoneNumber;
    };
}
