package src.edu.umb.cs.cs680.hw15Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


import org.junit.Test;

import edu.umb.cs.cs680.hw15.FSElement.Directory;
import edu.umb.cs.cs680.hw15.FSElement.FSElement;
import edu.umb.cs.cs680.hw15.fileSystem.FileSystem;
import edu.umb.cs.cs680.hw15.FSElement.File;

public class FSElementTest {

	@Test
	public final void testGetName() {
		FSElement directory = new Directory("test", "root", 0, FileSystem.getRoot());
		String name = directory.getName();
		assertThat(name, is("test"));
	}

	@Test
	public final void testSetName() {
		FSElement directory = new Directory("test", "root", 0, FileSystem.getRoot());
		directory.setName("testSet");
		String name = directory.getName();
		assertThat(name, is("testSet"));
	}

	@Test
	public final void testGetOwner() {
		FSElement directory = new Directory("test", "root", 0, FileSystem.getRoot());
		String owner = directory.getOwner();
		assertThat(owner, is("root"));
	}

	@Test
	public final void testSetOwner() {
		FSElement directory = new Directory("test", "root", 0, FileSystem.getRoot());
		FSElement dir = new Directory("dir", "root", 0, FileSystem.getRoot());
		
		directory.setOwner(dir.getName());
		assertThat(directory.getOwner(), is(dir.getName()));
	}

	@Test
	public final void testGetSize() {
		FSElement file = new File("test", "root", 10, FileSystem.getRoot());
		int size = file.getSize();
		assertThat(size, is(10));
	}

	@Test
	public final void testSetSize() {
		FSElement file = new File("test", "root", 10, FileSystem.getRoot());
		file.setSize(15);
		int size = file.getSize();
		assertThat(size, is(15));
	}

	@Test
	public final void testIsFile() {
		FSElement file = new File("test", "root", 10, FileSystem.getRoot());
		boolean isFile = file.isFile();
		
		assertEquals(isFile, true);
		
		FSElement directory = new Directory("test", "root", 0, FileSystem.getRoot());
		boolean isFile1 = directory.isFile();
		
		assertThat(isFile1, is(false));
	}

	@Test
	public final void testGetParent() {
		FSElement directory = new Directory("test", "root", 0, FileSystem.getRoot());
		
		assertThat(directory.getParent(), is(FileSystem.getRoot()));
	}

	@Test
	public final void testSetParent() {
		FSElement directory = new Directory("test", "root", 0, FileSystem.getRoot());
		FSElement dir = new Directory("dir", "root", 0, FileSystem.getRoot());

		directory.setParent((Directory)dir);
		
		assertThat(directory.getParent(), is(dir));
		assertNotEquals(directory.getParent(), FileSystem.getRoot());
	}

}
