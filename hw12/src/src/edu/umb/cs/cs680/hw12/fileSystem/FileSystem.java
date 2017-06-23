package src.edu.umb.cs.cs680.hw12.fileSystem;

import src.edu.umb.cs.cs680.hw12.FSElement.Directory;
import src.edu.umb.cs.cs680.hw12.FSElement.FSElement;

public class FileSystem {

	private static Directory root = null;
	private static FileSystem fileSystem = null;

	private FileSystem(){
		// empty private constructor
	}
	
	public static Directory getRoot() {
		if (root == null)
			root = new Directory("root", "cs680", 0, null);
		return root;
	}

	public static FileSystem getfileSystem() {
		if(fileSystem == null)
			fileSystem = new FileSystem();
		return fileSystem;
	}
	
	public void showAllElements(Directory root) {
		for (FSElement element : root.getChildren()) {
			if (element.isFile())
				System.out.println(element.getName() + " This element is File");
			else {
				Directory dir = (Directory)element;
				System.out.println(element.getName() + " This element is Directory");
				if(dir.getChildren().size() > 0){
					showAllElements(dir);
				}
			}

		}
	}
}
