import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    //O(n) time traversing every node to sum, O(n) space converges from O(n)/2 roughly leafs

    public List<Integer> branchSums(BTNode root){
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    public void calculateBranchSums(BTNode node, int runningSum, List<Integer> sums){
        if(node == null) return; //recursion end

        int newRunningSum = runningSum + node.value;
        if(node.left == null && node.right == null){
            sums.add(newRunningSum); //branch traversal end
            return;
        }

        calculateBranchSums(node.left, newRunningSum, sums); //depth first recursive traversal
        calculateBranchSums(node.right, newRunningSum, sums);
    }



    class BTNode{
        int value;
        BTNode left;
        BTNode right;

        public BTNode(int value) {
            this.value = value;
        }
    }

}
