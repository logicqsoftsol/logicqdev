CREATE TABLE RECOMENDATION (
  ID bigint(10) NOT NULL auto_increment,
  SERVICE_CONSUMER_ID bigint(10),
  SERVICE_REPORT_ID bigint(10),
  primary key(ID),
  CONSTRAINT fk_user_recomendation FOREIGN KEY (SERVICE_CONSUMER_ID) REFERENCES user(id),
  CONSTRAINT fk_recomendation_servicereport FOREIGN KEY (SERVICE_REPORT_ID) REFERENCES SERVICEREPORT(REPORT_ID)
  )
  /