import java.util.HashMap;
import java.util.HashSet;

public class FirstDuplicate {
    //#1
    //Brute Force
    //O(n^2) time
    //O(1) space
    public static int returnFirstDuplicateValue(int [] array){
        int secondMinimumIndex = array.length;

        for(int i = 0; i < array.length; i++){
            int value = array[i];
            for(int j = i + 1; j < array.length; j++){
                int valueToCompare = array[j];
                if(value == valueToCompare) secondMinimumIndex = Math.min(secondMinimumIndex, j);
            }
        }
        if(secondMinimumIndex == array.length) return -1;
        int firstDuplicate = array[secondMinimumIndex];
        return firstDuplicate;
    }

    //#2
    //Using a Set
    //O(n) time - single linear traversal
    //O(n) space - storing values in set
    public static int findFirstDuplicate(int [] array){
        HashSet<Integer> seen = new HashSet<Integer>();

        for(int value: array){
            if(seen.contains(value)) return value;
            seen.add(value);
        }
        return -1;
    }

    //#3
    //Using no external data structure - duplicate numbers map to the same index (5 - 1 = 4, array[4] < 0 ? )
    //O(n) time
    //O(1) space
    public static int returnFirstDuplicateLeastSpace(int [] array){
        for(int value: array){
            int absValue = Math.abs(value);
            if(array[absValue - 1] < 0) return value; //check if value at particular index is negative (x<0)
            array[absValue - 1] *= -1; //lookup index, make value negative
        }
        return -1;
    }
}
