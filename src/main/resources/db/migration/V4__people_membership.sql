create table person_membership
(
    person_id  int4 not null,
    company_id int4 not null
);

alter table if exists person_membership
    add constraint FK__Person_MemberShip__Company foreign key (company_id) references company;
alter table if exists person_membership
    add constraint FK__Person_MemberShip__Person foreign key (person_id) references person;
