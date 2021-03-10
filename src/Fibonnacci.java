import java.util.Map;

public class Fibonnacci {

    //O(n^2) time, O(n) space
    //repeating calculations
    public int getNthFibSoln1(int n){
        if(n == 2) return 1;
        else if (n == 1) return 0;
        else return getNthFibSoln1(n-1) + getNthFibSoln1(n -2);
    }

    //O(n) time, O(n) space
    //store values in hashtable, during recursive calls get previous calculations in O(1) time
    public int getNthFibMemoization(int n, Map<Integer, Integer> memoize){
        if (memoize.containsKey(n)) {
            return memoize.get(n); //get stored solution for this calculation
        } else {
            memoize.put(n, getNthFibMemoization(n-1, memoize) + getNthFibMemoization(n-2, memoize));
        } return memoize.get(n);
    }

}
