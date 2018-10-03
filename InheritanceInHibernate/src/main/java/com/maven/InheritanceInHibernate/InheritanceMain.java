package com.maven.InheritanceInHibernate;

import javax.persistence.Inheritance;

public class InheritanceMain {

	public static void main(String[] args) 
	{
	
	}

}
@Inheritance
class Parent 
{
	private int pId;
	private String pName;
	public Parent(int pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;
	}
	@Override
	public String toString() {
		return "Parent [pId=" + pId + ", pName=" + pName + "]";
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}