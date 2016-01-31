 CREATE TABLE ENTITY 
  (
    entityid INT(10),
    entityname VARCHAR(30),
	  UNIQUE INDEX (entityname),
    PRIMARY KEY (entityid) ) ;
    
    //insert query
    
    insert into ENTITY values (1,'DOCTOR');
    