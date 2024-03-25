package partB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Question1 {

	//First find the original sum of probability
	//Next do the permutation on two dice
	//In dice A => 1 2 3 4 are fixed
	//In dice B => 1 8 is fixed
	
	
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

		Scanner in =new Scanner(System.in);
		int[] dieA = rollDice();
		int[] dieB= rollDice();
		int[] diea = new int[6];
		int[] dieb = new int[6];
		
		for(int i = 0 ; i < 6 ;i++) {
			System.out.print("Die a ["+(i+1)+"] face: ");
			diea[i] = in.nextInt();
		}
		for(int i = 0 ; i < 6 ;i++) {
			System.out.print("Die b ["+(i+1)+"] face: ");
			dieb[i] = in.nextInt();
		}
        boolean flag = false;
        int totalCombination = totalComb(dieA, dieB);
        Map<Integer, List<int[]>> possibleSums = getPossibleSums(dieA, dieB);

        Map<Integer, Double> sumProbabilitiesOriginal = calculateSumProbabilities(possibleSums, totalCombination);
        		

        int totalCombinations = totalComb(diea, dieb);
        Map<Integer, List<int[]>> possibleSum = getPossibleSums(diea, dieb);

        Map<Integer, Double> sumProbabilities = calculateSumProbabilities(possibleSum, totalCombinations);
        
        System.out.println("Possible Sums and its total Combinations of original dice:");
        for (Map.Entry<Integer, List<int[]>> entry : possibleSums.entrySet()) {
            int totalSum = entry.getKey();
            List<int[]> combinations = entry.getValue();
            System.out.print("Sum " + totalSum + ": ");
            for (int[] combination : combinations) {
                System.out.print("(" + combination[0] + ", " + combination[1] + ") ");
            }
            System.out.print(" Count "+combinations.size());
            System.out.println();
        }
        
        
        System.out.println("Possible Sums and its total Combinations of doomed dice:");
        for (Map.Entry<Integer, List<int[]>> entry : possibleSum.entrySet()) {
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
        System.out.println("Probability of all possible sums of original dice:");
        for(Map.Entry<Integer, Double> entry: sumProbabilitiesOriginal.entrySet()) {
        	
        	System.out.println("P(X = "+ entry.getKey()+") = " + possibleSums.get(entry.getKey()).size() + "/36 = "
        +entry.getValue() );
        }

//        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Probability of all possible sums of doomed dice:");
        for(Map.Entry<Integer, Double> entry: sumProbabilities.entrySet()) {
        	
        	System.out.println("P(X = "+ entry.getKey()+") = " + possibleSum.get(entry.getKey()).size() + "/36 = "
        +entry.getValue() );
        }

        
        //The sum probability of original dice and loki doomed dice
        if(sumProbabilities.equals(sumProbabilitiesOriginal)) {
        	System.out.println(Arrays.toString(diea));
        	System.out.println(Arrays.toString(dieb));
        	flag = true;
        }
  
        
        if(!flag) {
        	System.out.println("No such possiblites");
        }else {
        	System.out.println("Yes such possiblites");
        }

		
	}

}
