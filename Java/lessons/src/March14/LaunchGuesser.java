package March14;

import java.util.Scanner;

public class LaunchGuesser {
	public static void main(String[] args) {
		new Umpire();
	}
}

class Guesser {
	int gNum;
	
	public int guessNum() {
		System.out.println("Guesser, guess a number(0-50):");
		Scanner scan = new Scanner(System.in);
		gNum = scan.nextInt();
		scan.close();
		return gNum;
	}
}

class Player {
	int pNum;
	
	public int guessNum() {
		System.out.println("Player, guess a number(0-50):");
		Scanner scan = new Scanner(System.in);
		pNum = scan.nextInt();
		scan.close();
		return pNum;
	}
}

class Umpire {
	int numberFromGuesser;
	int numberFromPlayer1;
	int numberFromPlayer2;
	int numberFromPlayer3;
	
	public Umpire() {
		this.collectNumFromGuesser();
		this.collectNumFromPlayer();
		this.compare();
	}
	
	public void collectNumFromGuesser() {
		Guesser g = new Guesser();
		numberFromGuesser = g.guessNum();
	}
	
	public void collectNumFromPlayer() {
		Player p1 = new Player();
		numberFromPlayer1 = p1.guessNum();
		
		Player p2 = new Player();
		numberFromPlayer2 = p2.guessNum();
		
		Player p3 = new Player();
		numberFromPlayer3 = p3.guessNum();
	}
	
	public void compare() {
		if(numberFromGuesser == numberFromPlayer1 && numberFromGuesser == numberFromPlayer2 || numberFromGuesser == numberFromPlayer3) {
			System.out.println("All players win");
		}
		else if(numberFromGuesser == numberFromPlayer1 || numberFromGuesser == numberFromPlayer2) {
			System.out.println("Player 1 and 2 wins");
		}
		else if(numberFromGuesser == numberFromPlayer2 || numberFromGuesser == numberFromPlayer3) {
			System.out.println("Player 2 and 3 wins");
		}
		else if(numberFromGuesser == numberFromPlayer3 || numberFromGuesser == numberFromPlayer1) {
			System.out.println("Player 3 and 1 wins");
		}
		else if(numberFromGuesser == numberFromPlayer1) {
			System.out.println("Player 1 wins");
		}
		else if(numberFromGuesser == numberFromPlayer2) {
			System.out.println("Player 2 wins");
		}
		else if(numberFromGuesser == numberFromPlayer3) {
			System.out.println("Player 3 wins");
		}
		else {
			System.out.println("Game over, try again");
		}
	}
}