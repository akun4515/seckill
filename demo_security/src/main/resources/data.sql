INSERT INTO sys_user (id,username,password) VALUES (1,'wyk','wyk');
INSERT INTO sys_user (id,username,password) VALUES (2,'wisely','wisely');

INSERT INTO sys_role (id,name) VALUES (1,'ROLE_ADMIN');
INSERT INTO sys_role (id,name) VALUES (2,'ROLE_USER');

INSERT INTO sys_user_roles(SYS_USER_ID,ROLES_ID) VALUES (1,1);
INSERT INTO sys_user_roles(SYS_USER_ID,ROLES_ID) VALUES (2,2);