package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.base.entity.BaseEntity;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@MappedSuperclass
public class Person extends BaseEntity<Long> {
    @Column(name = "first_name", nullable = false)
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name should enter only in letters !!")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name should enter only in letters !!")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Enter correct type of email , like : ali55@gmail.com")
    private String email;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "^(\\+98|0)?9\\d{9}$",
            message = "Enter correct type of Phone number , like : 09121111111 or +989121111111")
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(name = "register_date")
    private LocalDate registerDate;
}
