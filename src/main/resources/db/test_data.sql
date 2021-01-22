TRUNCATE company, project, technology, project_technologies, project_people, person,
    contribution, person_skills;

INSERT INTO company VALUES(1, 'InterLink inCamp');

INSERT INTO person VALUES(1, 'Yaroslav');
INSERT INTO person VALUES(2, 'Rob');
INSERT INTO person VALUES(3, 'Ben');
INSERT INTO person VALUES(4, 'Bob');

INSERT INTO technology VALUES(1, 'C#');
INSERT INTO technology VALUES(2, 'Java');
INSERT INTO technology VALUES(3, 'Hibernate');
INSERT INTO technology VALUES(4, 'Spring');
INSERT INTO technology VALUES(5, 'HTML5');
INSERT INTO technology VALUES(6, 'JavaScript');
INSERT INTO technology VALUES(7, 'Angular');
INSERT INTO technology VALUES(8, 'C++');
INSERT INTO technology VALUES(9, 'Assembly');

INSERT INTO project VALUES(1, 'To-Do List', 1);
INSERT INTO project_people (project_id, people_id) VALUES(1, 1);
INSERT INTO project_people (project_id, people_id) VALUES(1, 4);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (1, 2);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (1, 3);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (1, 4);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (1, 5);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (1, 6);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (1, 7);

INSERT INTO project VALUES(2, 'TicTacToe', 1);
INSERT INTO project_people (project_id, people_id) VALUES(2, 1);
INSERT INTO project_people (project_id, people_id) VALUES(2, 2);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (2, 2);

INSERT INTO project VALUES(3, 'Ubuntu OS', 1);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (3, 8);
INSERT INTO project_technologies (project_id, technologies_id) VALUES (3, 9);

INSERT INTO contribution (id, person_id, project_id, start_date, end_date)
VALUES(1, 1, 1, '2020-12-01 00:00:01', '2021-01-01 00:00:01');

INSERT INTO contribution (id, person_id, project_id, start_date, end_date)
VALUES(2, 1, 2, '2020-12-01 00:00:01', '2021-01-01 00:00:01');

INSERT INTO contribution (id, person_id, project_id, start_date, end_date)
VALUES(3, 2, 2, '2018-04-01 00:00:01', '2020-01-01 00:00:01');

INSERT INTO person_skills (person_id, skills_id) VALUES (1, 1);
INSERT INTO person_skills (person_id, skills_id) VALUES (1, 2);
INSERT INTO person_skills (person_id, skills_id) VALUES (1, 3);
INSERT INTO person_skills (person_id, skills_id) VALUES (1, 4);
INSERT INTO person_skills (person_id, skills_id) VALUES (1, 5);
INSERT INTO person_skills (person_id, skills_id) VALUES (1, 6);
INSERT INTO person_skills (person_id, skills_id) VALUES (1, 7);

INSERT INTO person_skills (person_id, skills_id) VALUES (2, 2);
INSERT INTO person_skills (person_id, skills_id) VALUES (2, 5);
INSERT INTO person_skills (person_id, skills_id) VALUES (2, 6);
INSERT INTO person_skills (person_id, skills_id) VALUES (2, 7);
INSERT INTO person_skills (person_id, skills_id) VALUES (2, 8);
INSERT INTO person_skills (person_id, skills_id) VALUES (2, 9);

INSERT INTO person_skills (person_id, skills_id) VALUES (4, 2);
INSERT INTO person_skills (person_id, skills_id) VALUES (4, 5);
INSERT INTO person_skills (person_id, skills_id) VALUES (4, 6);
INSERT INTO person_skills (person_id, skills_id) VALUES (4, 7);

INSERT INTO person_skills (person_id, skills_id) VALUES (3, 2);
INSERT INTO person_skills (person_id, skills_id) VALUES (3, 8);
INSERT INTO person_skills (person_id, skills_id) VALUES (3, 9);