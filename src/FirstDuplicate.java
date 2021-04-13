import java.util.HashMap;
import java.util.HashSet;

public class FirstDuplicate {
    public static int findFirstDuplicate(int [] array){
        HashSet<Integer> seen = new HashSet<Integer>();

        for(int value: array){
            if(seen.contains(value)) return value;
            seen.add(value);
        }
        return -1;
    }
}
