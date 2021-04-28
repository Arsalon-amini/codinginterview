import java.util.Arrays;
//O(n log n) + O(n) = O(n log n) time
//O(1) space - sorting / mutated array in place

public class nonConstructibleChange {
    public int nonConstructableChange(int [] coins){
        Arrays.sort(coins);  //O(n log n) time, O(1) space operation

        int currentChangeCreated = 0;
        for(int coin: coins){
            if(coin > currentChangeCreated + 1) return currentChangeCreated + 1;

            currentChangeCreated += coin;
        }
        return currentChangeCreated + 1;
    }
}
