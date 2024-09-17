package com.mapper;

import com.dto.EmailAddressDto;
import com.entity.EmailAddress;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmailAddressMapper {

    public static EmailAddressDto toEmailAddressDto(EmailAddress emailAddress) {
        EmailAddressDto emailAddressDto = new EmailAddressDto();
        emailAddressDto.setEmailAddress(emailAddress.getEmailAddress());
        return emailAddressDto;
    };

    public static EmailAddress toEmailAddress(EmailAddressDto emailAddressDto) {
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setEmailAddress(emailAddressDto.getEmailAddress());
        return emailAddress;
    };
}
