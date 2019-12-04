import java.util.Scanner;
import java.util.Random;

public class PlayerMoney {
	public static void main(String[] args) {
		int value = -1; // how much money the player gets when they harvest the plant
		int cost = 0;	
		
		Scanner seedChoice = new Scanner (System.in);
		System.out.println("What would you like to buy today:");
		int sC = seedChoice.nextInt();
		
		
		Scanner fertilizerChoice = new Scanner (System.in);
		System.out.println("Would you like to use fertilizer:");
		int fC = fertilizerChoice.nextInt();
		
		
		
		Random r = new Random();
		String name = null; //name of the plant
		int waterPerTurn = -1; // the number of times a plant must be watered each turn for the turn to be successful
		int sucessfulTurns = 0; // the number of successful turns the plant has had so far
		int turnsToGrow = -1; // the number of successful turns a plant takes to become harvestable

		
		if (sC == 0) {
			name = "Rose"; //setting name of type of plant
			turnsToGrow = r.nextInt(2) + 3; // creates a random number of turns needed before harvest this particular range is 3-5
			waterPerTurn = 1;
			value = r.nextInt(5) + 7; // setting random sell value for the plant this particular range is $7-$12
			cost = 1;
		}
		else if(sC == 1) {
			name = "Lavender";
			turnsToGrow = r.nextInt(3) + 5;
			waterPerTurn = 1;
			value = r.nextInt(8) + 6;
			cost = 3;
		}
		else if(sC == 2) {
			name = "Cactus";
			turnsToGrow = r.nextInt(5) + 9;
			waterPerTurn = 1;
			value = r.nextInt(10) + 10;
			cost = 5;
		}
		else if(sC == 3) {
			name = "Meow-er";
			turnsToGrow = r.nextInt(10) + 8;
			waterPerTurn = 1;
			value = r.nextInt(15) + 12;
			cost = 10;
		}
		else if (sC == 4) {
			name = "Strawberry"; //setting name of type of plant
			turnsToGrow = r.nextInt(2) + 1; // creates a random number of turns needed before harvest this particular range is 1-3
			waterPerTurn = 1;
			value = r.nextInt(5) + 5; // setting random sell value for the plant this particular range is $5-$10
			cost = 2;
		}
		
		else if (sC == 5) {
			name = "Grapes"; //setting name of type of plant
			turnsToGrow = r.nextInt(2) + 2; // creates a random number of turns needed before harvest this particular range is 2-4
			waterPerTurn = 1;
			value = r.nextInt(5) + 6; // setting random sell value for the plant this particular range is $6-$11
			cost = 4;
	}
		
		else if (sC == 6) {
			name = "Broccoli"; //setting name of type of plant
			turnsToGrow = r.nextInt(2) + 3; // creates a random number of turns needed before harvest this particular range is 3-5
			waterPerTurn = 1;
			value = r.nextInt(5) + 8; // setting random sell value for the plant this particular range is $8- $13
			cost = 6;
	}
		
		else if (sC == 7) {
			name = "Pumpkin"; //setting name of type of plant
			turnsToGrow = r.nextInt(2) + 5; // creates a random number of turns needed before harvest this particular range is 5-7
			waterPerTurn = 1;
			value = r.nextInt(5) + 15; // setting random sell value for the plant this particular range is $15 - 20
			cost = 8;
	}
		
		playerMoney(turnsToGrow,fC,cost,value);
	} 
	

	
	public static int playerMoney(int turnsToGrow, int fC, int cost, int value) {
		
		
		Random r1 = new Random();
		int playerSpend = 0;
		int moneyInPoket = 10;
		int plantValue = 0;
		int startMoney = r1.nextInt(5) + 10;
		int fertilizerCost = -1;
		
		
		if (fC == 1) {
			fertilizerCost = 4;
			turnsToGrow = turnsToGrow - 1;
		}
		else if(fC == 0) fertilizerCost= 0;
		
		playerSpend = cost + fertilizerCost;
		if(playerSpend >= startMoney) {
			System.out.println("You can't afford fertilizer.");
			turnsToGrow = turnsToGrow + 1;
			playerSpend = cost;
		}
		plantValue = value;
		
		moneyInPoket = startMoney - playerSpend + plantValue;
		
		System.out.println("You have " + (startMoney - playerSpend) + " usd left.");
		System.out.println(turnsToGrow + " days passed. Your plant is harvestable. ");
		System.out.println(value);
		System.out.println("The total amount of money that you have right now is " + moneyInPoket + " usd.");
	
	
	
		return moneyInPoket;
	}

	}
