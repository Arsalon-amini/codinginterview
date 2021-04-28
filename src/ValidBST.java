public class ValidBST {
    //O(n) time where n is the number of nodes in the tree
    //O(d) depth where d is the length of the longest branch
    static class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isValidBST(Node tree){
        return isValidBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST(Node tree, int minValue, int maxValue){
        if(tree == null) return true;
        if(tree.value < minValue || tree.value > maxValue) return false;
        if(tree.right !=null && !isValidBST(tree.right, tree.value, maxValue)) return false;
        if(tree.left !=null && !isValidBST(tree.left, minValue, tree.value)) return false;
        return true;
    }
}
