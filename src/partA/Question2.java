package partA;


public class Question2 {

	
	//method used to create Dice
    public static int[] rollDice() {
    	
        return new int[] {1, 2, 3, 4, 5, 6};
    }
    
    //Q2. Calculate and display the distribution of all possible combinations that can be obtained when rolling both Die A and Die B together.
	
	public static void possibleCombo(int[] dieA, int[] dieB) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < dieA.length ; i++) {
			
			for(int j = 0 ; j < dieB.length ; j++) {
				
				System.out.print("(" + dieA[i] + "," + dieB[j]+"), ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dieA = rollDice();
		int[] dieB = rollDice();
		possibleCombo(dieA, dieB);
	}

}
