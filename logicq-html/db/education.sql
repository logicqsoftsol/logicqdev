CREATE TABLE EDUCATION (
  ID bigint(10) NOT NULL auto_increment,
  EDU_HIGH varchar(100),
  EDU_SPCILAZTION (100),
  USER_ID bigint(10),
  primary key(ID),
   last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60)
  CONSTRAINT fk_education_user FOREIGN KEY (USER_ID) REFERENCES user(id)
  )
  /