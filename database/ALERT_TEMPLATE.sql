create table sakila.ALERT_TEMPLATE(
  TEMPLATE_ID varchar(50),
  TEMPLATE_VALUE varchar(500),
  REASON_ID varchar(200),
  SUBJECT varchar(100),
  primary key (TEMPLATE_ID)
 )
 
 --day 0 data
 insert into ALERT_TEMPLATE values( 'OTP100','Hi Sir,\nYour child was absent on $day \nRegards,\nXYZ School','attendance', 'SMS for attendance');