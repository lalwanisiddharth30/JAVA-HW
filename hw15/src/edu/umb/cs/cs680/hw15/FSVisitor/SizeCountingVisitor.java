package edu.umb.cs.cs680.hw15.FSVisitor;

import edu.umb.cs.cs680.hw15.FSElement.Directory;
import edu.umb.cs.cs680.hw15.FSElement.File;
import edu.umb.cs.cs680.hw15.FSElement.Link;

public class SizeCountingVisitor implements FSVisitor {

	private int totalSize = 0;

	@Override
	public void visit(Link link) {
		totalSize += link.getDiskUtil();
	}

	@Override
	public void visit(Directory dir) {
		totalSize += dir.getDiskUtil();
	}

	@Override
	public void visit(File file) {
		totalSize += file.getDiskUtil();
	}

	public int getTotalSize() {
		return totalSize;
	}

}
