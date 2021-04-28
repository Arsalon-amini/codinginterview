public class BinaryTreeDiameter {

    //O(N) time - visiting all nodes
    //O(N) space - recursive calls
   public int calculateBinaryTreeDiameter(Node root){
       return getTreeInfo(root).diameter;
   }

    public TreeInfo getTreeInfo(Node node){
        if(node == null) return new TreeInfo(0, 0);

        var leftSubTreeInfo = getTreeInfo(node.left);
        var rightSubTreeInfo = getTreeInfo(node.right);

        int longestPathThroughCurrentNode = leftSubTreeInfo.height + rightSubTreeInfo.height;

        int maxDiameterSoFar = Math.max(leftSubTreeInfo.diameter, rightSubTreeInfo.diameter);

        int currentDiameter = Math.max(longestPathThroughCurrentNode, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftSubTreeInfo.height, rightSubTreeInfo.height);

        return new TreeInfo(currentDiameter, currentHeight);
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }
}
