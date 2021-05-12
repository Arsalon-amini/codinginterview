import java.util.ArrayList;
import java.util.List;

public class Permutations {
    //O(N^2 * N!) time | O(N*N!) space
    public static List<List<Integer>> getPermutations(List<Integer> array){
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutations(array, new ArrayList<Integer>(), permutations);
        return permutations;
    }

    public static void getPermutations(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations){
        if(array.size() == 0 && currentPermutation.size() > 0)
            //this is hit O(N!) times (like a divide and conquer algorithm)
            permutations.add(currentPermutation); //O(N) operation
        else {
            for(int i = 0; i < array.size(); i++){
                List<Integer> newArray = new ArrayList<Integer>(array); //O(N) operation
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
                newPermutation.add(array.get(i));
                getPermutations(newArray, newPermutation, permutations);
            }
        }
    }

    //O(N!*N) time | O(N!*N) space
    public static List<List<Integer>> getPermutationsV2(List<Integer> array){
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutationsHelper(0, array, permutations);
        return permutations;
    }

    public static void getPermutationsHelper(int i , List<Integer> array, List<List<Integer>> permutations){
        //O(N!) times this is hit (iterating entire array N! times)
        if(i == array.size() - 1)
            permutations.add(new ArrayList<Integer>(array)); //O(N) operation
        else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j); //O(1) operation
                getPermutationsHelper(i + 1, array, permutations);
                swap(array, i, j); //re-swap to original positions
            }
        }
    }

    public static void swap(List<Integer> array, int i, int j){
        Integer tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
}


