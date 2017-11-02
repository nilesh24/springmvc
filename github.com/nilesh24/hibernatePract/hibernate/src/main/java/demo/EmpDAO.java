package demo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.NamedQuery;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository(value="empDao")
@EnableTransactionManagement
@Transactional(propagation=Propagation.REQUIRED)
public class EmpDAO {
	private HibernateTemplate template = null;
	@Autowired
	private SessionFactory sf = null;

	@PostConstruct
	public void initmethod() {
		template = new HibernateTemplate(sf);
	}

	public void create(Emp d) {
		
		template.saveOrUpdate(d);
	}
	

	public List<Emp> getEmp(String ename){
	//	List<Emp> empList = (List<Emp>) template.find("from Emp e");
		
//		System.out.println(empList + ":::");
Session sessin = sf.openSession();
		org.hibernate.Transaction tr = sessin.beginTransaction();
		Emp d = sessin.get(Emp.class, 5);
		System.out.println("d::"+d);
		
		List<Object[]> empList = (sessin.createQuery("select e1.ename, d1.dname from Emp e1 inner join e1.deptList d1"
				).list());
		for(Object[] e : empList){
			System.out.println("::::"+e[0]+":::"+e[1]);
			
		}
		
	tr.commit();
	sessin.close();
	
	Session session = sf.openSession();
	org.hibernate.Transaction tr1 = session.beginTransaction();
		Emp d1 = session.get(Emp.class, 2);
		 
		 System.out.println("d:::"+d1);
		tr1.commit();
		session.close();
		System.out.println("d:::"+d1.getDept().toString());
		
//		 session = sf.openSession();
//		 org.hibernate.Transaction tr2 = session.beginTransaction();
//			 d1 = session.load(Emp.class, 3);
//			 
//			 System.out.println("d load:::"+d1);
//			tr2.commit();
//			session.close();
//			System.out.println("d:::"+d1.getDept().toString());
//		
		return null;
	}
	
	public List<Dept> getDept(String dname){
		
		Session sessin = sf.openSession();
		
	//	List<Dept> deptList = (List<Dept>) template.find("select e from Dept e where dname=?", dname);
		//System.out.println(deptList + "...."+deptList.get(0).getEmpList());
		
		org.hibernate.Transaction tr = sessin.beginTransaction();
			Dept d = sessin.get(Dept.class, 5);
			System.out.println("d::"+d);
			System.out.println("emp from d :"+d.getEmpList());
		tr.commit();
		sessin.close();
	
		return null;
	}
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	
	public void getEmp1(){
		
		
		Session session = sf.openSession();
		org.hibernate.Transaction tr1 = session.beginTransaction();
		
			Emp d1 = session.get(Emp.class, 1);
			 
			 System.out.println("d:::"+d1);
			
			
			System.out.println("d:::"+d1.getDept().toString());
			tr1.commit();
			session.close();
//			 session = sf.openSession();
//			 org.hibernate.Transaction tr2 = session.beginTransaction();
//				 d1 = session.load(Emp.class, 3);
//				 
//				 System.out.println("d load:::"+d1);
//				tr2.commit();
//				session.close();
//				System.out.println("d:::"+d1.getDept().toString());
//			
			
		}
		
	
	
}
