package TravelAgency;

public abstract class Reservation {
	//attributes
	private String name;
	
	//Constructors
	public Reservation(String name) {
		this.name = name;
	}
	public final String reservationName() {
		return this.name;
	}
	public abstract int getCost();
	public abstract boolean equals(Object reserve);
}
