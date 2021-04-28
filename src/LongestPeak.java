public class LongestPeak {
    //O(N) time where N is length of input array
    //O(1) space
    public static int longestPeak(int [] array){
        int longestPeak = 0;
        int i = 1;

        while(i < array.length - 1){
            boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];

            if(!isPeak){
                i += 1;
                continue;
            }

            //find length of left slope
            int leftIdx = i - 2;
            while(leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]){
                leftIdx -=1;
            }

            //find length of right slope
            int rightIdx = i + 2;
            while(rightIdx <= array.length && array[rightIdx] < array[rightIdx - 1]){
                rightIdx += 1;
            }

            //update longestPeak
            int currentPeakLength = rightIdx - leftIdx - 1;
            if(currentPeakLength > longestPeak){
                longestPeak = currentPeakLength;
            }

            //move to next potential peaks
            i = rightIdx;
        }
        return longestPeak;
    }
}
