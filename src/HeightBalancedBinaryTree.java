public class HeightBalancedBinaryTree {
    //O(n) time - traverse every node making sure it's balanced
    //O(h) space - recursive call stacks, where h is height of binary tree
    public boolean isHeightBalanced(Node root){
        var treeInfo = getNodeInfo(root);
        return treeInfo.isBalanced;
    }

    public NodeInfo getNodeInfo(Node node){
        if(node == null) return new NodeInfo(true, 1);

        var leftSubTreeInfo = getNodeInfo(node.left);
        var rightSubTreeInfo = getNodeInfo(node.right);

        boolean isBalanced = leftSubTreeInfo.isBalanced
                && rightSubTreeInfo.isBalanced
                && Math.abs(leftSubTreeInfo.height - rightSubTreeInfo.height) <= 1;

        int height = Math.max(leftSubTreeInfo.height, rightSubTreeInfo.height) + 1;
        return new NodeInfo(isBalanced, height);
    }

    static class Node {
        public int value;
        public Node left = null;
        public Node right = null;

        public Node(int value){
            this.value = value;
        }
    }

    static class NodeInfo {
        public boolean isBalanced;
        public int height;

        public NodeInfo(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
