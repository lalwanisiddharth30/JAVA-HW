package edu.umb.cs.cs680.hw10.repalcePolicy;
import java.io.File;
import java.util.HashMap;

public interface CacheReplacementPolicy {
	public void replace(HashMap<String, File> hashMap, File file);
}
