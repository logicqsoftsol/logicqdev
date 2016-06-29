create table ALERT_TEMPLATE_DETAILS(
  TEMPLATE_DETAILS_ID bigint(10),
  TEMPLATE_ID varchar(50),
  ATTRIBUTE_NAME varchar(200)
 )
 
 
 --day 0 data
 insert into ALERT_TEMPLATE_DETAILS values('100', 'OTP100','day');
 insert into ALERT_TEMPLATE_DETAILS values('101', 'OTP100','desc');
 insert into ALERT_TEMPLATE_DETAILS values('102', 'OTP100','mobileNo');
  