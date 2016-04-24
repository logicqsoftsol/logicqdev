CREATE TABLE PROFILE (
  PROFILE_ID bigint(10) NOT NULL auto_increment,
  PROFILE_IMAGE varchar(300),
  EDCUATION_ID bigint(10),
  USER_ID bigint(10),
  primary key(PROFILE_ID),
   last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60),
  CONSTRAINT fk_profile_edu FOREIGN KEY (EDCUATION_ID) REFERENCES EDUCATION(ID),
  CONSTRAINT fk_profile_user FOREIGN KEY (USER_ID) REFERENCES user(id)
  )