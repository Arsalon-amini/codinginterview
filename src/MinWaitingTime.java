import java.util.Arrays;

public class MinWaitingTime {
    //O(n log n) time, O(1) space where n is the number of queries
    public int minimumWaitingTime(int [] queries){
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        for(int idx = 0; idx < queries.length; idx++){
            int duration = queries[idx];
            int queriesLeft = queries.length - (idx + 1);
            totalWaitingTime += duration * queriesLeft;
        }
        return totalWaitingTime;
    }
}


