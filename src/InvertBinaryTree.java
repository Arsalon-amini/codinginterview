import java.util.ArrayDeque;

public class InvertBinaryTree {

    //iterative approach
    //O(N) time, where N is number of nodes in tree
    //O(N) space, O(N)/2 leaf nodes stored in queue during traversal 
    public static void invertBinaryTree(Node root){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        while(queue.size() > 0){
            var currentNode = queue.pollFirst();
            swapLeftAndRight(currentNode);
            if(currentNode.left != null) queue.addLast(currentNode.left);
            if(currentNode.right != null) queue.addLast(currentNode.right);
        }
    }

    private static void swapLeftAndRight(Node node){
        var left = node.left;
        node.left = node.right;
        node.right = left;
    }



    static class Node{
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }
}
