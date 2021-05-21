public class ThreeNumSort {

    //O(n) time | O(1) space where n is length of input array - three iterations
    public int [] threeNumSortV1(int [] array, int [] order){
        int [] counts = new int[] {0 , 0, 0}; //each index represent a bucket corresponding with element in order array

        //populate our counts array - finding out which idx in order array each element from input corresponds
        for(int element : array){
            int bucket = getIndex(order, element); //returns the bucket
            counts[bucket]++; //increment that bucket's count
        }

        for(int i = 0; i < 3; i++){
            int value = order[i]; //value we are inserting on this iteration
            int elementFrequency = counts[i]; //how many of those values inserting (frequency of element)

            int numElemBefore = getSum(counts, i); //return next start idx (ie # of elements already inserted)
           //using each bucket + count in sorting input array values
            for(int n = 0; n < elementFrequency; n++){
                int currentIdx = numElemBefore + n;
                array[currentIdx] = value;
            }
        }
        return array;
    }

    //runs through the order array (subList) and matches input array element to an index (bucket)
    public int getIndex(int [] array, int element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element)
                return i;
        }
        return -1;
    }

    public int getSum(int [] array, int end){
        int sum = 0;
        for(int i = 0; i < end; i++){
            sum += array[i];
        }
        return sum;
    }

    //O(n) time | O(1) space - two iterations only
    public int[] threeNumberSortV2(int [] array, int [] order){
        int firstValue = order[0];
        int lastValue = order[2];

        //iterate left to right (forward)
        int firstIdx = 0;
        for(int idx = 0; idx < array.length; idx++){
            if(array[idx] == firstValue){
                swap(array, firstIdx, idx);
                firstIdx += 1;
            }
        }

        //iterate left to right (backward)
        int thirdIdx = array.length - 1;
        for(int idx = array.length - 1; idx >= 0; idx--){
            if(array[idx] == lastValue){
                swap(array, thirdIdx, idx);
                thirdIdx--;
            }
        }
        return array;
    }

    public void swap (int [] array, int i, int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
