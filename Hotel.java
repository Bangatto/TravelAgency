package TravelAgency;

public class Hotel {
	//attributes of class Hotel
	private String hotelName;
	private Room[] hotelRoom;

	//Constructors of the hotel
	public Hotel(String hotelName, Room[] hotelRoom) {
		this.hotelName=hotelName;
		//making a deep copy of the hotel room array
		Room [] copy = new Room[hotelRoom.length];
		for(int i = 0; i < hotelRoom.length; i++) {
			copy[i] = new Room(hotelRoom[i]);
		}
		this.hotelRoom=copy;
	}
	//Methods of the Hotel class
	public int reserveRoom(String  roomType) {
		Room room = Room.findAvailableRoom(this.hotelRoom, roomType);
		if(room == null) {
			throw new IllegalArgumentException("No room available");
		}else {
			room.changeAvailability();
			return room.getPrice();
		}

	}
	public boolean cancelRoom(String  roomType) {
		return Room.makeRoomAvailable(this.hotelRoom, roomType);
	}
}
