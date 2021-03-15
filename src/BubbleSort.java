public class BubbleSort {
    public static int [] bubbleSort(int [] array){
        //O(n ^2) time worst case, O(1) space
        //O(n ^2) time average, O(1) space
        //O(n) time best case, O(1) space
        if(array.length == 0) return new int [] {};
        boolean isSorted = false;
        int counter = 0;
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < array.length - 1 - counter; i++){
                if(array[i] > array[i + 1]){
                    swap(i, i +1, array);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i]; //move larger element one space to the right
        array[i] = temp; //re-insert smaller value one spt to left
    }
}
