package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

@Entity(name = "sub_service")
public class SubService extends BaseEntity<Long> {
    @Column(name = "subservice_name" , nullable = false)
    private String name;

    @Column(name = "base_price" , nullable = false)
    private Double basePrice;

    @Column(name = "description" , nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "service_id")
    private Service service;
}
