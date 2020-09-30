package TravelAgency;

public class Airport {
	//fields(Attributes)
	private int xCord; //scale 1km
	private int yCord; //scale 1km
	private int fees; // in cents
	//Constructors
	public Airport(int xCord, int yCord, int fees) {
		this.xCord= xCord;
		this.yCord= yCord;
		this.fees= fees;
	}
	//get methods
	public int getFees() {
		return this.fees;
		
	}
	public static int getDistance(Airport firstAirport, Airport secondAirport) { // distance between two airports
		int x1=firstAirport.xCord;
		int x2=secondAirport.xCord;
		int y1=firstAirport.yCord;
		int y2=secondAirport.yCord;
		int distanceBetween =(int) Math.ceil(Math.sqrt((Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2))));
		return distanceBetween;
		
	}
	
}
