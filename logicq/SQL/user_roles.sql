CREATE TABLE sakila.user_roles (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role varchar(45) NOT NULL,
  PRIMARY KEY (role_id));
  

//insert query  
INSERT INTO sakila.user_roles (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO sakila.user_roles (username, role)
VALUES (2, 'ROLE_USER'); 