public class ClosestValueBST {

    //O(log n) time, O(n) space
    public int findClosestValueInBSTRecursively(Node tree, int target){
        return findClosesValueInBSTRecursively(tree, target, tree.value);
    }

    public int findClosesValueInBSTRecursively(Node node, int target, int closestValue){
        if(Math.abs(target - closestValue) > Math.abs(target - node.value)){
            closestValue = node.value;
        }
        if(target < node.value && node.left !=null){
            return findClosesValueInBSTRecursively(node.left, target, closestValue);
        } else if (target > node.value && node.right !=null) {
            return findClosesValueInBSTRecursively(node.right, target, closestValue);
        } else {
            return closestValue;
        }
    }

    //O(log n) time, O(1) space
    public int findClosestValueInBSTIteratively(Node root, int target){
        return findClosestValueInBSTIteratively(root, target, root.value);
    }

    public int findClosestValueInBSTIteratively(Node root, int target, int closestValue){
        var currentNode = root;
        while(currentNode != null){
            if(Math.abs(target - closestValue) > Math.abs(target - currentNode.value)){
                closestValue = currentNode.value;
            }
            if(target < currentNode.value){
                currentNode = currentNode.left;
            } else if (target > currentNode.value)
                currentNode = currentNode.right;
            else
                break;
        }
        return closestValue;
    }

    class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
