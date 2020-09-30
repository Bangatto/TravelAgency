package TravelAgency;

public class Customer {
	//fields of the class
	private String customerName;
	private int balance;
	private Basket customerResvs;
	
	//Constructors of the class
	public Customer(String customerName, int balance) {
		this.customerName=customerName;
		this.balance=balance;
		this.customerResvs= new Basket();
	}
	//get methods
	public String getName(){
		return this.customerName;
	}
	public int getBalance() {
		return this.balance;
	}
	public Basket getBasket() {
		 Basket a = this.customerResvs;
		return a;
	}
	public int addFunds(int balance) {
		if (balance < 0) {
			throw new IllegalArgumentException("insufficient Amount");
		}
		this.balance+=balance;
		return this.balance;
	}
	public int addToBasket(Reservation addResvs) {
		//check if the name on reservation matches customer name
		if (addResvs.reservationName().equals(this.getName())) {
			return this.customerResvs.add(addResvs);
		}
		throw new IllegalArgumentException("Customer names do not match");
			
		}
	public int addToBasket(Hotel hotelname, String roomtype,int numOfnights,boolean breakfast) {
		if (breakfast==true) {
			Reservation totalResvs= new BnBReservation(this.customerName,hotelname, roomtype,numOfnights);
			
			return this.customerResvs.add(totalResvs);
		}else {
			//the case of no breakfast is wanted by the customer
			Reservation newResvs= new HotelReservation(this.customerName,hotelname, roomtype,numOfnights);
		
			return this.customerResvs.add(newResvs);
		}
	}
	public int addToBasket(Airport firstAirport, Airport secondAirport) {
		Reservation airportAdded= new FlightReservation(customerName, firstAirport, secondAirport);
		return this.customerResvs.add(airportAdded);
	}
	public boolean removeFromBasket(Reservation removeItem) {
		return this.customerResvs.remove(removeItem);
	}
	public int checkOut() {
		//check if the customer balance is less than the price his reservations cost
		if (this.getBalance() < this.customerResvs.getTotalCost()) {
			throw new IllegalStateException("You do not have sufficient balance to cover your expenses");
		}else {
			//subtract his balance from the total cost of his reservations
			this.balance = this.balance-this.customerResvs.getTotalCost();
			this.customerResvs.clear();
			
			return this.getBalance(); // return his balance remaining after the deductions
			
		}
	}
}
