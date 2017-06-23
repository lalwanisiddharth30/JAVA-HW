package src.edu.umb.cs.cs680.hw10Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import edu.umb.cs.cs680.hw10.fileCache.FileCache;
import edu.umb.cs.cs680.hw10.repalcePolicy.CacheReplacementPolicy;
import edu.umb.cs.cs680.hw10.repalcePolicy.FIFO;

public class FileCacheTest {

	@Test
	public final void testGetInstance() {
		// Should return same instance every time.
		FileCache file = FileCache.getInstance();
		FileCache file1 = FileCache.getInstance();
		FileCache file2 = FileCache.getInstance();

		// Test first and second instance
		assertThat(file, is(file1));

		// Test second and third instance
		assertThat(file1, is(file2));

		// Test third and first instance
		assertThat(file2, is(file));

	}

	@Test
	public final void testFetchFileInCache() {
		// First it should add the file to cache and then when called with the
		// same file name it should just return the file contents from the cache

		/**
		 * Phase I
		 */
		FileCache file = FileCache.getInstance();
		file.fetch("FileCache.java");

		HashMap<String, File> cache = new HashMap<>();

		File file1 = new File(""); // this is done inside the
									// fetch method

		File file2 = new File(file1.getAbsolutePath() + "/src/edu/umb/cs/cs680/hw10/fileCache/FileCache.java");

		cache.put(file2.getName(), file2);

		HashMap<String, File> cache2 = file.getCache();

		assertThat(cache.get(file2.getName()), is(cache2.get(file2.getName()))); // should
																					// pass

		/**
		 * Phase II
		 */
		// call fetch again with the same file name and it should return its
		// contents because it is in cache now and should perform any other
		// action

		// get the contents of file to be tested
		BufferedReader br = null;

		StringBuilder sCurrentLine = new StringBuilder(); // to store the
															// contents of file
															// to print or use
															// in any way
		// System.out.println(cache.get(file1.getName()).getAbsolutePath());
		try {
			FileReader reader = new FileReader(cache2.get(file2.getName()));
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
				}
		}

		// System.out.println(file.fetch(sCurrentLine.toString()));
		// returned contents should be same as "sCurrentLine" here
		// calling file.fetch() in test method itself to get returned value
		assertThat(sCurrentLine.toString(), is(file.fetch("FileCache.java")));
	}

	@Test
	public final void testFetchFileNotInCache() {

		// should add the file to cache, similar to above test
		FileCache file = FileCache.getInstance();
		file.fetch("FileCache.java");

		HashMap<String, File> cache = new HashMap<>();

		File file1 = new File("FileCache.java"); // this is done inside the
													// fetch method

		cache.put(file1.getName(), file1);

		HashMap<String, File> cache2 = file.getCache();

		assertThat(cache.get(file1), is(cache2.get(file1))); // should pass
	}

	@Test
	public final void testFetchCacheNotFull() {
		FileCache file = FileCache.getInstance();
		file.fetch("FileCache.java");

		// should add another file and not replace the old one
		// increasing the size of cache to 2
		file.fetch("hello.txt");
		
		assertThat(file.getCache().size(), is(2));
	}

	@Test
	public final void testSetCacheReplacementPolicy() {
		// Sets replacement policy, in this case only FIFO

		FileCache.setCacheReplacementPolicy(FIFO.getInstance());

		CacheReplacementPolicy fifo = FIFO.getInstance();

		CacheReplacementPolicy fromFileCache = FileCache.getCacheReplacementPolicy();

		assertThat(fifo, is(fromFileCache));
	}

	@Test
	public final void testGetCacheReplacementPolicy() {
		// Same as test setter
		FileCache.setCacheReplacementPolicy(FIFO.getInstance());

		CacheReplacementPolicy fifo = FIFO.getInstance();

		CacheReplacementPolicy fromFileCache = FileCache.getCacheReplacementPolicy();

		assertThat(fifo, is(fromFileCache));
	}
}
