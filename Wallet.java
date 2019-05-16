package casino;

public class Wallet {
	
	int wallet = 0; 
	int savings = 0; // ile udalo sie uzbierac w ciagu gry
	
	public void wallet() {
		wallet = 0;
		savings = 0;
	}
	
	public void savings(Wallet w) {
		if (w.wallet > 101) {
			w.wallet--;
			w.savings++;
		}
		
	}

}
