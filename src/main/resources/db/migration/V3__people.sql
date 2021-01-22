create sequence contrib_id_seq start 1 increment 1;
create table contribution
(
    id         int,
    end_date   timestamp,
    start_date timestamp,
    project_id int,
    primary key (id),
    constraint FK_ContributionProject foreign key (project_id) references project (id)
);

create table person_contributions
(
    person_id        int,
    contributions_id int,
    constraint FK_PersonContrib_Person foreign key (person_id) references person (id),
    constraint FK_PersonContrib_Contrib foreign key (contributions_id) references contribution (id)
);

create table person_skills
(
    person_id int,
    skills_id int,
    constraint FK_PersonSkills_Person foreign key (person_id) references person (id),
    constraint FK_PersonSkills_Skill foreign key (skills_id) references technology (id)
);