package TravelAgency;

public class Basket {
	//the fields of the class
	private Reservation[] ArrResv;

	//Constructors of the class
	public Basket() {
		this.ArrResv = new Reservation[0];
	}
	public Reservation[] getProducts() {
		Reservation[] temp = this.ArrResv.clone();
		return temp;
	}
	public int add(Reservation toAddResv) {
		//create a temporary object to copy the Original array items and add the new reservation
		Reservation[] tempArr = new Reservation[ArrResv.length + 1];
		//loop through the items in the array and add the new Reservation
		for (int i=0; i<ArrResv.length; i++)
		{
			tempArr[i] =this.ArrResv[i];
		}
		//add the new Reservation to the last index of the Reservation Array
		tempArr[ArrResv.length] = toAddResv;
		this.ArrResv = new Reservation[tempArr.length];
		this.ArrResv = tempArr;
		return this.ArrResv.length;

	}
	public boolean remove(Reservation reserve) {
		int index = 0;
		Reservation[] tempArr = new Reservation[ArrResv.length - 1];
		for(int i = 0; i < ArrResv.length; i++) {
			if (reserve.equals((ArrResv[i]))) {
				index = i;
			}
		}
		if(index == 0) {
			//System.out.println("index here ==> " + index);
			return false;
		}else {
			//System.out.println("index there ==> " + index);
			int j = 0;
			for(int i = 0; i < ArrResv.length; i++) {
				if (index != i) {
					tempArr[j++] = ArrResv[i];
				}
			}
			this.ArrResv = new Reservation[tempArr.length];
			this.ArrResv = tempArr;
			return true;
		}
	}
	public void clear() { //clear the basket
		ArrResv=new Reservation[0];
	}
	public int getNumOfReservations() {
		return this.ArrResv.length;
	}
	//a method to return the total cost of the reservations
	public int getTotalCost() {
		int totalReservations = 0;
		for (int i=0; i<ArrResv.length; i++) {
			totalReservations += ArrResv[i].getCost();
		}

		return totalReservations;


	}
}
