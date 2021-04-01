import java.util.Arrays;
import java.util.*;

public class sortedSquaredArray {

    //O(n log n) time
    //O(n) space
    public int [] sortedSquareArray(int [] array){
        int [] sortedSquares = new int[array.length];
        for(int idx = 0; idx < array.length; idx++){
            int value = array[idx];
            sortedSquares[idx] = value * value;
        }
        Arrays.sort(sortedSquares);
        return sortedSquares;
    }

    //O(n) time
    //O(1) space
    public int [] sortedSquaredArrayV2(int [] array){
        int [] sortedSquares = new int[array.length];
        int smallerValueIdx = 0;
        int largerValueIdx = array.length - 1;
        for(int idx = array.length - 1; idx >= 0; idx --){
            int smallerValue = array[smallerValueIdx];
            int largerValue = array[largerValueIdx];
            if(Math.abs(smallerValue) > Math.abs(largerValue)){
                sortedSquares[idx] = smallerValue * smallerValue;
                smallerValueIdx++; 
            } else {
                sortedSquares[idx] = largerValueIdx * largerValueIdx;
                largerValueIdx --;
            }
        }
        return sortedSquares;
    }
}
