CREATE TABLE project
(
    projectid          int,
    projectname        varchar(200),
    projectdescription varchar(200),
    projectimagesrc    varchar(255)
);

CREATE TABLE users
(
    userid    BIGSERIAL,
    login     varchar(50),
    password  varchar(255),
    firstname varchar(50),
    lastname  varchar(50),
    userrole  int4
);

INSERT INTO project(projectid, projectname, projectdescription, projectimagesrc)
VALUES (1,
        'Test Projekt 1',
        'Pie ice cream cupcake lollipop sesame snaps sesame snaps lollipop topping.',
        'https://images.unsplash.com/photo-1575550959106-5a7defe28b56?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80');

INSERT INTO project(projectid, projectname, projectdescription, projectimagesrc)
VALUES (2,
        'Test Projekt 2',
        'Muffin cake jujubes candy canes muffin gummi bears brownie cotton candy.',
        'https://images.unsplash.com/photo-1551757662-ef87a561ade5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80');

INSERT INTO project(projectid, projectname, projectdescription, projectimagesrc)
VALUES (3,
        'Test Projekt 3',
        'Cake marshmallow muffin bonbon gummi bears.',
        'https://images.unsplash.com/photo-1573663660571-1bdb4d07828a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=701&q=80');

INSERT INTO project(projectid, projectname, projectdescription, projectimagesrc)
VALUES (4,
        'Test Projekt 4',
        'Muffin cake jujubes candy canes muffin gummi bears brownie cotton candy.',
        'https://images.unsplash.com/photo-1466940219795-c670f475e59f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=652&q=80');

INSERT INTO project(projectid, projectname, projectdescription, projectimagesrc)
VALUES (5,
        'Test Projekt 5',
        'Muffin cake jujubes candy canes muffin gummi bears brownie cotton candy.',
        'https://images.unsplash.com/photo-1565378434747-262417385c7f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=749&q=80');

INSERT INTO project(projectid, projectname, projectdescription, projectimagesrc)
VALUES (6,
        'Test Projekt 6',
        'Muffin cake jujubes candy canes muffin gummi bears brownie cotton candy.',
        'https://images.unsplash.com/photo-1582389713128-95f4b972ba4f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80');

INSERT INTO users(userid, login, password, firstname, lastname, userrole)
VALUES (1, 'admin', '$2y$12$vKG/VsnYBQnfSgeXrlq4Meevjy9lAnslU1T0xB.2VWs/e2yXoeT1G', 'firstname', 'lastname', 0)
