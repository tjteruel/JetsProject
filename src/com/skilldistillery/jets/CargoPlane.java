package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	
	public void loadPlane() {
		System.out.println("Loading cargo into " + super.getModel());
	}


	@Override
	public double getSpeedInMach() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
