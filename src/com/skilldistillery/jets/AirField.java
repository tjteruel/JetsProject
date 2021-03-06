package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AirField {
	
	// F I E L D S
	private List<Jet> jets = new ArrayList<>();
	Scanner kb = new Scanner(System.in);

	// M E T H O D S 
	public AirField() {
		readAndPopulateFromFile();
	}

	
	//READS TEXT FILE AND ADS JETS TO LIST
	public List<Jet> readAndPopulateFromFile() {
		try {
			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(", ");
				String type = fields[0].trim();
				String model = fields[1].trim();
				double speed = Double.parseDouble(fields[2].trim());
				int range = Integer.parseInt(fields[3].trim());
				long price = Long.parseLong(fields[4].trim());
				if (type.contentEquals("FighterJet")) {
					jets.add(new FighterJet(model, speed, range, price));
				} else if (type.contentEquals("CargoPlane")) {
					jets.add(new CargoPlane(model, speed, range, price));
				} else if (type.contentEquals("JetImpl")) {
					jets.add(new JetImpl(model, speed, range, price));
				} else {
					System.out.println("UNKNOWN TYPE/DATA ERROR");
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading " + "jets.txt" + ": " + e.getMessage());
		}
		return jets;
	}

	// PRINTS ALL JETS
	public void displayJets() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}

	// FLIES ALL JETS
	public void flyJets() {
		for (Jet jetfly : jets) {
			jetfly.fly();
		}
	}

	// PRINTS FASTEST JET
	public String getFastest() {
		String fastest = null;
		double currentSpeed = Integer.MIN_VALUE;
		for (Jet jetspeed : jets) {
			if (jetspeed == null) {
				break;
			}
			if (jetspeed != null) {
				if (jetspeed.getSpeed() > currentSpeed) {
					currentSpeed = jetspeed.getSpeed();
					fastest = "The fastest jet is the " + jetspeed.getModel() + " with a speed of " + jetspeed.getSpeed() + " MPH. ";
				}
			}
		}
		return fastest;
	}

	// PRINTS LONGEST RANGE
	public String getLongestRange() {
		String longestRange = null;
		int currentRange = Integer.MIN_VALUE;
		for (Jet jetsrange : jets) {
			if (jetsrange == null) {
				break;
			}
			if (jetsrange != null) {
				if (jetsrange.getSpeed() > currentRange) {
					currentRange = jetsrange.getRange();
					longestRange = "The jet with the longest range is the " + jetsrange.getModel() + " with a range of " + jetsrange.getRange() + " miles. ";
				}
			}
		}
		return longestRange;
	}

	// LOADS CARGO PLANES
	public void loadCargo() {
		for (Jet jetscargo : jets) {
			if (jetscargo instanceof CargoPlane) {
				((CargoPlane) jetscargo).loadPlane();
			}
		}
	}

	// INITIATES DOGFIGHT
	public void dogFight() {
		for (Jet jetsfighter : jets) {
			if (jetsfighter instanceof FighterJet) {
				((FighterJet) jetsfighter).fightJets();
			}
		}
	}

	// USER ADDS JETS
	public void addJet() {
		System.out.println("What type jet would you like to add? ");
		System.out.println("1. Fighter Jet \n2. Cargo Plane \n3. Passenger Plane");
		int userChoice = kb.nextInt();
		System.out.print("What is the model? ");
		String userModel = kb.next();
		System.out.print("What is the speed (MPH)? ");
		double userSpeed = kb.nextDouble();
		System.out.print("What is the range? ");
		int userRange = kb.nextInt();
		System.out.print("What is the price? ");
		long userPrice = kb.nextLong();

		Jet it = null;
		for (Iterator<Jet> iterator = jets.iterator(); iterator.hasNext();) {
			it = iterator.next();

			switch (userChoice) {
			case 1:
				it = new FighterJet(userModel, userSpeed, userRange, userPrice);
				break;
			case 2:
				it = new CargoPlane(userModel, userSpeed, userRange, userPrice);
				break;
			case 3:
				it = new FighterJet(userModel, userSpeed, userRange, userPrice);
				break;
			default:
				System.out.print("Please enter a valid option");
				userChoice = kb.nextInt();
			}
		}
		if (it != null) {
			jets.add(it);
		}
	}

	// USER REMOVES JETS
	public void removeJet() {
		System.out.println("Which jet would you like to remove from the fleet? ");
		System.out.println("Please select a number: ");
		for (int i = 0; i < jets.size(); i++) {
			System.out.println((i + 1) + ". " + jets.get(i));
		}
			int userChoice = kb.nextInt();
			if (userChoice <= jets.size()) {
			jets.remove(userChoice - 1);
			System.out.println("Jet number " + userChoice + " was removed");
			} else {
				System.out.println("Please enter a valid option. ");
			}
		}
	}
