/*@JoinTable(name = "contrib_technologies",
            joinColumns = @JoinColumn(name = "contrib_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))*/

create table contrib_technologies
(
    contrib_id    int4 not null,
    technology_id int4 not null
);

alter table if exists contrib_technologies
    add constraint FK__Contrib_Technologies__Contrib foreign key (contrib_id) references contribution;
alter table if exists contrib_technologies
    add constraint FK__Contrib_Technologies__Tech foreign key (technology_id) references technology;
