/* TO DO LIST:

add max bet methood
 
*/

package casino;

import java.util.Random;

public class Casino {

	public static void main(String[] args) {
		
		//System.out.println("Hej");
		/*
		Numbers[] table = new Numbers[33];
		table[0] = Numbers.green;
		*/
		
		
		
	Random rand = new Random();
	int ball = 37; //rand.nextInt(37);
	
	Wallet w = new Wallet(); 
	w.wallet = 100; // how big wallet is
	System.out.println("In wallet there is: " + w.wallet);
	
	int rounds = 1000; // ilosc rzutow kulka
	System.out.println("Number of games: " + rounds);
	
	int maxbet = 50;
	System.out.println("Maximum bet is: " + maxbet);
	
	Numbers number[] = new Numbers[rounds]; // tabele with throws (given numbers)
	
	for(int i = 0; i < rounds; i++) { // filling table with throws
		ball = rand.nextInt(37);
		/*
		System.out.print(ball);
		//System.out.print(number[ball]);
		System.out.print(" ");
		*/
		number[i] = new Numbers(ball);
		
		//System.out.println(number[1].ball);
		//System.out.print(" ");
		
		//boolean ninrow() = false;
		
	}
	//System.out.println(ball);
	
	//MAIN VARIABLE:
	int bet = 1; // how big bet is
	boolean condition = true; // condition to bet
	int round = 0; //whitch throw of a ball we currently have
	boolean win = true;
	boolean ifbet = false; // true = bet has been made
	
	// loop where throws are made
	while (condition == true) {
		
		if(w.wallet <= bet) {
			System.out.println("infuence funds, on throw: " + round);
			System.out.println("savings = " + w.savings + " + " + w.wallet);
			break; // jesli portfel pusty, to przerwij
		}
			
		//System.out.print(number[round].red + " if red " + round + " round " + ifbet + " ifbet? ");
		//System.out.println(win + " win?");
		//System.out.println("nbet in a row"); // test, if number of same color appear in a row			
		
		if(ifbet == false) { //check bet condition only if there is no active bet
			ifbet = ninrow(number, round, 5); // check if bet will be made (4 in row have been black)
			if (ifbet == true) System.out.println("I took money from wallet, because of the conditon * ifbet * ");
		}
		
		
		if(ifbet == true) {
			
			w.wallet = takefromwallet(w, bet); //takes money from wallet
			
			win = checkforwin(number, rounds, round); // checks if bet is red (red = winning bet)
			
			if(win == false) {
				bet = bet+bet;
				if (bet >= maxbet) { // if bet would be greater than maximum allow
					win = true;
					bet = 1;
					ifbet = false;
					System.out.println("Max bet achived");
				}
				System.out.println("if win = false " + w.wallet + " wallet?, round: " + round);
			}
			
			if(win == true) { //determines the size of the bet
				w.wallet = w.wallet + (2*bet);
				bet = 1;
				ifbet = false;
				System.out.println("if win = true " + w.wallet + " wallet?, round: " + round);
			}
		}
		
		
		
		
		/*
		//check what number and if red
		System.out.print(number[round].ball);
		System.out.print(number[round].red + " " );
		*/
		
		//if(win == true) System.out.println(win);
		
		
		//System.out.println(w.wallet + " wallet");
		/*
		System.out.print(win);
		System.out.print(" ");
		System.out.print(bet);
		System.out.print(" ");
		System.out.print(w.wallet);
		System.out.println(" ");
		*/
		// savings:
		//w.savings(w); // takes money from wallet and saves it in save place
		/*
		if(wallet > 110) {
			wallet--;
			savings++;
		}
		*/
		//System.out.println("bet: " + bet +" is bet won?: " + win + " wallet: " + w.wallet );
		round++;
		if(round >= rounds) {
			System.out.println("end of throws, wallet = " + w.savings + " + " + w.wallet);
			break; //sprawdza czy to juz koniec rzutow
		}
	} // end of throws loop
	
	} // end of Main
	
	
	static int takefromwallet(Wallet w, int bet) {
		w.wallet = w.wallet - bet;
		return w.wallet;
	}
	
	static boolean checkforwin(Numbers[] number, int rounds, int round) {
		if(number[round].red == true) {
			return true;
		} else return false;
	}
	
	static int winbet() {
		int winbet = 1;
		
		
		
		return winbet;
	}
	
	static void savings(int wallet, int savings) {
		
		if(wallet > 1010) {
			wallet--;
			savings++;
		}
		
	}
	
	static boolean ninrow(Numbers[] number, int round, int nbet ) {
		boolean condition = false;
		// "nbet" = how many this same throws in a row
		//if (nbet >= round) condition = true; //number of throws must be bigger than number of numbers of require bets
		if (round >= nbet) {
			condition = true;
			for(int i = 1; i < nbet; i++) {
				if(number[round - i].black == false) { // if nbet in a row are black -> break
					condition = false;
					break;
				}
			}
		
		}
		//System.out.println(number[round].red + " " + round + " " + nbet + " " + condition);
		return condition;
		
	}
	
}
