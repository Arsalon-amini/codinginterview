import java.util.Arrays;
//Time = O(n log n) + O(m log m) | m is length of arrayTwo && n is length of arrayOne
//Space = O(1) space
public class SmallestDifference {
    public static int [] smallestDifference(int [] arrayOne, int [] arrayTwo){
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int firstArrayIdx = 0;
        int secondArrayIdx = 0;

        int smallestAbsoluteDifference = Integer.MAX_VALUE;
        int currentAbsoluteDifference = Integer.MAX_VALUE;
        int[] pairWithSmallestAbsoluteDifference = new int[2];

        while(firstArrayIdx < arrayOne.length && secondArrayIdx < arrayTwo.length){
            int firstArrayNum = arrayOne[firstArrayIdx];
            int secondArrayNum = arrayTwo[secondArrayIdx];

            currentAbsoluteDifference = Math.abs(firstArrayNum - secondArrayNum);
            if(firstArrayNum < secondArrayNum){
                firstArrayIdx++;
            } else if (firstArrayNum > secondArrayNum){
                secondArrayIdx++;
            } else {
                return new int[]{ firstArrayNum, secondArrayNum }; //nums are equal (diff = 0)
            }

            if(currentAbsoluteDifference < smallestAbsoluteDifference){
                smallestAbsoluteDifference = currentAbsoluteDifference;
                pairWithSmallestAbsoluteDifference[0] = firstArrayNum;
                pairWithSmallestAbsoluteDifference[1] = secondArrayNum;
            }
        }
        return pairWithSmallestAbsoluteDifference;
    }
}


