create table sakila.ALERT_TEMPLATE(
  TEMPLATE_ID varchar(50),
  TEMPLATE_VALUE varchar(500),
  SERVICE_ID varchar(200),
  SUBJECT varchar(100),
  primary key (TEMPLATE_ID)
 )