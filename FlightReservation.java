package TravelAgency;

public class FlightReservation extends Reservation {
	//Fields of the class FlightReservations
	private Airport departAirport;
	private Airport arrivAirport;
	
	public FlightReservation(String name, Airport departAirport, Airport arrivAirport) {
		super(name);
		//check if the two airports are equal
		if (departAirport == arrivAirport) {
			throw new IllegalArgumentException("Same Airport location");
		}else {
			this.departAirport = departAirport;
			this.arrivAirport = arrivAirport;
		}
	}
	
	@Override
	public int getCost() {
		final int costRelated = 5375; // multiplied $53.75 by 100 to convert it to cents
		final int costPerGallon = 124; // multiply by $1.24 by 100 to convert it into cents
		int distanceCovered = Airport.getDistance(departAirport, arrivAirport); // distance between the two airports
		double noOfGallons = (distanceCovered/167.52); // 167.52 is the distance per gallon
		double fuelCost = (costPerGallon * noOfGallons);
		int airportFees = (arrivAirport.getFees() + departAirport.getFees());//call get method from Room
		int totalCost= (int) Math.ceil(fuelCost + airportFees + costRelated); // total cost of the flight
		
		return totalCost;
	}
	public boolean equals(Object reserve) {
		if (reserve instanceof FlightReservation) { 
			FlightReservation resv = (FlightReservation) reserve;
			if ((resv.arrivAirport.equals(this.arrivAirport)) && (resv.departAirport.equals(this.departAirport)) && (resv.reservationName().equals(this.reservationName()))) {
				return true;
			}
			
		}
		return false;
	}
	
}


