create table sakila.USER(

id bigint(10) NOT NULL AUTO_INCREMENT,
FIRST_NAME varchar(40),
LAST_NAME varchar(40),
GENDER varchar(10),
MOBILE_NUMBER varchar(13),
EMAIL_ID varchar(50),
DOB date,
USER_PASSWORD varchar(40),
MOB_VERIFICATION_FLAG BIT(1),
EMAIL_VERIFICATION_FLAG BIT(1),
USER_VERIFICATION_FLAG BIT(1),
UNIQUE INDEX(MOBILE_NUMBER),
UNIQUE INDEX(EMAIL_ID),
primary key(ID));
