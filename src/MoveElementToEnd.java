import java.util.List;

public class MoveElementToEnd {
    //O(n) time, where n is length of input array
    //O(1) space

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove){
        int i = 0;
        int j = array.size() - 1;
        while(i < j) {
            while (i < j && array.get(j) == toMove) j--; //if j is at target, move j left
            if (array.get(i) == toMove) swap(i, j, array);
            i++;
        }
        return array;
    }

    private static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}
