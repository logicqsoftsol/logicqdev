CREATE TABLE FEEDBACK (
  ID bigint(10) NOT NULL auto_increment,
  SERVICE_REPORT_ID bigint(10),
  CONSUMNER_USER_ID bigint(10),
  SERVICEPROVIDE_USER_ID bigint(10),
  primary key(ID),
  CONSTRAINT fk_feedback_serviceprovider FOREIGN KEY (CONSUMNER_USER_ID) REFERENCES user(id),
  CONSTRAINT fk_feedback_servicereport FOREIGN KEY (SERVICE_REPORT_ID) REFERENCES SERVICEREPORT(REPORT_ID)
  )
  /