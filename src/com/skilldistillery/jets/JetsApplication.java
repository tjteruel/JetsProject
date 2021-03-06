package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	// F I E L D S 
	private AirField airField = new AirField();
	private Scanner kb = new Scanner(System.in);
	
	//M E T H O D S 
	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		
		jetsApp.menu();
		
	}// END MAIN
	
	//PRINT MENU
	public void menu() {
		System.out.println("\t\tWelcome to the Jets Application!\n");
		System.out.println("\tPlease select an option (1 - 9):");
		boolean menuLoop = true;
		while(menuLoop) {
			System.out.println("+-------------------------------------------+");
			System.out.println("|             *Jets Main Menu*              |");
			System.out.println("|   1. List fleet                           |");
			System.out.println("|   2. Fly all jets                         |");
			System.out.println("|   3. View fastest jet                     |");
			System.out.println("|   4. View jet with longest range          |");
			System.out.println("|   5. Load all Cargo Jets                  |");
			System.out.println("|   6. Dogfight!                            |");
			System.out.println("|   7. Add a jet to Fleet                   |");
			System.out.println("|   8. Remove a jet from Fleet              |");
			System.out.println("|   9. Quit                                 |");
			System.out.println("+-------------------------------------------+");
			int userChoice = kb.nextInt();
			
			switch(userChoice) {
			case 1:
				airField.displayJets();
				break;
			case 2:
				airField.flyJets();				
				break;
			case 3:
				System.out.println(airField.getFastest());
				break;
			case 4:
				System.out.println(airField.getLongestRange());
				break;
			case 5:
				airField.loadCargo();
				break;
			case 6:
				airField.dogFight();
				break;
			case 7:
				airField.addJet();
				break;
			case 8: 
				airField.removeJet();
				break;
			case 9:
				System.out.println("\t Thanks for using the Jets Application!");
				menuLoop = false;
				break;
			default:
				System.out.print("Please enter a valid option of 1 through 9.");
				userChoice = kb.nextInt();
				
			}
				
		}
	}

}
