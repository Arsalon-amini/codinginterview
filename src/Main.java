import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18);

        //List<Integer> preOrderTraversalValues = new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));

        var root = ConstructBSTPreOrder.constructBST(array);

        System.out.println(root);


    }
}

