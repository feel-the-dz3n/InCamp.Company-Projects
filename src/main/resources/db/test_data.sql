TRUNCATE company, project, technology, project_technologies, project_people, person,
    contribution, person_skills, person_membership, contrib_technologies;

SELECT setval('technology_id_seq', 1, FALSE);
SELECT setval('company_seq', 1, FALSE);
SELECT setval('contrib_id_seq', 1, FALSE);
SELECT setval('person_id_seq', 1, FALSE);
SELECT setval('project_id_seq', 1, FALSE);

INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'C#');
INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'Java');
INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'Hibernate');
INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'Spring');
INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'HTML5');
INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'JavaScript');
INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'Angular');
INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'C++');
INSERT INTO technology
VALUES (nextval('technology_id_seq'), 'Assembly');

INSERT INTO company
VALUES (nextval('company_seq'), 'InterLink inCamp');

INSERT INTO person
VALUES (nextval('person_id_seq'), 'Yaroslav');
INSERT INTO person_membership (person_id, company_id)
VALUES (1, 1);
INSERT INTO person_skills (person_id, skills_id)
VALUES (1, 1);
INSERT INTO person_skills (person_id, skills_id)
VALUES (1, 2);
INSERT INTO person_skills (person_id, skills_id)
VALUES (1, 3);
INSERT INTO person_skills (person_id, skills_id)
VALUES (1, 4);
INSERT INTO person_skills (person_id, skills_id)
VALUES (1, 5);
INSERT INTO person_skills (person_id, skills_id)
VALUES (1, 6);
INSERT INTO person_skills (person_id, skills_id)
VALUES (1, 7);

INSERT INTO person
VALUES (nextval('person_id_seq'), 'Rob');
INSERT INTO person_membership (person_id, company_id)
VALUES (2, 1);
INSERT INTO person_skills (person_id, skills_id)
VALUES (2, 2);
INSERT INTO person_skills (person_id, skills_id)
VALUES (2, 5);
INSERT INTO person_skills (person_id, skills_id)
VALUES (2, 6);
INSERT INTO person_skills (person_id, skills_id)
VALUES (2, 7);
INSERT INTO person_skills (person_id, skills_id)
VALUES (2, 8);
INSERT INTO person_skills (person_id, skills_id)
VALUES (2, 9);

INSERT INTO person
VALUES (nextval('person_id_seq'), 'Ben');
INSERT INTO person_membership (person_id, company_id)
VALUES (3, 1);
INSERT INTO person_skills (person_id, skills_id)
VALUES (3, 2);
INSERT INTO person_skills (person_id, skills_id)
VALUES (3, 8);
INSERT INTO person_skills (person_id, skills_id)
VALUES (3, 9);

INSERT INTO person
VALUES (nextval('person_id_seq'), 'Bob');
INSERT INTO person_membership (person_id, company_id)
VALUES (4, 1);
INSERT INTO person_skills (person_id, skills_id)
VALUES (4, 2);
INSERT INTO person_skills (person_id, skills_id)
VALUES (4, 5);
INSERT INTO person_skills (person_id, skills_id)
VALUES (4, 6);
INSERT INTO person_skills (person_id, skills_id)
VALUES (4, 7);

INSERT INTO project
VALUES (nextval('project_id_seq'), 'To-Do List', 1);
INSERT INTO project_people (project_id, people_id)
VALUES (1, 1);
INSERT INTO project_people (project_id, people_id)
VALUES (1, 4);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (1, 2);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (1, 3);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (1, 4);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (1, 5);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (1, 6);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (1, 7);

INSERT INTO project
VALUES (nextval('project_id_seq'), 'TicTacToe', 1);
INSERT INTO project_people (project_id, people_id)
VALUES (2, 1);
INSERT INTO project_people (project_id, people_id)
VALUES (2, 2);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (2, 2);

INSERT INTO project
VALUES (nextval('project_id_seq'), 'Ubuntu OS', 1);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (3, 8);
INSERT INTO project_technologies (project_id, technologies_id)
VALUES (3, 9);
