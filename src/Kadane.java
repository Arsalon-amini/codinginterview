public class Kadane {
    //O(n) time where n is length of input array
    //O(1) space - only storing two integers
    public static int kadanesAlgorithm(int [] array){
        int currentMax = array[0];
        int greatestMax = array[0];
        for(int i = 1; i < array.length; i++){
            int value = array[i];
            currentMax = Math.max(currentMax + value, value);
            greatestMax = Math.max(currentMax, greatestMax);
        }
        return greatestMax;
    }
}
