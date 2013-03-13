package org.giavacms.enums;

public enum ServiceType {
	REMEMBER_ME("");

	private String className;

	private ServiceType(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

}
