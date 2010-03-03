package sg.com.stellarstudios.imser.web.common;

import java.util.Comparator;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.Utility;

public class DoubleComparator implements Comparator {
	private String fieldName;

	private String sortOrder;

	public DoubleComparator() {
		super();
	}

	public DoubleComparator(String fieldName, String sortOrder) {
		this.fieldName = fieldName;
		this.sortOrder = sortOrder;
	}

	public int compare(Object obj1, Object obj2) {
		int ret = 0;
		
		Object object1 = Utility.getInstance().getObjectValue(obj1,fieldName);
		Object object2 = Utility.getInstance().getObjectValue(obj2,fieldName);
		
		Double obj1Value = (object1.getClass().isAssignableFrom(Integer.class))?new Double(((Integer)object1).doubleValue()):(Double)object1;
		Double obj2Value = (object2.getClass().isAssignableFrom(Integer.class))?new Double(((Integer)object2).doubleValue()):(Double)object2;
		
		if (obj1Value == null) obj1Value = new Double(0);
		if (obj2Value == null) obj2Value = new Double(0);
		
		if (sortOrder.equals(GlobalKeys.SORTORDER_ASC))
			ret = obj2Value.compareTo(obj1Value);
		if (sortOrder.equals(GlobalKeys.SORTORDER_DESC))
			ret = obj1Value.compareTo(obj2Value);
		
		return ret;
	}

}
