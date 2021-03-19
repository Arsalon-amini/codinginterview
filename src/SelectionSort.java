public class SelectionSort {
    public static void sort(int [] array){
        for(var i = 0; i < array.length; i++){
            var minIndex = i;
            for(var j = i; j < array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                    swap(array, minIndex, i);
                }
            }
        }
    }

    public static void swap(int [] array, int newMinIndex, int oldMinIndex){
        var selection = array[newMinIndex];
        array[newMinIndex] = array[oldMinIndex];
        array[oldMinIndex] = selection;
    }

    public static int [] selectionSort(int[] array){
        if(array.length == 0) return new int[]{};
        int startIdx = 0;
        while(startIdx < array.length - 1){
            int smallestIdx = startIdx;
            for(int i = startIdx + 1; i < array.length; i++){
                if(array[smallestIdx] > array[i]){
                    smallestIdx = i;
                }
            }
            swap(startIdx, smallestIdx, array);
            startIdx++;
        }
        return array;
    }

    public static void swap(int i, int j, int[] array){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
