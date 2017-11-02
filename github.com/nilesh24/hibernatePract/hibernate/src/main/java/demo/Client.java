package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("demo1.xml");
		EmpDAO dao = ctx.getBean("empDao", EmpDAO.class);

//		for (int i = 1; i < 5; i++) {
//
//			Dept d = new Dept();
//			d.setDname("HR"+i);
//
//			Emp e = new Emp("A" + i, 2000 * i);
//			e.getDept().add(d);
//			dao.create(e);
//			System.out.println("Added ::" + e);
//		}
//
//		for (int i = 1; i < 5; i++) {
//
//			Dept d = new Dept();
//			d.setDname("Admin");
//
//			Emp e = new Emp("G" + i, 1500 * i);
//			e.getDept().add(d);
//			dao.create(e);
//			System.out.println("Added ::" + e);
//		}

	//	dao.getEmp("A3");
		// dao.getDept("ADMIN");
		
		
		dao.getEmp1();
	}

}
