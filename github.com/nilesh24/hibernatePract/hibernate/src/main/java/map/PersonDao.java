package map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.Emp;

@Repository
public class PersonDao {

	
	@Autowired
	private SessionFactory sf = null;
	
	
	public void createPerson(Person p){
		Session session = sf.openSession();
		org.hibernate.Transaction tr1 = session.beginTransaction();
			session.save(p);
			 
			 System.out.println("p:::"+p);
			tr1.commit();
			session.close();
	}


	public void getPerson() {
		Session session = sf.openSession();
		org.hibernate.Transaction tr1 = session.beginTransaction();
		Person p1 =	(Person)session.load(Person.class,4);
		System.out.println("p1::"+p1.toString());
		System.out.println("p1::"+p1.getVehicle());		
			tr1.commit();
			session.close();
			
			
			
		
	}


	public void getVehicle() {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		org.hibernate.Transaction tr1 = session.beginTransaction();
		Vehicle p1 =	(Vehicle)session.load(Vehicle.class,1);
		System.out.println("p1::"+p1.toString());
		System.out.println("p1::"+p1.getPerson());		
			tr1.commit();
			session.close();
		
	}


	public void createVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		org.hibernate.Transaction tr1 = session.beginTransaction();
			session.save(vehicle);
			 
			 System.out.println("v:::"+vehicle);
			tr1.commit();
			session.close();
		
	}

}
