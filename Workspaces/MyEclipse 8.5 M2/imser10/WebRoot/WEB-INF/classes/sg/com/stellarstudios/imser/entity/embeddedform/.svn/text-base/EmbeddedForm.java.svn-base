package sg.com.stellarstudios.imser.entity.embeddedform;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import sg.com.stellarstudios.imser.entity.BaseEntity;

public class EmbeddedForm extends BaseEntity {
	private String id;
	private Map linesMap;
	private Map preloadData;

	public EmbeddedForm(String id) {
		this.id = id;
		linesMap = new LinkedHashMap();
		preloadData = new HashMap();
	}
	
	public Object getId() {
		return id;
	}
	public void setId(Object id) {
		this.id = id.toString();
	}
	public Map getLinesMap() {
		return linesMap;
	}
	public void setLinesMap(Map linesMap) {
		this.linesMap = linesMap;
	}
	
	public Map getPreloadData() {
		return preloadData;
	}

	public void setPreloadData(Map preloadData) {
		this.preloadData = preloadData;
	}

}
