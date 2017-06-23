package edu.umb.cs.cs680.hw15.FSVisitor;

import edu.umb.cs.cs680.hw15.FSElement.Directory;
import edu.umb.cs.cs680.hw15.FSElement.File;
import edu.umb.cs.cs680.hw15.FSElement.Link;

public class CountingVisitor implements FSVisitor {

	private int dirNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;

	@Override
	public void visit(Link link) {
		linkNum++;
	}

	@Override
	public void visit(Directory dir) {
		dirNum++;
	}

	@Override
	public void visit(File file) {
		fileNum++;
	}

	public int getDirNum() {
		return dirNum;
	}

	public int getFileNum() {
		return fileNum;
	}

	public int getLinkNum() {
		return linkNum;
	}

}
