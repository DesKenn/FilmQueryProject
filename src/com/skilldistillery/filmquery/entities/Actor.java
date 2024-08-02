package com.skilldistillery.filmquery.entities;

public class Actor {
	private String fname;
	private String lname;
	private int id;
	
	
	public Actor() {
		super();
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Actor(String fname, String lname, int id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Actor [fname=" + fname + ", lname=" + lname + ", id=" + id + "]";
	}

	

}
