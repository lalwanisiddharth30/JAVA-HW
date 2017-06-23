package edu.umb.cs.cs680.hw13.FSElement;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends FSElement {

	private ArrayList<FSElement> children;

	public Directory(String name, String owner, int size, Directory parent) {
		super(name, owner, size, parent);
		// TODO Auto-generated constructor stub
		super.setFile(false);
		this.children = new ArrayList<>();
		if(parent != null)
			parent.appendChild(this);
	}

	public void appendChild(FSElement element){
		this.children.add(element);
	}
	
	public ArrayList<FSElement> getChildren() {
		return children;
	}

	@Override
	public int getSize(){
		int totalSize = 0;
		Iterator<FSElement> it = getChildren().iterator();
		while(it.hasNext()){
			FSElement element = it.next();
			totalSize += element.getSize();
		}
		return totalSize;
	}
}
