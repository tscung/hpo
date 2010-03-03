package sg.com.stellarstudios.imser.service;

import sg.com.stellarstudios.imser.common.LocalCache;

public class LocalCacheService extends BaseService {
	public void clearCaches() {
		LocalCache.getInstance().clearCaches();
	}
}
