package com.logicq.electionmgm.constant;

public enum EntityType {
	EMPLOYEE("EMPLOYEE"), STUDENT("STUDENT");

	private final  String type;

	private  EntityType(final String type) {
		this.type = type;
	}

  public String getValue() {

		return this.type;
	}
  @Override
  public String toString() {
      return this.type;
  }
}
