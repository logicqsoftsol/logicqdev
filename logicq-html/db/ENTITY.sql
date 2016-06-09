 CREATE TABLE ENTITY 
  (
    entityid INT(10),
    entityname VARCHAR(30),
	last_update TIMESTAMP,
    create_time TIMESTAMP,
	created_by  VARCHAR(60),
	updated_by VARCHAR(60),
	  UNIQUE INDEX (entityname),
    PRIMARY KEY (entityid) ) ;
    
    //insert query
    
    insert into ENTITY values (1,'DOCTOR');
    