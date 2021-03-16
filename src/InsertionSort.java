public class InsertionSort {
    //O(n^2) time worst, O(1) space
    //O(n) time best, O(1) space

    public static int [] insertionSort(int [] array) {
        if (array.length == 0) return new int[]{}; //defensive programming
        //this for loop moves the input array's pointer right to left in O(n) time
        for (int i = 1; i < array.length; i++) {
            int j = i;
            //this while loop moves it's pointers in reverse swapping right to left in O(n) time
            //the purpose of this loop is to move the element into the correct sorted sequence position
            while (j > 0 && array[j] < array[j - 1]) {
                swap(j, j - 1, array);
            }
        }
        return array;
    }

    public static void swap (int i, int j, int[] array){
        int temp = array[j];
        array[j] = array[i]; //leftward swap as part of the reverse while loop
        array[i] = temp;
    }
}
