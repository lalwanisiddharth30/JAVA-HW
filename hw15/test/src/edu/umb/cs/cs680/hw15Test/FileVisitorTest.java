package src.edu.umb.cs.cs680.hw15Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import edu.umb.cs.cs680.hw15.FSElement.Directory;
import edu.umb.cs.cs680.hw15.FSElement.File;
import edu.umb.cs.cs680.hw15.FSElement.Link;
import edu.umb.cs.cs680.hw15.FSVisitor.FileSearchVisitor;
import edu.umb.cs.cs680.hw15.fileSystem.FileSystem;

public class FileVisitorTest {

	@Test
	@SuppressWarnings("unused")
	public final void testFileSearchVisitor() {
		Directory root = FileSystem.getRoot();

		Directory system = new Directory("system", "cs680", 0, root);
		Directory home = new Directory("home", "hw12", 0, root);

		File a = new File("a.txt", "system", 10, system);
		File b = new File("b", "system", 10, system);
		File c = new File("c.txt", "system", 10, system);

		File d = new File("d", "home", 10, home);
		Link x = new Link("x", "home", 0, home, system);

		Directory pictures = new Directory("Pictures", "home", 0, home);

		File e = new File("e.txt", "pictures", 10, pictures);
		File f = new File("f", "pictures", 12, pictures);
		Link y = new Link("y", "pictures", 0, pictures, e);
		
		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		
		system.accept(visitor);
		
		int fileNum = visitor.getFoundFiles().size();
		
		assertThat(fileNum, is(2));
	}

	@Test
	@SuppressWarnings("unused")
	public final void testVisitFile() {
		Directory root = FileSystem.getRoot();

		Directory system = new Directory("system", "cs680", 0, root);
		Directory home = new Directory("home", "hw12", 0, root);

		File a = new File("a.txt", "system", 10, system);
		File b = new File("b", "system", 10, system);
		File c = new File("c.txt", "system", 10, system);

		File d = new File("d", "home", 10, home);
		Link x = new Link("x", "home", 0, home, system);

		Directory pictures = new Directory("Pictures", "home", 0, home);

		File e = new File("e.txt", "pictures", 10, pictures);
		File f = new File("f.txt", "pictures", 12, pictures);
		Link y = new Link("y", "pictures", 0, pictures, e);
		
		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		
		pictures.accept(visitor);
		
		ArrayList<File> visited = visitor.getFoundFiles();
		ArrayList<File> visited1 = new ArrayList<>();
		visited1.add(e);
		visited1.add(f);
		
		assertThat(visited, is(visited1));
	}

	@Test
	@SuppressWarnings("unused")
	public final void testGetFoundFiles() {
		/*
		 * It will be same as above
		 */
		Directory root = FileSystem.getRoot();

		Directory system = new Directory("system", "cs680", 0, root);
		Directory home = new Directory("home", "hw12", 0, root);

		File a = new File("a.txt", "system", 10, system);
		File b = new File("b", "system", 10, system);
		File c = new File("c.txt", "system", 10, system);

		File d = new File("d", "home", 10, home);
		Link x = new Link("x", "home", 0, home, system);

		Directory pictures = new Directory("Pictures", "home", 0, home);

		File e = new File("e.txt", "pictures", 10, pictures);
		File f = new File("f.txt", "pictures", 12, pictures);
		Link y = new Link("y", "pictures", 0, pictures, e);
		
		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		
		pictures.accept(visitor);
		
		ArrayList<File> visited = visitor.getFoundFiles();
		ArrayList<File> visited1 = new ArrayList<>();
		visited1.add(e);
		visited1.add(f);
		
		assertThat(visited, is(visited1));
	}

}
