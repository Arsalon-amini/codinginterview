import java.util.ArrayList;

public class KthLargestValueBST {

    static class Node {
        public int value;
        public Node right;
        public Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    //O(n) time, O(n) space where n is number of nodes in BST
    //performs an inOrderTraverse to get nodes in sorted order
    //returns the kth largest element from the sorted output of inOrderTraversal 
    public int findKthLargestValueInBST(Node root, int k){
        ArrayList<Integer> sortedNodeValues = new ArrayList<Integer>();
        inOrderTraverse(root, sortedNodeValues);
        return sortedNodeValues.get(sortedNodeValues.size() - k);
    }

    private void inOrderTraverse(Node node, ArrayList<Integer> sortedNodeValues) {
        if(node == null) return;

        inOrderTraverse(node.left, sortedNodeValues);
        sortedNodeValues.add(node.value);
        inOrderTraverse(node.right, sortedNodeValues);
    }
}
