CREATE TABLE user_roles (
  role_id bigint(10) NOT NULL AUTO_INCREMENT,
  role varchar(45) NOT NULL,
  last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60),
  PRIMARY KEY (role_id));
