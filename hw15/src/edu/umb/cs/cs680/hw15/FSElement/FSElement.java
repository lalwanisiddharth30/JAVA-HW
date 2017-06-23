package edu.umb.cs.cs680.hw15.FSElement;

import java.util.Date;

import edu.umb.cs.cs680.hw15.FSVisitor.FSVisitor;

public class FSElement {
	
	private String name;
	private String owner;
	private int size;
	private final Date created;
	private Date lastModified;
	private Directory parent;
	private boolean isFile;
	
	/**
	 * @param name
	 * @param owner
	 * @param size
	 * @param created
	 * @param lastModified
	 * @param directory
	 */
	public FSElement(String name, String owner, int size, Directory parent) {
		this.name = name;
		this.owner = owner;
		this.size = size;
		this.created = new Date();
		this.lastModified = new Date();
		this.parent = parent;
	}

	public void accept(FSVisitor visitor){
		
	}
	
	public int getDiskUtil(){
		return this.size;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getCreated() {
		return created;
	}

	public boolean isFile() {
		return isFile;
	}

	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

}
