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
import org.example.enums.Score;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "rate")
public class Rate extends BaseEntity<Long> {
    @Column(name = "score" , nullable = false)
    private Score score;

    @Column(name = "comment")
    private String comment;

    @OneToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
