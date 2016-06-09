CREATE TABLE SERVICEREPORT (
  REPORT_ID bigint(10) NOT NULL auto_increment,
  USER_ID bigint(10),
  primary key(REPORT_ID),
  CONSTRAINT fk_user_servicereport FOREIGN KEY (USER_ID) REFERENCES user(id)
  )