package sg.com.stellarstudios.imser.entity.search;

import java.util.ArrayList;
import java.util.List;

import sg.com.stellarstudios.imser.entity.BaseEntity;

public class PickCriteria extends BaseEntity {
	public static final int KEY_FULL_MATCHES_ALL_VALUES = 0;

	public static final int KEY_FULL_MATCHES_ANYONE_VALUE = 1;

	public static final int KEY_PARTIAL_MATCHES_ALL_VALUE = 2;

	public static final int KEY_PARTIAL_MATCHES_ANYONE_VALUE = 3;

	public static final int KEY_BETWEEN_TWO_VALUES_AND = 4;
	
	public static final int KEY_BETWEEN_TWO_VALUES_OR = 5;

	private String key;

	private List values;

	private int matchType;

	// Overwrite abstract method
	public Object getId() {
		return key.toString();
	}

	public void setId(Object id) {
		this.key = id.toString();
	}

	public PickCriteria(String key, String[] values, int matchType) {
		this.key = key;
		this.values = new ArrayList();
		for (int i = 0; i < values.length; i++)
			this.values.add(values[i]);
		this.matchType = matchType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getMatchType() {
		return matchType;
	}

	public void setMatchType(int matchType) {
		this.matchType = matchType;
	}

	public List getValues() {
		return values;
	}

	public void setValues(List values) {
		this.values = values;
	}
}
