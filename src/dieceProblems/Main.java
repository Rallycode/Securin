package dieceProblems;

import java.util.*;

public class Main {

	static int[][] comb = new int[6][6];
	
	//Q1
	public static int totalComb(int[] dieA, int[] dieB) {
		return (dieA.length * dieB.length);
	}	

    public static int[] rollDice() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    //Q2
	public static void possibleCombo(int[] dieA, int[] dieB) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < dieA.length ; i++) {
			
			for(int j = 0 ; j < dieB.length ; j++) {
				
				System.out.print("(" + dieA[i] + "," + dieB[j]+"), ");
				comb[i][j] = dieB[j] ;
			}
			System.out.println();
		}
	}
    //Q3
    public static Map<Integer, List<int[]>> getPossibleSums(int[] dieA, int[] dieB) {
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
        int[] dieA = rollDice();
        int[] dieB = rollDice();

        // PART - A

        // Q1
        System.out.println("Total combinations possible: " + totalComb(dieA, dieB));

        // Q2
        possibleCombo(dieA, dieB);

        // Q3
        Map<Integer, List<int[]>> possibleSumsOrg = getPossibleSums(dieA, dieB);


        //PART - B
        System.out.println("Possible Sums and Combinations:");
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
    	int totalCombinationOriginal = totalComb(dieA, dieB);
        Map<Integer, Double> sumProbabilitiesOriginal = calculateSumProbabilities(possibleSumsOrg, totalCombinationOriginal);
        for(Map.Entry<Integer, Double> entry: sumProbabilitiesOriginal.entrySet()) {
        	
        	System.out.println("P(X = "+ entry.getKey()+") = " + possibleSumsOrg.get(entry.getKey()).size() + "/36 = "
        +entry.getValue() );
        }

	//PART B
	//Here we are fixing the first 4 indeices of dieA and dieB as {1,2,3,4} and then check for all the remaining possibilites by applying the given constraints
	boolean flag = false;
        for(int i = 0 ; i < 5 ; i++) {
        	
        	diea[4] = i;
        	for(int j = 0 ; j < 5 ; j++) {
        		
        		
        		diea[5] = j;
        		for(int  k = 0 ; k < 13 ; k++) {
        			dieb[4] = k;
        			for(int l = 0 ; l < 13 ; l++) {
        				dieb[5] = l;
                        int totalCombinations = totalComb(diea, dieb);
                        Map<Integer, Double> sumProbabilities = calculateSumProbabilities(possibleSums, totalCombinations);
                        
                   	System.out.println(Arrays.toString(diea) + " " + Arrays.toString(dieb));
                   	System.out.println();
                        
                     
                        if(sumProbabilities.equals(sumProbabilitiesOriginal)) {
                        	System.out.println(Arrays.toString(diea));
                        	System.out.println(Arrays.toString(dieb));
                        	flag = true;
                        }
        			}
        		}
        	}
        }
        
        if(!flag) {
        	System.out.println("No such possiblites");
        }
	    
      /*  
      brute force approcah for solving the PART - B
      Here we iterate over each position of dieA and for each dieA the dieB also need to iterate over all positions
      
       boolean flag = false;
       for (int a = 0; a <= 4; a++) {
           for (int b = 0; b <= 4; b++) {
               for (int c = 0; c <= 4; c++) {
                   for (int d = 0; d <= 4; d++) {
                       for (int e = 0; e <= 4; e++) {
                           for (int f = 0; f <= 4; f++) {
                               int[] diea = {a, b, c, d, e, f};
                               for (int g = 0; g <= 12; g++) {
                                   for (int h = 0; h <= 12; h++) {
                                       for (int i = 0; i <= 12; i++) {
                                           for (int j = 0; j <= 12; j++) {
                                               for (int k = 0; k <= 12; k++) {
                                                   for (int l = 0; l <= 12; l++) {
                                                       int[] dieb = {g, h, i, j, k, l};
                                                       int totalCombinations = totalComb(diea, dieb);
                                                       Map<Integer, List<int[]>> possibleSums = getPossibleSums(diea, dieb);

                                                       Map<Integer, Double> sumProbabilities = calculateSumProbabilities(possibleSums, totalCombinations);

                                                       // Check if the sumProbabilities match
                                                       if (sumProbabilities.equals(sumProbabilitiesOriginal)) {
                                                           System.out.println(Arrays.toString(diea)+" " + Arrays.toString(dieb));
                                                           flag = true;
                                                       }
                                                   }
                                               }
                                           }
                                       }
                                   }
                               }
                           }
                       }
                   }
               }
           }
       }
       if (!flag) {
           System.out.println("No such possibilities");
       }
   */
   
    
    }

}
