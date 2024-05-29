package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.base.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "service")
public class Service extends BaseEntity<Long> {
    @Column(name = "service_name" , nullable = false)
    private String name;
}
