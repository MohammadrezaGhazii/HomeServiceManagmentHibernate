package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.example.base.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@MappedSuperclass
public class Person extends BaseEntity<Long> {
    @Column(name = "first_name" , nullable = false)
    
    private String firstName;

    @Column(name = "last_name" , nullable = false)
    private String lastName;

    @Column(name = "national_id", unique = true, nullable = false)
    private String nationalid;

    @Column(nullable = false)
    private String password;
}
