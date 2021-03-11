import java.util.Map;

public class Fibonnacci {

    //O(n^2) time, O(n) space
    //repeating calculations
    public static int getNthFibSoln1(int n){
        if(n == 2) return 1;
        else if (n == 1) return 0;
        else return getNthFibSoln1(n-1) + getNthFibSoln1(n -2);
    }

    //O(n) time, O(n) space
    //store values in hashtable, during recursive calls get previous calculations in O(1) time
    public static int getNthFibMemoization(int n, Map<Integer, Integer> memoize){
        if (memoize.containsKey(n)) {
            return memoize.get(n); //get stored solution for fib(n) in O(1) time
        } else {
            memoize.put(n, getNthFibMemoization(n-1, memoize)
                            + getNthFibMemoization(n-2, memoize));
        } return memoize.get(n);
    }

    //O(n) time, O(1) space
    //uses an array to store last two digits required to calc current fib
    //then moves new digit into array for next fib calculation
    public static int getNthFibIterative(int n){
        int [] lastTwo = {0 , 1};
        int counter = 3;
        while(counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }

}

