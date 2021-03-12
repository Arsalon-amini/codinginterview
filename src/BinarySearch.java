public class BinarySearch {

    //O(log(n) time, O(log(n)) space
    public static int binarySearch(int [] array, int target){
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int [] array, int target, int left, int right){
        if(left > right){
            return -1;
        }
        int middle = (left + right) / 2;
        int potentialMatch = array[middle]; //middle index
        if (target  == potentialMatch) {
            return middle;
        } else if (target < potentialMatch) {
            return binarySearch(array, target,left, middle - 1); //target is in left partition
        }
        else {
            return binarySearch(array, target, middle + 1, right);
        }
    }

    //O(log(n)) time, O(1) space
    public static int binarySearchIterative(int [] array, int target){
        return binarySearchIterative(array, target, 0, array.length - 1);
    }

    public static int binarySearchIterative(int [] array, int target, int left, int right){
        while(left <= right){
            int middle = (left + right) / 2;
            int potentialMatch = array[middle];
            if(target == potentialMatch){
                return middle;
            } else if (target < potentialMatch){
                right = middle -1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
