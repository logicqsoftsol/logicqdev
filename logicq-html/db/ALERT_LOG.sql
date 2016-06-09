create table alert_LOG(
  ALERT_ID bigint(10) NOT NULL AUTO_INCREMENT,
  ALERT_NAME varchar(200),
  ALERT_TYPE varchar(50),
  USER_ID bigint(10),
  ALERT_STATUS varchar(20), 
  SERVICE_ID varchar(200),
  EMAIL_OTP integer(6),
  SMS_OTP integer(6),
  MESSAGE varchar(500),
  last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60),
  primary key (ALERT_ID)
 )