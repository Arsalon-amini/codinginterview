import java.util.List;

public class ConstructBSTPreOrder {

    static class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    //takes an input array of values corresponding to PreOrderBST traversal
    //write a fn that takes input and builds a BST
    //O(n^2) time, O(n) space in output but O(h) space in creating the BST where h is height of tree
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

    static class TreeInfo {
        public int rootIdx;

        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }

    //O(n) time, O(n) space
    public Node constructBSTv2(List<Integer> preOrderTraversalValues){
        var treeInfo = new TreeInfo(0);
        return constructBSTFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    public Node constructBSTFromRange(int lowerBound, int upperBound, List<Integer> preOrderTraversalValues, TreeInfo currentSubTreeInfo){
        if(currentSubTreeInfo.rootIdx == preOrderTraversalValues.size()) return  null;

        var rootValue = preOrderTraversalValues.get(currentSubTreeInfo.rootIdx);
        if(rootValue < lowerBound || rootValue >= upperBound) return null; //check if valid node

        currentSubTreeInfo.rootIdx += 1; //valid subtree root confirmed

        Node leftSubTree = constructBSTFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubTreeInfo);
        Node rightSubTree = constructBSTFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubTreeInfo);

        Node node = new Node(rootValue);
        node.left = leftSubTree;
        node.right = rightSubTree;
        return node;
    }

}



