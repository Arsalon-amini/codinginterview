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
