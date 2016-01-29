CREATE
  TABLE location
  (
    locationid   INT(10),
    locationname VARCHAR(60) NOT NULL,
    UNIQUE INDEX (locationid),
    UNIQUE INDEX (locationname),
    PRIMARY KEY (locationid)
  ) ;
  
  //insert query
insert into location values(1,'Pune');