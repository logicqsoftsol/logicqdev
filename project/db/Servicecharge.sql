CREATE TABLE SERVICE_CHARGE (
  ID bigint(10) NOT NULL auto_increment,
  CHARGE_AMT double,
  CHARGE_CURRENCY varchar(50),
  SERVICEPROVIDE_USER_ID bigint(10),
  FACILITY_ID bigint(10),
  primary key(ID),
  last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60),
  CONSTRAINT fk_entity_servicecharge FOREIGN KEY (SERVICEPROVIDE_USER_ID) REFERENCES user(id),
  CONSTRAINT fk_entity_facility FOREIGN KEY (FACILITY_ID) REFERENCES USER_FACILITIES(facility_id)
  )