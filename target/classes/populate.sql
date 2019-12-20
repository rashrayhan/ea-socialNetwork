INSERT INTO system_user
VALUES (null, 'Active', null, null, null, 'admin@ea.project', 'EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           , null, 'A Plus Admin', 'admin', null),
       (null, 'Active', null, null, '1993-07-29', 'user1@ea.project', 'EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           , null, 'Test User 1', 'user1', null),
       (null, 'Active', null, null, '1983-07-29', 'user2@ea.project', 'EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           , null, 'Test User 2', 'user2', null),
       (null, 'Active', null, null, '2004-07-29', 'user3@ea.project', 'EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           , null, 'Test User 3', 'user3', null),
       (null, 'Active', null, null, '2009-07-29', 'user4@ea.project', 'EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           , null, 'Test User 4', 'user4', null),
       (null, 'Active', null, null, '1974-07-29', 'user5@ea.project', 'EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           , null, 'Test User 5', 'user5', null)
;

INSERT INTO system_role
VALUES (null, 'ROLE_ADMIN'),
       (null, 'ROLE_USER');

INSERT INTO user_role
VALUES (1, 1),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2);

INSERT INTO system_privilege
VALUES (null, 'ROLE_ADVERTISE_PRIVILEGE'),
       (null, 'ROLE_POST_PRIVILEGE'),
       (null, 'ROLE_COMMENT_PRIVILEGE'),
       (null, 'ROLE_FOLLOW_PRIVILEGE'),
       (null, 'ROLE_CLAIM_PRIVILEGE'),
       (null, 'ROLE_USER_MANAGEMENT_PRIVILEGE'),
       (null, 'ROLE_DASHBOARD_PRIVILEGE'),
       (null, 'ROLE_CLAIMS_PRIVILEGE'),
       (null, 'ROLE_FILTHY_PRIVILEGE'),
       (null, 'ROLE_PROFILE_PRIVILEGE'),
       (null, 'ROLE_TIMELINE_PRIVILEGE');

INSERT INTO role_privilege
VALUES (1, 1),
       (1, 6),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5),
       (1, 7),
       (1, 8),
       (1, 9),
       (2, 10),
       (2, 11);
