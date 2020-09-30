package TravelAgency;

public class BnBReservation extends HotelReservation {

	public BnBReservation(String name, Hotel reservedBooking, String roomType, int numOfNights) {
		super(name, reservedBooking, roomType, numOfNights);
		
	}
	public int getCost() {
		return (super.getCost() + (1000*super.getNumOfNights())); // convert $10 into cents 
		
	}

}
