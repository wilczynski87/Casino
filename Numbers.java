package casino;

public class Numbers {

	int ball = 0;
	boolean red = false;
	boolean black = false;
	boolean green= false;
	
	public Numbers(int number) {
		ball = number; 
		int cred[] = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
		int cblack[] = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
		
		if (number == 0) {
			green = true;
		} else { 
			for (int i = 0; i < 18; i++) {
				if(cred[i] == number) red = true;
				if(cblack[i] == number) black = true;
			}
			
		}
		

	}
}
