 CREATE TABLE user_roles_map (
  user_id bigint(10) NOT NULL,
  role_id bigint(10) NOT NULL,
  last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60),
  PRIMARY KEY (user_id,role_id),
  CONSTRAINT user FOREIGN KEY (user_id) REFERENCES sakila.user(id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT role FOREIGN KEY (role_id) REFERENCES sakila.user_roles(role_id) ON UPDATE CASCADE ON DELETE CASCADE
  );
 