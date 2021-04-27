public class NumberOfWaysToMakeChange {
    //O(n*d) time where n is the target amount and d is the # of values in the denominations array
    //O(n) space where n is the target amount (going to create an array of size [n+1])
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int denom : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }
}
