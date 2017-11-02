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
import javax.persistence.Table;

@Entity
@Table(name="Vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int vehicleId;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_vehicle", joinColumns={@JoinColumn(name="vehicleId", referencedColumnName="vehicleId")}
	, inverseJoinColumns={@JoinColumn(name="personId", referencedColumnName="personId")} )
	Collection<Person> person;
	
	String vehicleName;

	public Vehicle(){
		System.out.println("In Veh constru");
	}
	public Vehicle(String vehicleName) {
		super();
		this.vehicleName = vehicleName;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Collection<Person> getPerson() {
		return person;
	}
	public void setPerson(Collection<Person> person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", person=" + ", vehicleName=" + vehicleName + "]";
	}
	
	
	
	

}
