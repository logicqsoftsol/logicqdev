 create table sakila.FILE_UPLOAD (
 file_id bigint(10) not null AUTO_INCREMENT,
 user_id bigint(10) NOT NULL,
 FILE_NAME varchar(40),
 FILE_SIZE varchar(15),
 FILE_TYPE varchar(15),
 FILE_UPLOAD_DATE Date,
 QUALIFIED_PATH varchar(200),
 primary key(file_id)
 );