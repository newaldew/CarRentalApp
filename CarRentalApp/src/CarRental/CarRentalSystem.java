package CarRental;

import java.util.*;

public class CarRentalSystem {
	private List<Car>cars;
	private List<Customer>customers;
	private List<Rental>rental;
	
	public CarRentalSystem() {
		cars=new ArrayList<>();
		customers=new ArrayList<>();
		rental=new ArrayList<>();
	}

	public void addCar(Car c) {
		cars.add(c);
	}
	public void addCustomer(Customer cst) {
		customers.add(cst);
	}
	
	public void rentCar(Car c, Customer cust, int days) {
		if(c.isCarAvailable()) {
			c.rent();
			rental.add(new Rental(c,cust,days));
		}
		else {
			System.out.println("Car is not avaiable for rental");
		}
	}
	
	public void returnCar(Car c) {
		c.returnCar();
		
		Rental rentalToRemove=null;
		
		for(Rental it:rental) {
			if(it.getCar()==c) {
				rentalToRemove=it;
				break;
			}
		}
		if(rentalToRemove!=null) {
			rental.remove(rentalToRemove);
		}
		else {
			System.out.println("Car was not rented");
		}
	}
	public void menu() {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("====Car Rental System====");
			System.out.println("1. Car Rental");
			System.out.println("2. Car Return");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			
			int choice=0;
			do{
				try{
					choice=sc.nextInt();
					//sc.nextLine();
					break;
				}
				catch(Exception e){
					System.out.println("Please enter a valid number");
					sc.next();
				}
				
			}while(true);
			
			if(choice==1) {
				System.out.println("----Car Rental----");
				System.out.print("Enter your name: ");
				
				String custName=sc.nextLine();
				
				System.out.println("Available Cars: ");
				for(Car car:cars) {
					if(car.isCarAvailable()) {
						System.out.println("Car ID: " + car.getCarID() + " - Brand: " + car.getCarBrand() + " - Model: " + car.getCarModel());
					}
				}
				
				System.out.print("Enter the car ID you want to rent:  ");
				String carID=sc.nextLine();
				
				System.out.print("Enter the number of days you want to rent the car: ");
				int days=sc.nextInt();
				sc.nextLine();
				
				Customer newCust=new Customer("CUS" + (customers.size()+1),custName);
				addCustomer(newCust);
				
				Car selectedCar=null;
				for(Car c:cars) {
					if(c.getCarID().equals(carID) && c.isCarAvailable()) {
						selectedCar=c;
						break;
					}
				}
				if(selectedCar!=null) {
					double totalPrice=selectedCar.CalculatePrice(days);
					System.out.println("----Rental Car Details----");
					System.out.println("Name: " + custName + " - Customer ID: " + 
							newCust.getCustID() + " - Selected Car: " + selectedCar.getCarModel() + 
							" - Rental days: " + days + " - Total Rental Price: " + totalPrice);
					System.out.print("Confirm your rental(Y/N): ");
					String confirm=sc.nextLine();
					
					if(confirm.equalsIgnoreCase("Y")) {
						rentCar(selectedCar,newCust,days);
						System.out.println("Car Rented successfully!");
						//break;
					}
					else {
						System.out.println("Rental cancelled");
					}
				}
				else {
					System.out.println("Invalid car selection or car not selected");
				}
				
			}
			else if(choice==2) {
				System.out.println("----Return Car----");
				System.out.print("Please enter the CarID: ");
				String carID=sc.nextLine();
				
				Car carToReturn=null;
		
				for(Car c:cars){
					if(c.getCarID().equals(carID) && !c.isCarAvailable()) {
						carToReturn=c;
						break;
					}
				}
				
				if(carToReturn!=null) {
					Customer cust=null;
					for(Rental r:rental) {
						if(r.getCar().equals(carToReturn)) {
							cust=r.getCust();
							break;
						}
					}
					
					if(cust!=null) {
						returnCar(carToReturn);
						System.out.println("Car returned successfully by " + cust.getname());
					}
					else {
						System.out.println("Car is not rented or information is incorrect");
					}
				}
				else {
					System.out.println("Invalid carID or can is not rented");
				}
			}
			else if(choice==3){
				System.out.println("Exit!");
				break;
			}
			else {
				System.out.println("Please enter a valid number");
			}
		}
		System.out.println("Thank you for using Car Rental System!");
	}
}