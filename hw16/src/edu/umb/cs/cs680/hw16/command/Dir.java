package edu.umb.cs.cs680.hw16.command;

import edu.umb.cs.cs680.hw16.facade.Directory;
import edu.umb.cs.cs680.hw16.facade.FSElement;
import edu.umb.cs.cs680.hw16.facade.FileSystem;

public class Dir implements Command {

	private String args;

	public Dir() {

	}

	public Dir(String args) {
		this.args = args;
	}

	@Override
	public void execute() {
		if (args == null) {
			Directory dir = FileSystem.getCurrent();
			if (dir.getChildren().size() > 0) {
				for (FSElement ele : dir.getChildren()) {
					if (ele.isFile()) {
						System.out.println("Name: " + ele.getName() + " Owner: " + ele.getOwner() + " Kind: File/Link");
					} else {
						System.out.println("Name: " + ele.getName() + " Owner: " + ele.getOwner() + " Kind: Directory");
					}
				}
			} else {
				System.out.println("Name: " + dir.getName() + " Owner: " + dir.getOwner() + " Kind: Directory");
				System.out.println("This Directory is empty");
			}
		} else if (args.startsWith("..")) {
			String [] arg = args.split("..");
			FSElement ele = searchAllElements(arg[1]);
			if (ele.isFile()) {
				System.out.println("Name: " + ele.getName() + " Owner: " + ele.getOwner() + " Kind: File/Link");
			} else {
				System.out.println("Name: " + ele.getName() + " Owner: " + ele.getOwner() + " Kind: Directory");
			}
		}
	}

	public FSElement searchAllElements(String searchDir) {
		FSElement ele = null;
		for (FSElement element : FileSystem.getRoot().getChildren()) {
			if(!element.isFile() && element.getName() == searchDir){
				ele = (Directory) element;
			}else{
				searchAllElements(element.getName());
			}
		}
		return ele;
	}
}
