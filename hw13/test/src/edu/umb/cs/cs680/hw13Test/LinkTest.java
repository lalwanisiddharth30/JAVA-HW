package src.edu.umb.cs.cs680.hw13Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import edu.umb.cs.cs680.hw13.FSElement.Directory;
import edu.umb.cs.cs680.hw13.FSElement.File;
import edu.umb.cs.cs680.hw13.FSElement.Link;
import edu.umb.cs.cs680.hw13.fileSystem.FileSystem;

public class LinkTest {

	@Test
	@SuppressWarnings("unused")
	public final void testGetTarget() {
		Directory root = FileSystem.getRoot();

		Directory system = new Directory("system", "cs680", 0, root);
		Directory home = new Directory("home", "hw12", 0, root);

		File a = new File("a", "system", 10, system);
		File b = new File("b", "system", 10, system);
		File c = new File("c", "system", 10, system);

		File d = new File("d", "home", 10, home);
		Link x = new Link("x", "home", 0, home, system);

		Directory pictures = new Directory("Pictures", "home", 0, home);

		File e = new File("e", "pictures", 10, pictures);
		File f = new File("f", "pictures", 12, pictures);
		Link y = new Link("y", "pictures", 0, pictures, e);

		assertThat(x.getTarget(), is(system));
		assertThat(y.getTarget(), is(e));
		
		assertNotEquals(x.getTargetSize(), 0);
	}

	@Test
	@SuppressWarnings("unused")
	public final void testGetTargetSize() {
		Directory root = FileSystem.getRoot();

		Directory system = new Directory("system", "cs680", 0, root);
		Directory home = new Directory("home", "hw12", 0, root);

		File a = new File("a", "system", 10, system);
		File b = new File("b", "system", 10, system);
		File c = new File("c", "system", 10, system);

		File d = new File("d", "home", 10, home);
		Link x = new Link("x", "home", 0, home, system);

		Directory pictures = new Directory("Pictures", "home", 0, home);

		File e = new File("e", "pictures", 10, pictures);
		File f = new File("f", "pictures", 12, pictures);
		Link y = new Link("y", "pictures", 0, pictures, e);

		assertThat(x.getTargetSize(), is(30));
		assertThat(y.getTargetSize(), is(10));
		
		assertEquals(x.getSize(), 0);
		assertEquals(y.getSize(), 0);

	}

}
