CREATE TABLE user_facilities (
  facility_id bigint(10) NOT NULL AUTO_INCREMENT,
  facility_name varchar(45) NOT NULL,
  last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60),
  PRIMARY KEY (facility_id)
)
/
