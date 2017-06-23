package edu.umb.cs.cs680.hw11.repalcePolicy;

import java.io.File;
import java.util.HashMap;

public class NullReplacement implements CacheReplacementPolicy {

	private static NullReplacement instance = null;
	
	private NullReplacement(){
	}
	
	@Override
	public void replace(HashMap<String, File> hashMap, File file) {
		// Do nothing 

	}

	public static NullReplacement getInstance() {
		if (instance == null)
			instance = new NullReplacement();
		return instance;
	}

}
