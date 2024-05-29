package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.enums.SpecialistSituation;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "specialist")
public class Specialist extends Person {
    @Column(name = "situation", nullable = false)
    @Enumerated(EnumType.STRING)
    private SpecialistSituation situation;

    @Lob
    @Column(name = "picture", nullable = false)
    private byte[] image;

    @Column(name = "score", nullable = false)
    private Double score;

    @OneToMany(mappedBy = "specialist", fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<FieldSpecialist> fieldSpecialists = new ArrayList<>();
}
