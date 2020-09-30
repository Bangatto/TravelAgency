package TravelAgency;

public class Room {
	//fields
	private String roomType;
	private int roomPrice; // in cents
	private boolean availability;
	
	//Constructors
	public Room(String roomType) {
		if ("double".equalsIgnoreCase(roomType)) {
			this.roomPrice=(90*100); // multiple it by 100 to convert it to cents
		}else if ("queen".equalsIgnoreCase(roomType)) {
			this.roomPrice=(110*100);
		}else if ("king".equalsIgnoreCase(roomType)) {
			this.roomPrice=(150*100); // multiple it by 100 to convert it to cents
		}else {
			throw new IllegalArgumentException("No room of such type can be created");
		}
		this.roomType=roomType;
		this.availability=true; //availability for a new room
	}
	//copy of the room
	public Room(Room roomCopy) {
		this.roomType=roomCopy.roomType;
		this.roomPrice=roomCopy.roomPrice;
		this.availability=roomCopy.availability;
	}
		
	public String getType() {
		return this.roomType;
	}
	public int getPrice() {
		return this.roomPrice;
	}
	public void changeAvailability() {
		if(this.availability == true) {
			this.availability = false;
		}else { // opposite of the class currently here
			this.availability = true;
		}
	}
	public static Room findAvailableRoom(Room[] roomArr, String roomType) {
		for (int i=0; i<roomArr.length; i++) {
			if (roomType.equalsIgnoreCase(roomArr[i].roomType) && (roomArr[i].availability==true)) {
				return roomArr[i];
			} 
		}
		return null;
		}
	public static boolean makeRoomAvailable(Room[] roomArr, String roomType) {
		for (int i=0; i<roomArr.length; i++) {
			if (roomType.equalsIgnoreCase(roomArr[i].roomType) && (roomArr[i].availability==false)) {
				roomArr[i].changeAvailability(); //make room available.
				return true;
			}
		}
		return false;
	
		
	}

}
