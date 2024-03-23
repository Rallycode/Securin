package partA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question3 {
	
	public static int totalComb(int[] dieA, int[] dieB) {
		return (dieA.length * dieB.length);
	}	
	/*
	 datatypoe[] name = new datatype[size];
	 int[] a = new int[3];
	 int[] a = new int[]{10,15,16};
	 */
	//method used to create Dice
    public static int[] rollDice() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    //Map is a key value - pair 1st type is key and 2nd type is value
    //Q3.Calculate the Probability of all Possible Sums occurring among the number of combinations	   
	public static Map<Integer, List<int[]>> getPossibleSums(int[] dieA, int[] dieB) {
	       
		//key ~ possible sum value; value ~ the combinations of those valid sum
		Map<Integer, List<int[]>> possibleSums = new HashMap<>();
	
	       for (int faceA : dieA) {
	           for (int faceB : dieB) {
	               int totalSum = faceA + faceB;
	               int[] combination = new int[]{faceA, faceB};
	               if (!possibleSums.containsKey(totalSum)) {
	                   List<int[]> combinations = new ArrayList<>();
	                   combinations.add(combination);
	                   possibleSums.put(totalSum, combinations);
	               } else {
	                   possibleSums.get(totalSum).add(combination);
	               }
	           }
	       }
	
	       return possibleSums;
	   }

   public static Map<Integer, Double> calculateSumProbabilities(Map<Integer, List<int[]>> possibleSums, int totalCombinations) {
       Map<Integer, Double> sumProbabilities = new HashMap<>();
       for (Map.Entry<Integer, List<int[]>> entry : possibleSums.entrySet()) {
           int sum = entry.getKey();
           int occurrence = entry.getValue().size();
           double probability = (double) occurrence / totalCombinations;
           sumProbabilities.put(sum, probability);
       }
       return sumProbabilities;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] dieA = rollDice();
        int[] dieB = rollDice();
        
        Map<Integer, List<int[]>> possibleSumsOrg = getPossibleSums(dieA, dieB);


        
        System.out.println("Possible Sums and its total Combinations:");
        for (Map.Entry<Integer, List<int[]>> entry : possibleSumsOrg.entrySet()) {
            int totalSum = entry.getKey();
            List<int[]> combinations = entry.getValue();
            System.out.print("Sum " + totalSum + ": ");
            for (int[] combination : combinations) {
                System.out.print("(" + combination[0] + ", " + combination[1] + ") ");
            }
            System.out.print(" Count "+combinations.size());
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Probability of all possible sums:");
    	int totalCombinationOriginal = totalComb(dieA, dieB);
        Map<Integer, Double> sumProbabilitiesOriginal = calculateSumProbabilities(possibleSumsOrg, totalCombinationOriginal);
        for(Map.Entry<Integer, Double> entry: sumProbabilitiesOriginal.entrySet()) {
        	
        	System.out.println("P(X = "+ entry.getKey()+") = " + possibleSumsOrg.get(entry.getKey()).size() + "/36 = "
        +entry.getValue() );
        }

	}

}
