package com.incamp.companyprojects;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(
        name = "contrib-id-gen",
        sequenceName = "contrib_id_seq",
        allocationSize = 1)
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrib-id-gen")
    Integer id;

    @OneToOne
    Project project;

    LocalDateTime startDate;
    LocalDateTime endDate;
}
