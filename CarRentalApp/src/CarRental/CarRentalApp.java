package CarRental;

public class CarRentalApp {

	public static int index=1000;
	
	public static void main(String[] args) {
		
		String ID1="C" + String.valueOf(index);
		Car car1=new Car(ID1,"Audi","Q7",1000.00);
		index++;
		
		String ID2="C" + String.valueOf(index);
		Car car2=new Car(ID2,"BMW","Q1",1500.50);
		index++;
		
		CarRentalSystem crs=new CarRentalSystem();
		crs.addCar(car1);
		crs.addCar(car2);
		crs.menu();
		
	}

}
