package edu.umb.cs.cs680.hw15.FSVisitor;

import edu.umb.cs.cs680.hw15.FSElement.Directory;
import edu.umb.cs.cs680.hw15.FSElement.File;
import edu.umb.cs.cs680.hw15.FSElement.Link;

public interface FSVisitor {
	void visit(Link link);
	void visit(Directory dir);
	void visit(File file);
}
