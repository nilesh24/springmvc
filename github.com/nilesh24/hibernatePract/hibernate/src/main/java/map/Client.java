package map;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("demo1.xml");

		PersonDao dao = ctx.getBean("personDao", PersonDao.class);

//		for (int i = 1; i < 5; i++) {
//			Person person = new Person("A" + i, 20 + i);
//			if (person.getVehicle() == null) {
//				person.setVehicle(new ArrayList<Vehicle>());
//			}
//			Vehicle vehicle = new Vehicle("Bike" + i);
//			Vehicle vehicle2 = new Vehicle("Car" + i);
//			person.getVehicle().add(vehicle);
//			person.getVehicle().add(vehicle2);
//
//			dao.createPerson(person);
//			System.out.println("person::" + person);
//
//		}
//
//		dao.getPerson();

		for (int i = 1; i < 5; i++) {
			Person person = new Person("A" + i, 20 + i);
			Person person1 = new Person("AA" + i, 40 + i);
			Vehicle vehicle = new Vehicle("Bike" + i);
			if (vehicle.getPerson() == null) {
				vehicle.setPerson(new ArrayList<Person>());
			}

			vehicle.getPerson().add(person);
			vehicle.getPerson().add(person1);

			dao.createVehicle(vehicle);
			System.out.println("person::" + person);

		}
		
		dao.getVehicle();
		

	}

	private static void createVehicle(Person person) {
		// TODO Auto-generated method stub
		
	}

}
