package TravelAgency;

public class HotelReservation extends Reservation {
	private Hotel hotelName;
	private String roomType;
	private int numOfNights;
	private int price; // price of the hotel in cents

	public HotelReservation(String name, Hotel hotelName, String roomType, int numOfNights) {
		super(name);
		this.price = hotelName.reserveRoom(roomType);
		this.numOfNights = numOfNights;
		this.hotelName = hotelName;
		this.roomType = roomType;

	}

	public int getNumOfNights() {
		return this.numOfNights;
	}

	public int getCost() {
		return this.price * this.numOfNights;
	}

	public boolean equals(Object ob1) {
		if (ob1 instanceof HotelReservation) {
			HotelReservation resv =(HotelReservation) ob1;
			if (resv.hotelName.equals(this.hotelName) && resv.roomType.equals(this.roomType)){
				if (resv.price==this.price && resv.numOfNights==this.numOfNights) {
					return true;
				}
			}

		}
		return false;
	}
}
