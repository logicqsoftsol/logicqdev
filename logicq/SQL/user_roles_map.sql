 CREATE TABLE sakila.user_roles_map (
  user_id INT NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  FOREIGN KEY (user_id) REFERENCES sakila.user(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (role_id) REFERENCES sakila.user_roles(role_id) ON UPDATE CASCADE ON DELETE CASCADE);
  
 
  //insert query 
  insert into sakila.user_roles_map values (1,1);