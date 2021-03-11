import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    //O(N) time where N is total elements including subArrays
    //O(D) space where D is depth of subArrays

    public static int productSum(List<Object> array){
        return productSumHelper(array, 1);
    }

    public static int productSumHelper(List<Object> array, int depth) {
        int sum = 0;
        for (var element: array){
            if(element instanceof ArrayList){ //check if element is a subArray/list ("special element")
                @SuppressWarnings("unchecked")
                var subArray = (ArrayList<Object>) element; //cast element into an independent subArrayList to recursively iterate
                sum += productSumHelper(subArray, depth + 1); //recursive call
            } else {
                sum += (int) element; //add integer element in main array to our sum
            }
        }
        return sum * depth;
    }
}
