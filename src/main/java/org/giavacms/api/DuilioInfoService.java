package org.giavacms.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DuilioInfoService implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> properties;

	public String getValue(String key) {
		return getProperties().get(key);
	}

	public boolean existKey(String key) {
		return getProperties().containsKey(key);
	}

	public Map<String, String> getProperties() {
		if (this.properties == null)
			this.properties = new HashMap<String, String>();
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Map<String, String> addProperty(String key, String value) {
		getProperties().put(key, value);
		return getProperties();
	}
}
