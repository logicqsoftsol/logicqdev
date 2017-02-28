package com.logicq.homeplus.common;

public enum ServiceEnum {
	    ORDERED ("ORDERED"),
	    PROCURED ("PROCURED"),
	    DELIVERED ("DELIVERED"),
        REPLACE("REPLACE"),
        RE_DELIVERED ("REDELIVERED");
        private final String name;       

	    private ServiceEnum(String service) {
	        name = service;
	    }

	    public boolean equalsName(String otherName) {
	        // (otherName == null) check is not needed because name.equals(null) returns false 
	        return name.equals(otherName);
	    }

	    public String toString() {
	       return this.name;
	    }
}
