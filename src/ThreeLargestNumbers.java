public class ThreeLargestNumbers {

    //O(N) time - iterate entire array + output array
    //O(1) space - only storing 3 numbers in output array
    public static int [] returnThreeLargest(int [] array){
        int [] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}; //initialize output array to basically 0's
        for (int num: array){
            updateLargest(threeLargest, num); //TODO
        }
        return threeLargest; //final sorted array
    }

    public static void updateLargest(int [] threeLargest, int num){
        //threeLargest[largeIndex(0), largerIndex(1), LargestIndex(2)]
        if(num > threeLargest[2]){
            shiftAndUpdate(threeLargest, num, 2); //bigger than largest num?
        } else if(num > threeLargest[1]){
            shiftAndUpdate(threeLargest, num, 1); //bigger than second largest num?
        } else if (num > threeLargest[0]){
            shiftAndUpdate(threeLargest, num, 0); //bigger than third largest num?
        }
    }

    public static void shiftAndUpdate(int [] array, int num, int idx){
        for(int i = 0; i <= idx; i++){
            if(i == idx){
                array[i] = num; //place item
            } else {
                array[i] = array [i + 1]; //shift items
            }
        }
    }
}
