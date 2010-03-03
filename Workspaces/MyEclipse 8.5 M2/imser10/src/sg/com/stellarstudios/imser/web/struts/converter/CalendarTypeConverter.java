package sg.com.stellarstudios.imser.web.struts.converter;

import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import sg.com.stellarstudios.imser.common.Utility;

public class CalendarTypeConverter extends StrutsTypeConverter {
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return Utility.getInstance().buildCalendarFromString(values[0]);
	}

	public String convertToString(Map context, Object o) {
		Calendar cal = (Calendar) o;
		
		return Utility.getInstance().buildStringFromCalendar(cal);
	}

}
