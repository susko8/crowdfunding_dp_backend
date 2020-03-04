CREATE TABLE project
(
    projectid   int,
    projectname varchar(200)
);

CREATE TABLE users
(
    userid    int,
    login     varchar(15),
    password  varchar(255),
    firstname varchar(50),
    lastname  varchar(50),
    userrole  int4
);

INSERT INTO project(projectid, projectname)
VALUES (1, 'TEST');

INSERT INTO project(projectid, projectname)
VALUES (2, 'TEST2');

INSERT INTO users(userid, login, password, firstname, lastname, userrole)
VALUES (1, 'admin', '$2y$12$vKG/VsnYBQnfSgeXrlq4Meevjy9lAnslU1T0xB.2VWs/e2yXoeT1G', 'firstname', 'lastname', 0)
