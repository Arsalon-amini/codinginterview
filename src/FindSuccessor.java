import java.util.ArrayList;

public class FindSuccessor {
    //soln 1 - O(n) time, O(n) space
    //traverse inOrder (left, visit, right), appending values to an output array
    //iterate array looking for target, return next value (successor)
    public Node findSuccessor(Node root, Node target){
        ArrayList<Node> inOrderTraverseValues = new ArrayList<Node>();
        traverseInOrder(root,inOrderTraverseValues); //returns list of nodes traverseInOrder order

        for(int i = 0; i < inOrderTraverseValues.size(); i ++){
            var current = inOrderTraverseValues.get(i);
            if(current != target) continue;
            if(i == inOrderTraverseValues.size() - 1) return null; //no successor
            return inOrderTraverseValues.get(i + 1); //returns successor
        }
        return null; //no successor
    }

    public void traverseInOrder(Node root, ArrayList<Node> output){
        if(root.left != null) traverseInOrder(root.left, output);
        output.add(root);
        if(root.right != null) traverseInOrder(root.right, output);
    }


    //Solution 2 - (Optimized)
    //Complexity analysis - O(h) time, O(1) space | O(n) time, O(1) space worst case
    //where h is the height of the tree (longest branch)
    //target hasRightSubtree -> successor = leftMostValue in rightSubtree of target (left, visit, right)
    //target !hasRightSubTree -> successor = first parent where target is in parent's leftSubtree
    public static Node findSuccessorV2(Node root, Node target){
        if(target.right != null) return getLeftMostChild(target.right);
        return getRightMostParent(target);
    }

    public static Node getLeftMostChild(Node node){
        var current = node;
        while(current.left != null){
            current = current.left;
        }
        return current; //leftMost leaf node
    }

    public static Node getRightMostParent(Node node){
        var current = node;
        while(current.parent != null && current.parent.right == current){
            current = current.parent;
        }
        return current.parent; //have reached root of leftSubTree (left, this, right)
    }
    static class Node{
        public int value;
        public Node right = null;
        public Node left = null;
        public Node parent = null;

        public Node (int value){
            this.value = value;
        }
    }


}
