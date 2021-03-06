CREATE TABLE sakila.user_address (
  ADDRESS_ID bigint(10) NOT NULL auto_increment,
  HOUSE_NUMBER varchar(50),
  FLOOR_NUMBER varchar(50),
  BULDING_NUMBER varchar(50),
  STREET_NAME varchar(50),
  LOCALITY varchar(50),
  LANDMARK varchar(50),
  CITY varchar(50),
  STATE varchar(50),
  PINCODE varchar(50),
  COUNTRY varchar(50),
  COMMUNICATION_ADDRESS_TYPE varchar(50),
  DEFAULT_ADDRESS_FLAG bit(1),
  USER_ID bigint(10),
  CONTACT_TYPE varchar(15),
  CONTACT_NUMBER varchar(13),
  latitude double,
  longitude double,
  last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60),
  primary key(address_id),
  CONSTRAINT fk_user_address FOREIGN KEY (USER_ID) REFERENCES sakila.user(id));
  
  //insert query
  
 insert into sakila.user_address values(1,111,123,111,'Street','Satyanagar','near bigbazar','bhubaneswar','ODISHA',854258,'INDIA','','',1,'','',20.2887253,85.8396657,SYSDATE(),SYSDATE(),null,null);