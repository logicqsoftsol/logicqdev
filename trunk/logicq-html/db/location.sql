CREATE TABLE sakila.location
  (
    locationid   INT (10),
    locationname VARCHAR(60) NOT NULL,
	locality VARCHAR(60),
	pincode BIGINT (16),
	latitude double,
	longitude double,
	last_update TIMESTAMP,
    create_time TIMESTAMP,
	created_by  VARCHAR(60),
	updated_by VARCHAR(60),
    UNIQUE INDEX (locationid),
    UNIQUE INDEX (pincode),
    PRIMARY KEY (locationid,locationname,locality,pincode) ) ;
    
    
//insert Query

 insert into sakila.location values(2,'Bhbaneswar','S',754879,20.2887253,85.8396657,SYSDATE(),SYSDATE(),null,null);
 