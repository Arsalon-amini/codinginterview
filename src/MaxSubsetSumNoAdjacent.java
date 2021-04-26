public class MaxSubsetSumNoAdjacent {
    //O(n) time, O(n) space where n is the length of the array
    public static int maxSubSetSumNoAdjacent(int [] array){
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];

        int[] maxSums = array.clone(); //maxSum[0] = array[0] aka first element in place
        maxSums[1] = Math.max(array[0], array[1]); //maxSum[1] = Max(array[0], array[1])

        for(int i = 2; i < array.length; i++){
            maxSums[i] = Math.max(maxSums[i -1], maxSums[i - 2] + array[i]);
        }
        return maxSums[array.length - 1]; //last element in maxSums array is maxSubSetNoAdjacent
    }
}
