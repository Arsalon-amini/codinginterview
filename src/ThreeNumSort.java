public class ThreeNumSort {

    //O(n) time | O(1) space where n is length of input array
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
}
