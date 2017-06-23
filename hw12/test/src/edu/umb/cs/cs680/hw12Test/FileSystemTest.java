package src.edu.umb.cs.cs680.hw12Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

import src.edu.umb.cs.cs680.hw12.FSElement.Directory;
import src.edu.umb.cs.cs680.hw12.FSElement.File;
import src.edu.umb.cs.cs680.hw12.fileSystem.FileSystem;

public class FileSystemTest {

	@Test
	public final void testFileSystem() {

		Directory root = FileSystem.getRoot();

		Directory system = new Directory("system", "cs680", 0, root);
		Directory home = new Directory("home", "hw12", 0, root);

		File a = new File("a", "system", 10, system);
		File b = new File("b", "system", 10, system);
		File c = new File("c", "system", 10, system);

		File d = new File("d", "home", 10, home);

		Directory pictures = new Directory("Pictures", "home", 0, home);

		File e = new File("e", "pictures", 10, pictures);
		File f = new File("f", "pictures", 12, pictures);

		assertThat(a.getSize(), is(10));
		assertThat(b.getName(), is("b"));
		assertThat(c.getOwner(), is("system"));
		assertThat(d.getParent(), is(home));
		assertThat(e.getParent(), is(pictures));
		assertThat(f.getSize(), is(12));
	}

	@Test
	@SuppressWarnings("unused")
	public final void testShowAllElements() {
		FileSystem fileSystem = FileSystem.getfileSystem();
		Directory root = FileSystem.getRoot();

		Directory system = new Directory("system", "cs680", 0, root);
		Directory home = new Directory("home", "hw12", 0, root);

		File a = new File("a", "system", 10, system);
		File b = new File("b", "system", 10, system);
		File c = new File("c", "system", 10, system);

		File d = new File("d", "home", 10, home);

		Directory pictures = new Directory("Pictures", "home", 0, home);

		File e = new File("e", "pictures", 10, pictures);
		File f = new File("f", "pictures", 12, pictures);

		OutputStream outContent = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(outContent);
		System.setOut(stream);

		String output = "system This element is Directory\n" + "a This element is File\n" + "b This element is File\n"
				+ "c This element is File\n" + "home This element is Directory\n" + "d This element is File\n"
				+ "Pictures This element is Directory\n" + "e This element is File\n" + "f This element is File\n";

		fileSystem.showAllElements(root);
		assertThat(output, is(outContent.toString()));
	}

}
