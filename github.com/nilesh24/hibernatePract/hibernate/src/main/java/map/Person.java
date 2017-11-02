package map;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int personId;
	String name;
	int age;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_vehicle", joinColumns={@JoinColumn(name="personId", referencedColumnName="personId")}
	, inverseJoinColumns={@JoinColumn(name="vehicleId", referencedColumnName="vehicleId")} )
	Collection<Vehicle> vehicleList;
	
	public Person(){
		System.out.println("In default constru");
	}
	
	public Person(String name, int age) {
		super();
		
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return personId;
	}

	public void setId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Collection<Vehicle> getVehicle() {
		return vehicleList;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicleList = vehicle;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	

}
