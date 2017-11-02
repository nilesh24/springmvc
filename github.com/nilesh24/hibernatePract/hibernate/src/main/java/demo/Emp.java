package demo;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int empno;
	private String ename;
	private double salary;
	
	@ManyToMany(cascade= {CascadeType.ALL} )
	@JoinTable(name="emp_dept",
	joinColumns={@JoinColumn(name="empno", referencedColumnName="empno")}
	, inverseJoinColumns={@JoinColumn(name="deptno" , referencedColumnName="deptno")}
			)
	Collection<Dept> deptList;
	
	
	
	public 	Collection<Dept> getDept() {
		return deptList;
	}

	public void setDept(Collection<Dept> dept) {
		this.deptList = dept;
	}

	public Emp(){}
	
	public Emp(String ename, double salary) {
		super();
		
		this.ename = ename;
		this.salary = salary;
		
		deptList = new HashSet<Dept>();
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", salary=" + salary + ", deptList="+deptList ;
	}
	
	
	

}
