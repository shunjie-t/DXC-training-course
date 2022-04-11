package march17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	public static String[][] grid = makeGrid();
	public static HashMap<Integer,String> slotsTaken = new HashMap<Integer,String>();

	public static void main(String[] args) {
		startGame();
	}
	
	private static String[][] makeGrid() {
		String[][] grid = new String[11][11];

		for(int a = 0; a < grid.length; a++) {
			for(int b = 0; b < grid[a].length; b++) {
				if((a + 1) % 4 == 0 || (b + 1) % 4 == 0) {
					grid[a][b] = ("#");
				}
				else {
					grid[a][b] = " ";
				}
			}
		}
		
		return grid;
	}
	
	public static void startGame() {
		Scanner scan = new Scanner(System.in);
		String input;
		int key = 0;
		boolean gameOngoing = true;
		boolean gameWon = false;
		char invalidInput;

		System.out.println("Enter Q to quit game.");
		displayGrid("player", gameOngoing);
		
		while(gameOngoing) {
			input = scan.nextLine();
			if(input.matches("[q]")) input = input.toUpperCase();
			
			if(input.matches("[1-9]")) key = Integer.parseInt(input);
			else key = 0;
			
			if(!slotsTaken.containsKey(key)) {
				invalidInput = inputMove(input, "X", "player");
				if(invalidInput == 'T') {
					gameOngoing = true;
				}
				else if(invalidInput == 'F') {
					gameOngoing = false;
				}
				
				gameWon = gameOutcome("player");
				
				if(gameOngoing && !gameWon && invalidInput != 'I' && input.matches("\\d")) {
					displayGrid("computer", gameOngoing);
					computerPlay();
					gameWon = gameOutcome("computer");

					/*if(input.matches("\\d")) {
						computerPlay();
						gameWon = gameOutcome("computer");
					}*/
				}
				
				if(gameWon) {
					grid = makeGrid();
					slotsTaken.clear();
					
					System.out.println("Enter any key to play again.");
					System.out.println("Or 'Q' to quit.");
					input = scan.nextLine().toUpperCase();
					
					if(input.charAt(0) == 'Q') {
						gameOngoing = false;
						System.out.println("Quited game.");
					}
					else {
						gameOngoing = true;
						displayGrid("player", gameOngoing);
					}
				}
				else if(invalidInput != 'I' && gameOngoing) {
					displayGrid("player", gameOngoing);
				}
			}
			else {
				System.out.print("position already filled, select other positions: ");
			}			
		}
		
		scan.close();
	}
	
	public static void displayGrid(String player,boolean gameOngoing) {
		int ct = 1;
		
		if(gameOngoing) {
			System.out.println(player + "'s turn");
		}
		System.out.println("____________________________________________________");
		System.out.println("available grid             current grid");
		
		for(int a = 0; a < grid.length; a++) {
			for(int b = 0; b < grid[a].length; b++) {
				if(a % 2 == 0 || b % 2 == 0) {
					System.out.print(grid[a][b]);
				}
				else {
					if(a == 3 || a == 7 || b == 3 || b == 7) {
						System.out.print(grid[a][b]);
					}
					else {
						System.out.print(ct);
						++ct;
					}
				}
			}
			
			System.out.print("                ");
			
			for(int b = 0; b < grid[a].length; b++) {
				System.out.print(grid[a][b]);
			}
			
			System.out.println("");
		}
		
		if(gameOngoing && !player.equals("computer")) {
			System.out.print("Enter number 1-9 to choose your position: ");
		}
	}
	
	private static char inputMove(String pos, String symbol, String turn) {
		switch(pos) {
		case "1":
			grid[1][1] = symbol;
			slotsTaken.put(1, symbol);
			break;
		case "2":
			grid[1][5] = symbol;
			slotsTaken.put(2, symbol);
			break;
		case "3":
			grid[1][9] = symbol;
			slotsTaken.put(3, symbol);
			break;
		case "4":
			grid[5][1] = symbol;
			slotsTaken.put(4, symbol);
			break;
		case "5":
			grid[5][5] = symbol;
			slotsTaken.put(5, symbol);
			break;
		case "6":
			grid[5][9] = symbol;
			slotsTaken.put(6, symbol);
			break;
		case "7":
			grid[9][1] = symbol;
			slotsTaken.put(7, symbol);
			break;
		case "8":
			grid[9][5] = symbol;
			slotsTaken.put(8, symbol);
			break;
		case "9":
			grid[9][9] = symbol;
			slotsTaken.put(9, symbol);
			break;
		/*case "S":
			symbol = (symbol == 'X') ? 'O' : 'X';
			System.out.println(symbol);
			break;*/
		case "Q":
			System.out.println("Quitted game.");
			return 'F';
		default:
			// prevent displayGrid from being called
			System.out.println("Invalid input, enter again");
			return 'I';
		}
		
		return 'T';
	}
	
	private static boolean gameOutcome(String turn) {
		ArrayList<List<Integer>> combinations = new ArrayList<List<Integer>>();
		combinations.add(Arrays.asList(1,2,3));
		combinations.add(Arrays.asList(4,5,6));
		combinations.add(Arrays.asList(7,8,9));
		combinations.add(Arrays.asList(1,4,7));
		combinations.add(Arrays.asList(2,5,8));
		combinations.add(Arrays.asList(3,6,9));
		combinations.add(Arrays.asList(1,5,9));
		combinations.add(Arrays.asList(3,5,7));
		
		for(List<Integer> a : combinations) {
			if(slotsTaken.keySet().containsAll(a)) {
				if( slotsTaken.get(a.get(0)) == slotsTaken.get(a.get(1)) && 
				slotsTaken.get(a.get(1)) == slotsTaken.get(a.get(2)) ) {
					displayGrid("player",false);
					System.out.println(turn+" wins");
					System.out.printf("Winning combination: %d %d %d%n", a.get(0), a.get(1) ,a.get(2));
					return true;
				}
			}
		}
		
		if(slotsTaken.size() == 9) {
			displayGrid("", false);
			System.out.println("Tie");
			return true;
		}
		
		return false;
	}
	
	private static void computerPlay() {
		Random rand = new Random();
		int move = rand.nextInt(9) + 1;
		while(slotsTaken.containsKey(move)) {
			move = rand.nextInt(9) + 1;
		}
		inputMove(Integer.toString(move), "O", "computer");
	}
}
