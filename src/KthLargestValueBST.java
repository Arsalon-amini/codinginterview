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

    static class TreeInfo{
        public int numberOfNodesVisited;
        public int latestVisitedNodeValue;

        public TreeInfo(int numberOfNodesVisited, int latestVisitedNodeValue) {
            this.numberOfNodesVisited = numberOfNodesVisited;
            this.latestVisitedNodeValue = latestVisitedNodeValue;
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

    //O(h + k) time where h is the height of the BST
    //O(h) space where h is height of BST on recursive stack
    public int findKthLargestValueInBSTv2(Node node, int k){
        var treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraverse(node,k, treeInfo);
        return treeInfo.latestVisitedNodeValue;
    }

    public void reverseInOrderTraverse(Node node, int k , TreeInfo treeInfo){
        if(node == null || treeInfo.numberOfNodesVisited >= k) return;

        reverseInOrderTraverse(node.right, k, treeInfo);
        if(treeInfo.numberOfNodesVisited < k){
            treeInfo.numberOfNodesVisited += 1;
            treeInfo.latestVisitedNodeValue = node.value;
            reverseInOrderTraverse(node.left, k, treeInfo);
        }
    }
}
