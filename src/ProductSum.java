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
            if(element instanceof ArrayList){ //check if element is a nested list
                @SuppressWarnings("unchecked")
                var subArray = (ArrayList<Object>) element;
                sum += productSumHelper(subArray, depth + 1);
            } else {
                sum += (int) element;
            }
        }
        return sum * depth;
    }
}
