create sequence person_id_seq start 1 increment 1;
create sequence project_id_seq start 1 increment 1;
create sequence technology_id_seq start 1 increment 1;

create table person
(
    id   int4 not null,
    name varchar(255),
    primary key (id)
);
create table project
(
    id         int4 not null,
    name       varchar(255),
    company_id int4,
    primary key (id)
);
create table project_people
(
    project_id int4 not null,
    people_id  int4 not null
);
create table project_technologies
(
    project_id      int4 not null,
    technologies_id int4 not null
);
create table technology
(
    id   int4 not null,
    name varchar(255),
    primary key (id)
);

alter table if exists project_people
    add constraint UK_q7j3ruysyehtwd3m7frejfdqv unique (people_id);

alter table if exists project_technologies
    add constraint UK_ak4j8gqv94tp3795n6vxilpqa unique (technologies_id);

alter table if exists project
    add constraint FK76fngi71pfr8phbobe5pq0swd foreign key (company_id) references company;

alter table if exists project_people
    add constraint FKq3svndcxsi1nctyf4frx90b4g foreign key (people_id) references person;

alter table if exists project_people
    add constraint FK72cscgyravma6vsmrq5ruutol foreign key (project_id) references project;

alter table if exists project_technologies
    add constraint FKpkaeosxcgn9xfgwa2cw4ycunf foreign key (technologies_id) references technology;

alter table if exists project_technologies
    add constraint FK5kp3kuxltj18un9w7eealp6dl foreign key (project_id) references project;
