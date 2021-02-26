public class Main {

    public static void main(String[] args) {
        nodeDepths.Node root = new nodeDepths.Node(12);
        root.left = new nodeDepths.Node(7);
        root.right = new nodeDepths.Node(1);
        root.left.left = new nodeDepths.Node(8);
        root.left.right = new nodeDepths.Node(5);
        int depth = nodeDepths.nodeDepthsRecusive(root);
        System.out.println(depth);
    }
}

