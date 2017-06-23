package edu.umb.cs.cs680.hw11.fileCache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import edu.umb.cs.cs680.hw11.repalcePolicy.*;

public class FileCache {

	private static FileCache instance = null;
	private HashMap<String, File> cache = new HashMap<>();
	private static CacheReplacementPolicy cacheReplacementPolicy = null;
	
	private FileCache() {
	}

	/**
	 * @return the instance
	 */
	public static FileCache getInstance() {
		if (instance == null)
			instance = new FileCache();
		
		// Set NullReplacement as default replacement policy
		setCacheReplacementPolicy(NullReplacement.getInstance());
		return instance;
	}

	public String fetch(String targetFile) {

		// Check the cache first
		if (cache.get(targetFile) != null) {
			BufferedReader br = null;

			StringBuilder sCurrentLine = new StringBuilder();

			try {
				FileReader reader = new FileReader(cache.get(targetFile).getAbsolutePath());
				br = new BufferedReader(reader);
				String current;
				while ((current = br.readLine()) != null) {
					if (sCurrentLine.length() <= 0)
						sCurrentLine.append("");
					sCurrentLine.append(current + "\n");
				}
			} catch (Exception e) {
				System.out.println("Error: Can't read the file. Possibly file not found.");
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
			}
			return sCurrentLine.toString();

			// Else decide if it is to be replaced for simply be cached
		} else {
			if (cache.size() > 1) {
				File file = new File("");

				String path = file.getAbsolutePath().concat("/src/edu/umb/cs/cs680/hw11/fileCache/" + targetFile);

				File toBeCached = new File(path);

				StringBuilder sCurrentLine = new StringBuilder();

				if (toBeCached.exists()) {
					this.replace(path);

					BufferedReader br = null;

					try {
						FileReader reader = new FileReader(path);
						br = new BufferedReader(reader);
						String current;
						while ((current = br.readLine()) != null) {
							if (sCurrentLine.length() <= 0)
								sCurrentLine.append("");
							sCurrentLine.append(current + "\n");
						}
					} catch (Exception e) {
						System.out.println("Error: Can't read the file. Possibly file not found.");
					} finally {
						if (br != null)
							try {
								br.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
							}
					}
				}else{
					System.out.println("No Such File --> " + toBeCached.getName());
				}

				return sCurrentLine.toString();
			} else {
				File file = new File("");

				String path = file.getAbsolutePath().concat("/src/edu/umb/cs/cs680/hw11/fileCache/" + targetFile);

				File toBeCached = new File(path);

				BufferedReader br = null;

				StringBuilder sCurrentLine = new StringBuilder();

				if (toBeCached.exists()) {
					try {
						FileReader reader = new FileReader(path);
						br = new BufferedReader(reader);
						String current;
						while ((current = br.readLine()) != null) {
							if (sCurrentLine.length() <= 0)
								sCurrentLine.append("");
							sCurrentLine.append(current + "\n");
						}
					} catch (Exception e) {
						System.out.println("Error: Can't read the file. Possibly file not found.");
					} finally {
						if (br != null)
							try {
								br.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
							}
					}

					cache.put(toBeCached.getName(), toBeCached);
				}else{
					System.out.println("No Such File --> " + toBeCached);
				}
				return sCurrentLine.toString();
			}
		}
	}

	private void replace(String targetFile) {
		File file = new File(targetFile);
		
		if(cache.size() > 1)
			setCacheReplacementPolicy(FIFO.getInstance());
	
		cacheReplacementPolicy.replace(cache, file);
	}

	public static void setCacheReplacementPolicy(CacheReplacementPolicy cacheReplacementPolicy) {
		FileCache.cacheReplacementPolicy = cacheReplacementPolicy;
	}

	public static CacheReplacementPolicy getCacheReplacementPolicy() {
		return cacheReplacementPolicy;
	}

	public HashMap<String, File> getCache() {
		return cache;
	}
}
