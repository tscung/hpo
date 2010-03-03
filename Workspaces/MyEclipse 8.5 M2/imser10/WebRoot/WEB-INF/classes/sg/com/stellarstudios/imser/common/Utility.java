package sg.com.stellarstudios.imser.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Utility {
	private static Utility me;
	private DecimalFormat decimalFormat, decimalFormatODP;
	public Utility() {
		decimalFormat = new DecimalFormat("#0.00");
		decimalFormatODP = new DecimalFormat("#0.0");
	}
	public static Utility getInstance() {
		if (me == null)
			me = new Utility();

		return me;
	}
	
	public String replace(String originalContent, String toReplace, String replaceWith) {
		StringBuffer ret = new StringBuffer(originalContent);
		
		int indexes[] = getIndexes(originalContent, toReplace);
		if (indexes.length > 0) {
			for (int i = indexes.length - 1; i >= 0; i--) {
				ret.replace(0, ret.length(), ret.substring(0,indexes[i]) + replaceWith + ret.substring(indexes[i] + toReplace.length(), ret.length()));
			}
		}
		
		return ret.toString();
	}
	
	public String buildCappedString(String str, Integer len) {
    	if (str != null && str.length() > len) {
    		return str.substring(0, len) + "...";
    	}
    	
    	return str;
	}
	
	public String resolveContentType(String filename) {
		String ret = "";
		
		if (filename.endsWith(".pdf")) ret = "application/pdf";
		if (filename.endsWith(".xls")) ret = "application/vnd.ms-excel";
		if (filename.endsWith(".doc")) ret = "application/msword";
		if (filename.endsWith(".zip")) ret = "application/x-zip";
		
		return ret;
	}
	
	public String removeRestrictedCharactersForFilenames(String str) {
		if (str.contains(",")) str = str.replace(',', '_');
		if (str.contains("?")) str = str.replace('?', '_');
		if (str.contains("/")) str = str.replace('/', '_');
		if (str.contains("!")) str = str.replace('!', '_');
		if (str.contains("@")) str = str.replace('@', '_');
		if (str.contains("#")) str = str.replace('#', '_');
		if (str.contains("$")) str = str.replace('$', '_');
		if (str.contains("%")) str = str.replace('%', '_');
		if (str.contains("^")) str = str.replace('^', '_');
		if (str.contains("&")) str = str.replace('&', '_');
		if (str.contains("*")) str = str.replace('*', '_');
				
		return str;
	}
	
	//odp : one decimal place
	public String formatDecimalODP(Double value) {
		if (value != null) return decimalFormatODP.format(value);
		else return "0.0";
	}
	public String formatDecimal(Double value) {
		if (value != null) return decimalFormat.format(value);
		else return "0.00";
	}
	public byte[] getBytes(File file) {
		InputStream fis = null;
		byte[] buff = null;
		
		try {
			fis = new BufferedInputStream(new FileInputStream(file));
			buff = new byte[fis.available()];
			fis.read(buff);
		}
		catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}
		finally {
			if (fis != null) try { fis.close(); } catch (IOException e) { }
		}

		return buff;
	}
	public String removeSquareBrackets(String string) {
		//remove []
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			if (currentChar != '[' || currentChar != ']') {
				sb.append(currentChar);
			}
		}
		
		return sb.toString();
	}

	public String buildDigitNumber(int number, int noOfDigits) {
		String numberStr = new Integer(number).toString();
		if (numberStr.length() == noOfDigits) return numberStr;
		else {
			StringBuffer ret = new StringBuffer();
			for (int i = 0; i < noOfDigits - numberStr.length(); i++) {
				ret.append("0");
			}
			ret.append(number);
			
			return ret.toString();
		}
	}
	public String removeSingleQuote(String string) {
		return removeCharacter(string, '\'');
	}
	public String removeCharacter(String string,char character) {
		if (string != null) {
			if (string.indexOf(character) == -1) {
				return string;
			}
			else {
				StringBuffer ret = new StringBuffer();
				for (int i = 0; i < string.length(); i++) {
					if (string.charAt(i) != character) ret.append(string.charAt(i));
				}
				
				return ret.toString();
			}
		}
		else return string;
	}
	public void buildFolders(String startFolder,String filePath) throws IOException {
		String toBuildPath = filePath.substring(startFolder.length());
		/*StringBuffer toBuildPathSb = new StringBuffer();
		for (int i = 0; i < toBuildPath.length(); i++) {
			toBuildPathSb.append(toBuildPath.charAt(i));
			if (toBuildPath.charAt(i) == '\\') {
				toBuildPathSb.append('\\');
			}
		}
		toBuildPath = toBuildPathSb.toString();*/
		//get individual foldes
		StringTokenizer st = new StringTokenizer(toBuildPath,"\\");
		StringBuffer builtSoFar = new StringBuffer(startFolder);
		while (st.hasMoreTokens()) {
			String indivFolder = st.nextToken();
			
			String fileName = builtSoFar.append("\\"+indivFolder).toString();
			File file = new File(fileName);
			//if is folder
			if (fileName.indexOf(".") == -1) {
				file.mkdir();
			}
			//if is file
			else {
				file.createNewFile();
			}			
		}
	}
	public int[] getIndexes(String content,String token) {
		ArrayList indexes = new ArrayList();

		//go thru content
		for (int i=0; i<content.length(); i++) {
			//look for token in content, with starting position i
			int index = content.indexOf(token,i);
			//if found,
			if (index!=-1) {
				//add the index to arraylist
				indexes.add(new Integer(index));
				//shift search position forward
				i = index;
			}
		}
		
		//convert to int
		int[]ret = new int[indexes.size()];
		for (int i=0; i<indexes.size(); i++) ret[i] = ((Integer)indexes.get(i)).intValue();
		
		return ret;
	}
	
	//************************************** ARRAY METHODS ****************************************
	public boolean findStringInStringArray(String string,String[] array) {
		boolean ret = false;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(string)) {
				ret = true;
				break;
			}
		}
		
		return ret;
	}
	public String[] buildStringArrayFromString(String string,String delim) {
		if (string != null) {
			StringTokenizer st = new StringTokenizer(string,delim);
			String[] ret = new String[st.countTokens()];
			
			int count = 0;
			while (st.hasMoreTokens()) {
				ret[count] = st.nextToken();
				count++;
			}
			
			return ret;
		}
		else return null;
	}
	public String buildStringFromStringArray(String[]array,String delim) {
		StringBuffer ret = new StringBuffer();
		
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				ret.append(array[i]);
				
				if (i+1 < array.length) ret.append(delim);
			}
		}
		
		return ret.toString();
	}
	
	//************************************** DATE METHODS ****************************************
	public String buildStringFromCalendarDDMONYYYY(Calendar date) {
		StringBuffer sb = new StringBuffer();
		
		if (date != null) {
			sb.append(date.get(Calendar.DAY_OF_MONTH));
			sb.append(" ");
			sb.append(getMon(date.get(Calendar.MONTH)));
			sb.append(" ");
			sb.append(date.get(Calendar.YEAR));
		}
		
		return sb.toString();
	}
	public String getMon(int month) {
		switch (month) {
		case 0:
			return "Jan";
		case 1:
			return "Feb";
		case 2:
			return "Mar";
		case 3:
			return "Apr";
		case 4:
			return "May";
		case 5:
			return "Jun";
		case 6:
			return "Jul";
		case 7:
			return "Aug";
		case 8:
			return "Sep";
		case 9:
			return "Oct";
		case 10:
			return "Nov";
		case 11:
			return "Dec";
		}
		
		return "";
	}
	public String[] buildYearRange(String year) {
		String[] ret = new String[2];
		
		int yearInt = Integer.parseInt(year);
		
		//build start
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.MONTH,0);
		cal.set(Calendar.YEAR,yearInt);
		
		ret[0] = this.convertDDMMYYtoYYMMDD(this.buildStringFromCalendar(cal));

		//roll 1 year. and minus 1 day
		cal.roll(Calendar.YEAR,true);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		
		ret[1] = this.convertDDMMYYtoYYMMDD(this.buildStringFromCalendar(cal));
		
		return ret;
	}
	public String[] buildMonthRange(String month,String year) {
		String[] ret = new String[2];
		
		int monthInt = Integer.parseInt(month), yearInt = Integer.parseInt(year);
		
		//build start
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.MONTH,monthInt-1);
		cal.set(Calendar.YEAR,yearInt);
		
		ret[0] = this.convertDDMMYYtoYYMMDD(this.buildStringFromCalendar(cal));
		
		//get last day of month
		if (monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt == 7 || monthInt == 8 || monthInt == 10 || monthInt == 12)
			cal.set(Calendar.DAY_OF_MONTH,31);
		if (monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11)
			cal.set(Calendar.DAY_OF_MONTH,30);
		//if feb, add month by 1, then roll back 1 day.
		if (monthInt == 2) {
			cal.roll(Calendar.MONTH,true);
			cal.add(Calendar.DAY_OF_MONTH,-1);
		}
		
		ret[1] = this.convertDDMMYYtoYYMMDD(this.buildStringFromCalendar(cal));
		
		return ret;
	}
	public String convertDDMMYYtoYYMMDDDelimDash(String DDMMYY) {
		String ret = "";
		
		if (DDMMYY != null) {
			StringTokenizer st = new StringTokenizer(DDMMYY,GlobalKeys.CALENDAR_DELIM);
			
			while (st.hasMoreTokens()) {
				String dd = buildDigitNumber(new Integer(st.nextToken()), 2);
				String mm = buildDigitNumber(new Integer(st.nextToken()), 2);
				String yy = st.nextToken();
				ret = yy + "-" + mm + "-" + dd;
			}
		}
		
		return ret;		
	}
	public String convertDDMMYYtoYYYYMMDDNoDelim(String DDMMYYYY) {
		String ret = "";
		
		if (DDMMYYYY != null) {
			StringTokenizer st = new StringTokenizer(DDMMYYYY,GlobalKeys.CALENDAR_DELIM);
			
			while (st.hasMoreTokens()) {
				String dd = buildDigitNumber(new Integer(st.nextToken()), 2);
				String mm = buildDigitNumber(new Integer(st.nextToken()), 2);
				String yyyy = st.nextToken();
				ret = yyyy + mm + dd;
			}
		}
		
		return ret;		
	}
	public String convertDDMMYYtoYYMMDD(String DDMMYY) {
		String ret = "";
		
		if (DDMMYY != null) {
			StringTokenizer st = new StringTokenizer(DDMMYY,GlobalKeys.CALENDAR_DELIM);
			
			while (st.hasMoreTokens()) {
				String dd = buildDigitNumber(new Integer(st.nextToken()), 2);
				String mm = buildDigitNumber(new Integer(st.nextToken()), 2);
				String yy = st.nextToken();
				ret = yy + GlobalKeys.CALENDAR_DELIM + mm + GlobalKeys.CALENDAR_DELIM + dd;
			}
		}
		
		return ret;		
	}
	public String convertDDMMYYtoMMDDYY(String DDMMYY) {
		String ret = "";
		
		if (DDMMYY != null) {
			StringTokenizer st = new StringTokenizer(DDMMYY,GlobalKeys.CALENDAR_DELIM);
			
			while (st.hasMoreTokens()) {
				String dd = buildDigitNumber(new Integer(st.nextToken()), 2);
				String mm = buildDigitNumber(new Integer(st.nextToken()), 2);
				String yy = st.nextToken();
				ret = mm + GlobalKeys.CALENDAR_DELIM + dd + GlobalKeys.CALENDAR_DELIM + yy;
			}
		}
		
		return ret;		
	}
	public Calendar buildCalendarFromStringYYYYMMDD(String yyyyMMdd) {
		Calendar ret = null;
		
		StringTokenizer st = new StringTokenizer(yyyyMMdd,GlobalKeys.CALENDAR_DELIM);
		while (st.hasMoreTokens()) {
			ret = new GregorianCalendar();
			
			ret.set(Calendar.YEAR,Integer.parseInt(st.nextToken()));
			ret.set(Calendar.MONTH,Integer.parseInt(st.nextToken())-1);
			ret.set(Calendar.DAY_OF_MONTH,Integer.parseInt(st.nextToken()));
		}
		
		return ret;
	}
	public Calendar buildCalendarFromString(String ddMMyyyy) {
		Calendar ret = null;
		try {
			StringTokenizer st = new StringTokenizer(ddMMyyyy,GlobalKeys.CALENDAR_DELIM);
			while (st.hasMoreTokens()) {
				ret = new GregorianCalendar();
				//nullify timings
				ret.set(Calendar.HOUR_OF_DAY, 0);
				ret.set(Calendar.MINUTE, 0);
				ret.set(Calendar.SECOND, 0);				
				
				ret.set(Calendar.DAY_OF_MONTH,Integer.parseInt(st.nextToken()));
				ret.set(Calendar.MONTH,Integer.parseInt(st.nextToken())-1);
				ret.set(Calendar.YEAR,Integer.parseInt(st.nextToken()));
			}
		}
		catch (NumberFormatException e) { 
			//do nothing. just return null.
		}
		
		return ret;
	}
	public String buildStringFromCalendarYYYYMMDD(Calendar date) {
		if (date != null) 
			return date.get(Calendar.YEAR) + GlobalKeys.CALENDAR_DELIM +
			buildDigitNumber(new Integer((date.get(Calendar.MONTH)+1)), 2) + GlobalKeys.CALENDAR_DELIM + 
			buildDigitNumber(new Integer(date.get(Calendar.DAY_OF_MONTH)), 2);
		else return "";
	}

	public String buildStringFromCalendarDateTime(Calendar cal) {
		return buildStringFromCalendar(cal) + ", " + buildDigitNumber(cal.get(Calendar.HOUR_OF_DAY), 2) + GlobalKeys.TIME_DELIM + buildDigitNumber(cal.get(Calendar.MINUTE), 2) + GlobalKeys.TIME_DELIM + buildDigitNumber(cal.get(Calendar.SECOND), 2) + "hrs";
	}
	public String buildStringFromCalendar(Calendar date) {
		if (date != null) 
			return buildDigitNumber(new Integer(date.get(Calendar.DAY_OF_MONTH)), 2) + GlobalKeys.CALENDAR_DELIM + 
			buildDigitNumber(new Integer((date.get(Calendar.MONTH)+1)), 2) + GlobalKeys.CALENDAR_DELIM + 
			date.get(Calendar.YEAR);
		else return "";
	}

	//*********************************** OBJECT REFLECTION METHODS ***********************************
	public void populate(Object dest,Map orig) {
		if (dest != null && orig != null) {
			for (Iterator itr = orig.keySet().iterator(); itr.hasNext(); ) {
				Object key = itr.next();
				Object value = orig.get(key);
				
				try {
					if (value != null && !value.toString().equals("") && !value.toString().equals("0")) {
						String setterMethodName = buildFieldSetter(key.toString());
						Method setterMethod = dest.getClass().getMethod(setterMethodName,new Class[]{value.getClass()});
					
						try {
							setterMethod.invoke(dest,new Object[] {value});
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
				catch (NoSuchMethodException e) {
					//do nothing
				}				
			}
		}
	}
	public void copyProperties(Object dest,Object orig) {
		if (dest != null && orig != null) {
			Field[]fields = dest.getClass().getDeclaredFields();
			
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				
				try {
					String setterMethodName = buildFieldSetter(field.getName());
					Method setterMethod = dest.getClass().getMethod(setterMethodName,new Class[]{field.getType()});
					
					Object origValue = getObjectValue(orig,field.getName());
					if (origValue != null) {
						try {
							//if is entity, don't invoke.
							if (origValue.getClass().getName().startsWith("sg.com.pointcut")) {
								//get the same composite object from dest
								 Object destValue = getObjectValue(dest,field.getName());
								 //recurse in
								 copyProperties(destValue,origValue);
							}
							setterMethod.invoke(dest,new Object[]{origValue});
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
				catch (NoSuchMethodException e) {
					//do nothing
				}
			}
		}
	}
	
	public String buildFieldGetter(String fieldName) {
		char[] fieldNameChars = fieldName.toCharArray();
		fieldNameChars[0] = Character.toUpperCase(fieldNameChars[0]);

		return "get" + new String(fieldNameChars);
	}
	public String buildFieldSetter(String fieldName) {
		char[] fieldNameChars = fieldName.toCharArray();
		fieldNameChars[0] = Character.toUpperCase(fieldNameChars[0]);

		return "set" + new String(fieldNameChars);
	}
	
	public Object getObjectValue(Object object,String fieldName) {
		Object ret = null;
		Object targetObj = object;
		
		//if no delim
		if (fieldName.indexOf(GlobalKeys.OBJECT_DELIM) == -1) {
			try {
				ret = targetObj.getClass().getMethod(buildFieldGetter(fieldName), null).invoke(targetObj, null);
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		else {
			//if have delim
			//get tokens
			List tokens = new ArrayList();
			StringTokenizer st = new StringTokenizer(fieldName,GlobalKeys.OBJECT_DELIM);
			while (st.hasMoreTokens()) { tokens.add(st.nextToken()); }
			
			try {
				//go thru' tokens and get object value
				for (Iterator itr = tokens.iterator(); itr.hasNext(); ) {
					String token = itr.next().toString();
					Object objValue = targetObj.getClass().getMethod(buildFieldGetter(token), null).invoke(targetObj, null);
					
					//if object value not null
					if (objValue != null) {
						//if have next, then reassign target object
						if (itr.hasNext()) {
							targetObj = objValue;
						}
						else {
							ret = objValue;
						}
					}
				}				
				
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}

}
