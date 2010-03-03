package sg.com.stellarstudios.imser.web.common;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.Utility;

public class DateComparator implements Comparator {
	private String fieldName;

	private String sortOrder;

	public DateComparator() {
		super();
	}

	public DateComparator(String fieldName, String sortOrder) {
		this.fieldName = fieldName;
		this.sortOrder = sortOrder;
	}

	public int compare(Object obj1, Object obj2) {
		int ret = 0;
		
		Date date1 = null,date2 = null;
		Calendar cal1 = null,cal2 = null;
		
		//may be date or calendar
		Object obj1Value = Utility.getInstance().getObjectValue(obj1,fieldName);
		Object obj2Value = Utility.getInstance().getObjectValue(obj2,fieldName);
		
		if (obj1Value != null && obj2Value != null) {
			if (sortOrder.equals(GlobalKeys.SORTORDER_ASC)) {
				/*if (obj1Value.getClass().isAssignableFrom(Date.class) && obj2Value.getClass().isAssignableFrom(Date.class)) {
					date1 = (Date)obj1Value;
					date2 = (Date)obj2Value;
					
					ret = date2.compareTo(date1);
				}*/
				//if (obj1Value.getClass().isAssignableFrom(Calendar.class) && obj2Value.getClass().isAssignableFrom(Calendar.class)) {
					cal1 = (Calendar)obj1Value;
					cal2 = (Calendar)obj2Value;
					
					ret = cal2.compareTo(cal1);
				//}
			}
			if (sortOrder.equals(GlobalKeys.SORTORDER_DESC)) {
				/*if (obj1Value.getClass().isAssignableFrom(Date.class) && obj2Value.getClass().isAssignableFrom(Date.class)) {
					date1 = (Date)obj1Value;
					date2 = (Date)obj2Value;
					
					ret = date1.compareTo(date2);
				}*/
				//if (obj1Value.getClass().isAssignableFrom(Calendar.class) && obj2Value.getClass().isAssignableFrom(Calendar.class)) {
					cal1 = (Calendar)obj1Value;
					cal2 = (Calendar)obj2Value;
					
					ret = cal1.compareTo(cal2);
				//}
			}
		}
		
		return ret;
	}

}
