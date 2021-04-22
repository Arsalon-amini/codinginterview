import java.util.List;

public class ConstructBSTPreOrder {
    //takes an input array of values corresponding to PreOrderBST traversal
    //write a fn that takes input and builds a BST
    //O(n^2) time, O(n) space in output but O(h) space in creating the BST where h is height of tree

    static class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node constructBST(List<Integer> preOrderTraversalValues){
        if(preOrderTraversalValues.size() == 0) return null;

        int nodeValue = preOrderTraversalValues.get(0);
        int rightIdx = preOrderTraversalValues.size();

        //iterate input looking for rightChild of currentNode - O(n) operation
        for(int idx = 1; idx < preOrderTraversalValues.size(); idx++){
            var currentElement = preOrderTraversalValues.get(idx);
            if(currentElement > nodeValue){
                rightIdx = idx;
                break;
            }
        }

        var leftSubTreeRange = preOrderTraversalValues.subList(1, rightIdx);
        var leftSubTree = constructBST(leftSubTreeRange);

        var rightSubTreeRange = preOrderTraversalValues.subList(rightIdx, preOrderTraversalValues.size());
        var rightSubTree = constructBST(rightSubTreeRange);

        Node node = new Node(nodeValue);
        node.left = leftSubTree;
        node.right = rightSubTree;

        return node;
    }


}
