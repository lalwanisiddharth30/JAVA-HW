package edu.umb.cs.cs680.hw10.repalcePolicy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FIFO implements CacheReplacementPolicy {

	private static FIFO instance = null;
	
	private FIFO(){
	}
	
	
	@Override
	public void replace(HashMap<String, File> hashMap, File file) {
		
		Map.Entry<String, File> entry = hashMap.entrySet().iterator().next();
		
		hashMap.remove(entry.getKey());
		hashMap.put(file.getName(), file);
	}

	/**
	 * @return the instance
	 */
	public static FIFO getInstance() {
		if (instance == null)
			instance = new FIFO();
		return instance;
	}

}
