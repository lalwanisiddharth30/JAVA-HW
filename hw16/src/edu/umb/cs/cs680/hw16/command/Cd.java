package edu.umb.cs.cs680.hw16.command;

import java.util.ArrayList;

import edu.umb.cs.cs680.hw16.facade.Directory;
import edu.umb.cs.cs680.hw16.facade.FSElement;
import edu.umb.cs.cs680.hw16.facade.FileSystem;

public class Cd implements Command {

	private String[] args;

	public Cd() {

	}

	public Cd(String[] args) {
		this.args = args;
	}

	@Override
	public void execute() {

		if (this.args == null) {
			FileSystem.setCurrent(FileSystem.getRoot());
			System.out.println("Current directory changed to root");
		} else if (FileSystem.getCurrent().getChildren().size() <= 0) {
			System.out.println("No Such Directory");
		} else if (args[1] == "..") {
			Directory parent = FileSystem.getCurrent().getParent();
			FileSystem.setCurrent(parent);
			System.out.println("Current directory changed to " + parent.getName());
		} else {
			ArrayList<FSElement> list = FileSystem.getCurrent().getChildren();
			for (FSElement f : list) {
				if (f.getName().contains(args[1])) {
					if (f.isFile()) {
						System.out.println(f.getName() + " is a File");
					} else {
						FileSystem.setCurrent((Directory) f);
						System.out.println("Current directory changed to " + f.getName());
						break;
					}

				}
			}
		}
	}

}
