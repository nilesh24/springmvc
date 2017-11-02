package demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Dept {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int deptno;
	
	
	private String dname;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="deptList")
//	@JoinTable(name="emp_dept",
//	joinColumns={@JoinColumn(name="deptno", referencedColumnName="deptno")}
//	, inverseJoinColumns={@JoinColumn(name="empno" , referencedColumnName="empno")})
	private Set<Emp> empList;
	
	
	public Set<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(Set<Emp> empList) {
		this.empList = empList;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", empList=" + empList ;
	}
	
	
}
