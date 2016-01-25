
CREATE TABLE login (
  email varchar(250) NOT NULL,
  password varchar(100) NOT NULL,
  phonnumber int(10) NOT NULL,
  lastlogindate date NOT NULL,
  loginattempcounts int(1) DEFAULT NULL,
  ipaddress varchar(100) NOT NULL,
  userid int(9) NOT NULL,
  UNIQUE INDEX (userid),
  UNIQUE INDEX (email),
   UNIQUE INDEX (phonnumber),
) ENGINE=INNODB;
