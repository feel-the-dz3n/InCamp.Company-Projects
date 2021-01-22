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

    @ManyToOne(fetch = FetchType.EAGER)
    Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    Person person;

    LocalDateTime startDate;
    LocalDateTime endDate;
}
