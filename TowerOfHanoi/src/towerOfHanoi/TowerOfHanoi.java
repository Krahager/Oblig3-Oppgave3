package towerOfHanoi;

import java.util.Scanner;

public class TowerOfHanoi {
	private static int moveCount;
	/**Hovedmetode */
	public static void main(String[] args){
		//Lager en Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Skriv inn antall disker: ");
		int n = input.nextInt();
		input.close();
		
		//Find the solution recursively
		System.out.println("The moves are:");
		moveDisks(n, 'A', 'B', 'C');
		System.out.println("\nFerdig flyttet! Antall forflytninger: " + moveCount);
	}

	/**Metoden for å finne løsningen for å flytte n disker fra fromTower til toTower med auxTower
	 * som hjelpetårn*/
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower){
		if (n==1){ //Stoppkrav
			moveCount++;
			System.out.println("Flytter disk " + n + " fra " + fromTower + " til " + toTower);
		}
		else{
			moveDisks(n - 1, fromTower, auxTower, toTower);
			System.out.println("Flytter disk " + n + " fra " + fromTower + " til " + toTower);
			moveCount++;
			moveDisks(n - 1, auxTower, toTower, fromTower);
		}
	}
}

	
