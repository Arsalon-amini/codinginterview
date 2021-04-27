import java.util.Arrays;
//O(N) space - N is targetAmount (building numCoinsNeeded array to calculate final solution)
//O(N*d) time - where d is length of denoms array
public class MinNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int targetAmount, int [] denoms){
        int [] numCoinsNeeded = new int [targetAmount + 1];
        Arrays.fill(numCoinsNeeded, Integer.MAX_VALUE); //initialize
        numCoinsNeeded[0] = 0; //base case
        int toCompare = 0;

        for(int denom : denoms){
            for(int amount = 0; amount < targetAmount + 1; amount++){
                if(denom <= amount){
                    if(numCoinsNeeded[amount - denom] == Integer.MAX_VALUE){
                        toCompare = numCoinsNeeded[amount - denom]; //adding + 1 to Integer.MIN_Value flips sign
                    } else {
                        toCompare = 1 + numCoinsNeeded[amount - denom];
                    }
                    numCoinsNeeded[amount] = Math.min(numCoinsNeeded[amount], toCompare);
                }
            }
        }
        return numCoinsNeeded[targetAmount] != Integer.MIN_VALUE ? numCoinsNeeded[targetAmount] : -1;
    }
}
