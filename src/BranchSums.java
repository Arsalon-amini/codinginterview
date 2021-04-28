import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    //O(n) time, O(n) space recursive stack from O(n)/2 roughly leafs

    public List<Integer> branchSums(Node root){
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    public void calculateBranchSums(Node root, int runningSum, List<Integer> sums){
        if(root == null) return; //recursion end

        int newRunningSum = runningSum + root.value;
        if(root.left == null && root.right == null){
            sums.add(newRunningSum); //leaf nodes reach, add current branch sum
            return;
        }

        calculateBranchSums(root.left, newRunningSum, sums);
        calculateBranchSums(root.right, newRunningSum, sums);
    }



    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
