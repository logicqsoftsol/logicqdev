create table user_facilities_map(
	user_id bigint(10) NOT NULL,
  	facility_id bigint(10) NOT NULL,
  	PRIMARY KEY (user_id, facility_id),
  	CONSTRAINT user_facility_map_fk FOREIGN KEY (user_id) REFERENCES user(id) ON UPDATE CASCADE ON DELETE CASCADE,
  	CONSTRAINT facility_map_fk FOREIGN KEY (facility_id) REFERENCES user_facilities(facility_id) ON UPDATE CASCADE ON DELETE CASCADE
)
/