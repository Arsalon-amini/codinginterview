import java.util.HashMap;
import java.util.HashSet;

public class FirstDuplicate {
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
}
