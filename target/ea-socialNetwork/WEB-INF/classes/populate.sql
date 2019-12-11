INSERT INTO system_user
VALUES (null,'Active',null,null, null,'aplus@ea.project','Ea',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
        ,null,'A Plus Admin','admin',null),
        (null,'Active',null,null,'1993-07-29','aplus@ea.project','Security',
         '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
            ,null,'Test User','user',null);

INSERT INTO system_role
VALUES (null,'ROLE_ADMIN'),
        (null,'ROLE_USER');

INSERT INTO user_role
VALUES (1,1),
        (2,2);

INSERT INTO system_privilege
VALUES (null,'ADVERTISE_PRIVILEGE'),
        (null,'POST_PRIVILEGE'),
        (null,'COMMENT_PRIVILEGE'),
        (null,'FOLLOW_PRIVILEGE'),
        (null,'CLAIM_PRIVILEGE'),
        (null,'USER_MANAGEMENT_PRIVILEGE');

INSERT INTO role_privilege
VALUES (1,1),
        (1,6),
        (2,2),
        (2,3),
        (2,4),
        (2,5);
