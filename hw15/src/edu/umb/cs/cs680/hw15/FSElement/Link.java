package edu.umb.cs.cs680.hw15.FSElement;

import edu.umb.cs.cs680.hw15.FSVisitor.FSVisitor;
import edu.umb.cs.cs680.hw15.fileSystem.FileSystem;

public class Link extends FSElement {

	private FSElement target;
    
	public Link(String name, String owner, int size, Directory parent, FSElement target) {
		super(name, owner, size, parent);
		// TODO Auto-generated constructor stub
		super.setFile(true);
	    if(parent != null)
	    	parent.appendChild(this);
	    else
	    	FileSystem.getRoot().appendChild(this);
	    
		setTarget(target);
	}

	public FSElement getTarget() {
		return target;
	}

	public void setTarget(FSElement target) {
		this.target = target;
	}
	
	public int getTargetSize() {
		return this.target.getSize();
	}
	
	@Override
	public void accept(FSVisitor visitor){
		visitor.visit(this);
	}
	
	@Override
	public int getDiskUtil(){
		return 0;
	}
}