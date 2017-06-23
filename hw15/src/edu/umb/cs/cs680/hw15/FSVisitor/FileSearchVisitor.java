package edu.umb.cs.cs680.hw15.FSVisitor;

import java.util.ArrayList;

import edu.umb.cs.cs680.hw15.FSElement.Directory;
import edu.umb.cs.cs680.hw15.FSElement.File;
import edu.umb.cs.cs680.hw15.FSElement.Link;

public class FileSearchVisitor implements FSVisitor {

	private String extension;
	private ArrayList<File> foundFiles = new ArrayList<>();

	public FileSearchVisitor(String extension) {
		this.extension = extension;
	}

	@Override
	public void visit(Link link) {
	}

	@Override
	public void visit(Directory dir) {
	}

	@Override
	public void visit(File file) {
		if (file.getName().contains(extension))
			foundFiles.add(file);
	}

	public ArrayList<File> getFoundFiles() {
		return foundFiles;
	}

}
