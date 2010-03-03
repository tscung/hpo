package sg.com.stellarstudios.imser.common;

import java.util.HashMap;
import java.util.Map;


public class LocalCache {
	private static LocalCache me;

	public LocalCache() {
		methodCache = new HashMap();
	}
	public static LocalCache getInstance() {
		if (me == null) me = new LocalCache();
		return me;
	}
	
	//METHOD CACHE. ONLY 1 ENTRY PER METHOD.
	/* CACHED METHODS:
	 * UserService.isEmailRegistered();
	 */
	private Map methodCache;
	public Object get(String key) { return methodCache.get(key); }
	public void put(String key, Object obj) { methodCache.put(key, obj); }

	public void clearEmailRegisteredCache() {
		if (methodCache.get("isEmailRegistered") != null) ((Map)methodCache.get("isEmailRegistered")).clear();
	}
	
	//publically invoked method
	public void clearCaches() {
		ServiceLocator.getInstance().getLogHelper().info("clearing caches");
		methodCache.clear();
		clearEmailRegisteredCache();
		ServiceLocator.getInstance().getLogHelper().info("done clearing caches");
	}
}
