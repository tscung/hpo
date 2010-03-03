package sg.com.stellarstudios.imser.common;


public class GlobalKeys {
	public static final int CREATE_FLAG = 0;
	public static final int UPDATE_FLAG = 1;
	public static final int RETRIEVE_FLAG = 2;
	public static final int SEARCH_FLAG = 3;
	public static final int ADD_FLAG = 4;
	public static final int REMOVE_FLAG = 5;

	public static final String SORTORDER_ASC = "asc";
	public static final String SORTORDER_DESC = "desc";
	
	public static final String OBJECT_DELIM = ".";
	public static final String CALENDAR_DELIM = "/";
	public static final String TIME_DELIM = ":";

	public static final String YES_VALUE = "Yes";
	public static final String NO_VALUE = "No";

	public static final String CONFIGURATION_DELIM = ",";

	public static final int REGISTRATION_STATUS_UNSAVED = 0;
	public static final int REGISTRATION_STATUS_SAVED = 1;
	public static final int REGISTRATION_STATUS_SUBMITTED = 2;
	
	public static final int REGISTRATION_NOT_APPROVED_YET = 1;
	public static final int REGISTRATION_APPROVED = 2;
	public static final int REGISTRATION_DISAPPROVED = 3;
	
	public static final String EXCEL_OUTPUT_WORKSHEET = "data";
	
	public static final int ADMIN_USER_ID = 1;
	
	public static final int[] EVENT_MAX_CAP = new int[]{80, 40, 30, 34, 80, 999999};
	
	public static final int PARAM_TYPE_STRING = 1;
	public static final int PARAM_TYPE_INTEGER = 2;
	public static final int PARAM_TYPE_BOOLEAN = 3;
	public static final int PARAM_TYPE_CALENDAR = 4;
}
