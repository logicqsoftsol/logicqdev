 CREATE TABLE location
  (
    locationid   INT (10),
    locationname VARCHAR(60) NOT NULL,
	locality VARCHAR(60),
	pincode BIGINT (16),
    UNIQUE INDEX (locationid),
    UNIQUE INDEX (pincode),
    PRIMARY KEY (locationid,locationname,locality,pincode) ) ;
    
    
//insert Query

 insert into location values(1,'Bhbaneswar','SaheedNagar',754879);