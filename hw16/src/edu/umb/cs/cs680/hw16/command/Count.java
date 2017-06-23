package edu.umb.cs.cs680.hw16.command;

import edu.umb.cs.cs680.hw16.FSVisitor.CountingVisitor;
import edu.umb.cs.cs680.hw16.facade.FileSystem;

public class Count implements Command {

	@Override
	public void execute() {
		CountingVisitor visitor = new CountingVisitor();
		FileSystem.getCurrent().accept(visitor);
		System.out.println("Number of Directories: " + visitor.getDirNum() + "\nNumber of Files: "
				+ visitor.getFileNum() + "\nNumber of Links: " + visitor.getLinkNum());
	}
}
