package partA;

public class Question1 {
	
	public static int totalComb(int[] dieA, int[] dieB) {
		return (dieA.length * dieB.length);
	}	
	
	//method used to create Dice
    public static int[] rollDice() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dieA = rollDice();
		int[] dieB = rollDice();
		System.out.println("Total combinations: "+totalComb(dieA , dieB));
	}

}
