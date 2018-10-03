package com.maven.TablePerConcrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerConcrete {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Parent p1 = new Parent(101, "Parent1");

		Child1 c11 = new Child1(111, "Parent_Child1", 11, "Child1");
		Child2 c22 = new Child2(222, "Parent_Child2", 22, "Child2");
		Child3 c33 = new Child3(333, "Parent_Child3", 33, "Child3");

		session.save(p1);
		session.save(c11);
		session.save(c22);
		session.save(c33);
		session.flush();
		transaction.commit();

	}

}

@Entity
@Table(name = "Parent_Info")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
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

@Entity
//@DiscriminatorValue(value = "C1")
@Table(name = "FirstChild")
//@AttributeOverrides({ @AttributeOverride(name = "pId", column = @Column(name = "pId")),
//		@AttributeOverride(name = "pName", column = @Column(name = "pName")) })
class Child1 extends Parent {
	@Column
	private int c11;
	private String c12;

	public int getC11() {
		return c11;
	}

	public void setC11(int c11) {
		this.c11 = c11;
	}

	public String getC12() {
		return c12;
	}

	public void setC12(String c12) {
		this.c12 = c12;
	}

	public Child1(int pId, String pName, int c11, String c12) {
		super(pId, pName);
		this.c11 = c11;
		this.c12 = c12;
	}

	@Override
	public String toString() {
		return "Child1 [c11=" + c11 + ", c12=" + c12 + "]";
	}

	public Child1() {
		super();
		// TODO Auto-generated constructor stub
	}

}

@Entity
@Table(name = "SecondChild")
//@AttributeOverrides({ @AttributeOverride(name = "pId", column = @Column(name = "pId")),
//		@AttributeOverride(name = "pName", column = @Column(name = "pName")) })
class Child2 extends Parent {
	@Column
	private int c21;
	private String c22;

	public int getC21() {
		return c21;
	}

	public void setC21(int c21) {
		this.c21 = c21;
	}

	public String getC22() {
		return c22;
	}

	public void setC22(String c22) {
		this.c22 = c22;
	}

	public Child2(int pId, String pName, int c21, String c22) {
		super(pId, pName);
		this.c21 = c21;
		this.c22 = c22;
	}

	@Override
	public String toString() {
		return "Child2 [c21=" + c21 + ", c22=" + c22 + "]";
	}

	public Child2() {
		super();
		// TODO Auto-generated constructor stub
	}

}
@Entity
@Table(name = "ThirdChild")
class Child3 extends Parent {
	@Column
	private int C31;
	private String C32;

	public int getC31() {
		return C31;
	}

	public void setC31(int c31) {
		C31 = c31;
	}

	public String getC32() {
		return C32;
	}

	public void setC32(String c32) {
		C32 = c32;
	}

	public Child3(int pId, String pName, int c31, String c32) {
		super(pId, pName);
		C31 = c31;
		C32 = c32;
	}

	@Override
	public String toString() {
		return "Child3 [C31=" + C31 + ", C32=" + C32 + "]";
	}

	public Child3() {
		super();
		// TODO Auto-generated constructor stub
	}

}
