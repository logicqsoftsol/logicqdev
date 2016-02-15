
CREATE TABLE login (
  email varchar(60) NOT NULL,
  password varchar(60) NOT NULL,
  phonnumber varchar(13) NOT NULL,
  lastlogindate date NOT NULL,
  loginattempcounts int(10) DEFAULT NULL,
  ipaddress varchar(100),
  userid bigint(10) NOT NULL,
  last_update TIMESTAMP,
  create_time TIMESTAMP,
  created_by  VARCHAR(60),
  updated_by VARCHAR(60),
  UNIQUE INDEX (userid),
  UNIQUE INDEX (email),
   UNIQUE INDEX (phonnumber),
);
