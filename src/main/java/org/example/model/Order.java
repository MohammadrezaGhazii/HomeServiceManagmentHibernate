package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.base.entity.BaseEntity;
import org.example.enums.OrderSituation;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "order_client")
public class Order extends BaseEntity<Long> {
    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "requested_date")
    private LocalDate requestedDate;

    @Column(name = "requested_time")
    private LocalTime requestedTime;

    @Column(name = "address" , nullable = false)
    private String address;

    @Column(name = "explain" , nullable = false)
    private String explain;

    @Column(name = "order_situation")
    private OrderSituation orderSituation;

    @OneToOne
    @JoinColumn(name = "sub_service_id")
    private SubService subService;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
