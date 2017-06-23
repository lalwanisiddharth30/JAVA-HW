package src.edu.umb.cs.cs680.hw12.FSElement;

import src.edu.umb.cs.cs680.hw12.fileSystem.FileSystem;

public class File extends FSElement {

	public File(String name, String owner, int size, Directory parent) {
		super(name, owner, size, parent);
		// TODO Auto-generated constructor stub
		super.setFile(true);
		if(parent != null)
			parent.appendChild(this);
		else
			FileSystem.getRoot().appendChild(this);
	}

}
