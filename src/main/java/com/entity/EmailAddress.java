package com.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(of = {"emailAddress"})
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email_addresses")
public class EmailAddress extends Contact {

    @Column(name = "email_address")
    private String emailAddress;

}
