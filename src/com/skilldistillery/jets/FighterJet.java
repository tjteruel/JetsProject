package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void fightJets() {
		System.out.println(super.getModel() + " is in a dog fight!");
	}

}
