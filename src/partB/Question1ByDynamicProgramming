package partB;

import java.util.Arrays;

//Here we implemented dynamic programming to solve the classical doomed dice problem
public class Main {

    // Original sum probabilities map
    static int[] sumOrgProb = new int[13];

    // Check if the sum probabilities are maintained
    public static boolean maintainsProbSum(int[] diea, int[] dieb) {
        int[] sumProb = new int[13];

        for (int i : diea) {
            for (int j : dieb) {
                int sum = i + j;
                sumProb[sum]++;
            }
        }

        for (int i = 2; i <= 12; i++) {
            if (sumProb[i] > sumOrgProb[i]) {
                return false;
            }
        }
        return true;
    }

    // Generate faces of dice A and B using dynamic programming with pruning
    public static void generateDice(int[] diea, int[] dieb, int aIndex, int bIndex) {
        if (aIndex == 6 && bIndex == 6) {
            if (maintainsProbSum(diea, dieb)) {
                System.out.println("Die A: " + Arrays.toString(diea));
                System.out.println("Die B: " + Arrays.toString(dieb));
                System.exit(0); // Exit once a valid combination is found
            }
            return;
        }

        // Generate faces for dice A
        if (aIndex < 6) {
            for (int i = 1; i <= 4; i++) {
                diea[aIndex] = i;
                generateDice(diea, dieb, aIndex + 1, bIndex);
                diea[aIndex] = 0; // Reset the face value
            }
        }

        // Generate faces for dice B
        if (bIndex < 6) {
            for (int i = 1; i <= 8; i++) {
                dieb[bIndex] = i;
                generateDice(diea, dieb, aIndex, bIndex + 1);
                dieb[bIndex] = 0; // Reset the face value
            }
        }
    }

    public static void main(String[] args) {
        // Initialize original sum probabilities map
        sumOrgProb[2] = 1;
        sumOrgProb[3] = 2;
        sumOrgProb[4] = 3;
        sumOrgProb[5] = 4;
        sumOrgProb[6] = 5;
        sumOrgProb[7] = 6;
        sumOrgProb[8] = 5;
        sumOrgProb[9] = 4;
        sumOrgProb[10] = 3;
        sumOrgProb[11] = 2;
        sumOrgProb[12] = 1;

        // Initialize arrays for dice A and B
        int[] diea = new int[6];
        int[] dieb = new int[6];

        // Generate faces of dice A and B using dynamic programming with pruning
        generateDice(diea, dieb, 0, 0);

        // If no valid combination is found, print empty dice A and B
        System.out.println("Die A: " + Arrays.toString(diea));
        System.out.println("Die B: " + Arrays.toString(dieb));
    }
}
