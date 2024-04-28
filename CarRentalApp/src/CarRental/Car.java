package CarRental;

public class Car {
	private String CarID;
	private String CarBrand;
	private String CarModel;
	private double CarBasePrice;
	private boolean isAvailable;
	
	Car(String ID, String brand, String model,double basePrice){
		this.CarID=ID;
		this.CarBrand=brand;
		this.CarModel=model;
		this.CarBasePrice=basePrice;
		this.isAvailable=true;
	}
	public String getCarID() {
		return CarID;
	}
	public String getCarBrand() {
		return CarBrand;
	}
	public String getCarModel() {
		return CarModel;
	}
	public double CalculatePrice(int days) {
		return CarBasePrice*days;
	}
	public boolean isCarAvailable() {
		return isAvailable;
	}
	public void rent() {
		isAvailable=false;
	}
	public void returnCar() {
		isAvailable=true;
	}
}
