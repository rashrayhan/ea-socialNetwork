INSERT INTO system_user
VALUES (null,'Active',null,null, null,'admin@ea.project','EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
        ,null,'A Plus Admin','admin',null),
        (null,'Active',null,null,'1993-07-29','user1@ea.project','EA',
         '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
            ,null,'Test User 1','user1',null),
       (null,'Active',null,null, '1983-07-29','user2@ea.project','EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           ,null,'Test User 2','user2',null),
       (null,'Active',null,null,'2004-07-29','user3@ea.project','EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           ,null,'Test User 3','user3',null),
       (null,'Active',null,null, '2009-07-29','user4@ea.project','EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           ,null,'Test User 4','user4',null),
       (null,'Active',null,null,'1974-07-29','user5@ea.project','EA',
        '$2a$10$vl0.RUUKvId5/hCh5ND5Ve.8C853e/K5KjBRLvDufOeu09R72W76.'
           ,null,'Test User 5','user5',null)
       ;

INSERT INTO system_role
VALUES (null,'ROLE_ADMIN'),
        (null,'ROLE_USER');

INSERT INTO user_role
VALUES (1,1),
        (2,2),
       (3,2),
       (4,2),
       (5,2),
       (6,2);

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


INSERT INTO filthy_word
VALUES (null, 'A word meaning vagina', 'cunt'),
        (null,'A word meaning explicit display of nudes', 'porn'),
        (null,'A word meaning vagina', 'pussy'),
        (null, 'An oblivious use of the female genital', 'vagina'),
        (null, 'A word used when someone is being obnoxious, stupid, or rude.', 'prick'),
        (null, 'Also fuck or shit, its the common swear word for everything in Italian', 'dick'),
        (null, 'Originally meaning a child born out of wedlock', 'bastard'),
        (null,'A word meaning ass', 'butt'),
        (null, 'A word meaning dick', 'bellend'),
        (null,'A word similar to fuck', 'fucker'),
        (null,'A word used when someone is being stupic', 'asshole'),
        (null,'A word used when someone is being obnoxious', 'ass face'),
        (null, 'A word used when someone is being foolish', 'shithead'),
        (null,'A word used when someone is being rude', 'fuck off'),
        (null, 'Perhaps a bit nicer way to say Vai para o caralho', 'suck it'),
        (null, 'A word used for penis sucking', 'blowjob');