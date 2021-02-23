import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumSum {

    public int [] twoPointers(int [] array, int targetSum) {
        //O(n log n) time, O(1) space
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while(left < right){
            var currentSum = array[left] + array[right];
            if(currentSum == targetSum){
                return new int[] {array[left], array[right]};
            }
            else if (currentSum < targetSum) left++; //left pointer forward
            else if (currentSum > targetSum) right --; //right pointer forward
        }

        return new int[0];
    }

    public int [] twoNumSum(int [] array, int targetSum){
        //O(n) time, O(n) space
        Set<Integer> nums = new HashSet<>();
        for (int num: array){
            int potentialMatch = targetSum - num;
            if(nums.contains(potentialMatch)){
                return new int [] {potentialMatch, num};
            } nums.add(num);
        }
        return new int[0];
    }



}

