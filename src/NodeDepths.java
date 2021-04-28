import java.util.ArrayList;
import java.util.List;


public class NodeDepths {

    public static int nodeDepthsRecusive(Node root) {
        return calculateDepth(root, 0);
    }

    public static int calculateDepth(Node root, int depth) {
        if (root == null) return 0; //base case
        return depth
                + calculateDepth(root.left, depth + 1)
                + calculateDepth(root.right, depth + 1);
    }

    public static int nodeDepthIterative(Node root){
        int sumOfDepths = 0;
        List<Level> stack = new ArrayList<Level>();
        stack.add(new Level(root, 0));
        while (stack.size() > 0){
            Level top = stack.remove(stack.size() - 1);
            Node node = top.root;
            int depth = top.depth;
            if(node == null) continue;
            sumOfDepths += depth;
            stack.add(new Level(node.left, depth + 1));
            stack.add(new Level(node.right, depth +1));
        }
        return sumOfDepths;
    }


    static class Level{
        public Node root;
        int depth;

        public Level(Node root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}




