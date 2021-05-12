import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    //O(2^n * n) time | O(2^n * n) space
    public static List<List<Integer>> getPowerSetIteratively(List<Integer> array){
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<>()); //empty set
        for(Integer element : array){
            int length = subsets.size(); //adding new subsets to subsets, avoid infinite loop by fixing length length prior to adding new subsets from current iteration
            for(int i = 0; i < length; i++){
                List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i)); //previous subset
                currentSubset.add(element); //previous subset + currentElement Ex. [] -> [1]
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }


    //Recursive soln
    //O(2^n * n) time | O(2^n * n) space) where n is # elements in input
    //2^n is number of powersets and n/2 converging to n is number of elements per subset
    public static List<List<Integer>> getPowerSetRecursively(List<Integer> array){
        return getPowerSetRecursively(array, array.size() - 1);
    }
    public static List<List<Integer>> getPowerSetRecursively(List<Integer> array, int idx){
        //base case or empty set []
        if(idx < 0){
            List<List<Integer>> emptySet = new ArrayList<List<Integer>>();
            emptySet.add(new ArrayList<Integer>());
            return emptySet;
        }
        int element = array.get(idx);
        List<List<Integer>> powersets = getPowerSetRecursively(array, idx - 1); //recursive call

        int length = powersets.size();
        for(int i = 0; i < length; i++){
            List<Integer> currentSubSet = new ArrayList<Integer>(powersets.get(i)); //new subset
            currentSubSet.add(element);
            powersets.add(currentSubSet);
        }
        return powersets;
    }
}
