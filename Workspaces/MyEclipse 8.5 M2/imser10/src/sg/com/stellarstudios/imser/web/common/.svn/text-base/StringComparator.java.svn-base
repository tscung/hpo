package sg.com.stellarstudios.imser.web.common;

import java.util.Comparator;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.Utility;

public class StringComparator implements Comparator {
	private String fieldName;

	private String sortOrder;

	public StringComparator() {
		super();
	}

	public StringComparator(String fieldName, String sortOrder) {
		this.fieldName = fieldName;
		this.sortOrder = sortOrder;
	}

	public int compare(Object obj1, Object obj2) {
		int ret = 0;
		
		String obj1Value = Utility.getInstance().getObjectValue(obj1,fieldName).toString();
		String obj2Value = Utility.getInstance().getObjectValue(obj2,fieldName).toString();
		
		if (obj1Value == null) obj1Value = "";
		if (obj2Value == null) obj2Value = "";
		
		if (sortOrder.equals(GlobalKeys.SORTORDER_ASC))
			ret = obj2Value.compareTo(obj1Value);
		if (sortOrder.equals(GlobalKeys.SORTORDER_DESC))
			ret = obj1Value.compareTo(obj2Value);
		
		return ret;
	}

}
