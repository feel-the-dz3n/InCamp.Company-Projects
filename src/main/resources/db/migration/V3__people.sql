create sequence contrib_id_seq start 1 increment 1;
create table contribution
(
    id         int,
    person_id  int,
    end_date   timestamp,
    start_date timestamp,
    project_id int,
    primary key (id),
    constraint FK_ContributionPerson foreign key (person_id) references person,
    constraint FK_ContributionProject foreign key (project_id) references project
);

create table person_skills
(
    person_id int,
    skills_id int,
    constraint FK_PersonSkills_Person foreign key (person_id) references person,
    constraint FK_PersonSkills_Skill foreign key (skills_id) references technology
);