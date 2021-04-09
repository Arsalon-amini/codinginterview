import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    //O(n log n) time, rely on sorting, n is length of input
    //O(n) space, mergedIntervals array

    //like a stack, where we have reference to last item put on it
    //keep updating that last item reference
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        int [][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<int[]>(); //initialize output
        int [] currentInterval = sortedIntervals[0]; //create reference to first interval
        mergedIntervals.add(currentInterval); //append first interval to output

        //traverse remaining input intervals
        //comparing reference to interval in output to rest of intervals traversing
        //look for overlap, if so, merge by updating end value of reference in output
        //otherwise, append next interval, continue
        for(int [] nextInterval: sortedIntervals){
            int currentIntervalEnd = currentInterval[1]; //extract end value from reference interval
            int nextIntervalStart = nextInterval[0]; //extract start value from current interval
            int nextIntervalEnd = nextInterval[1];

            //check for overlap
            if(currentIntervalEnd >= nextIntervalStart){
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd); //update end of reference interval to larger
            } else { //no overlap
                currentInterval = nextInterval; //update our reference to new interval (current)
                mergedIntervals.add(currentInterval); //append interval to output
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
