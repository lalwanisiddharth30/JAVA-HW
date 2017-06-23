package src.edu.umb.cs.cs680.hw12.FSElement;

import java.util.ArrayList;

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

}
