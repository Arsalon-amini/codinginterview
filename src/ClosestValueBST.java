public class ClosestValueBST {

    public int findClosestValueInBSTRecursively(Node tree, int target){
        //O(log n) time, O(n) space
        return findClosesValueInBSTRecursively(tree, target, tree.value);
    }

    public int findClosesValueInBSTRecursively(Node tree, int target, int closestValue){
        if(Math.abs(target - closestValue) > Math.abs(target - tree.value)){
            closestValue = tree.value;
        }
        if(target < tree.value && tree.left !=null){
            return findClosesValueInBSTRecursively(tree.left, target, closestValue);
        } else if (target > tree.value && tree.right !=null) {
            return findClosesValueInBSTRecursively(tree.right, target, closestValue);
        } else {
            return closestValue;
        }
    }
    
    public int findClosestValueInBSTIteratively(Node tree, int target){
        //O(log n) time, O(1) space
        return findClosestValueInBSTIteratively(tree, target, tree.value);
    }

    public int findClosestValueInBSTIteratively(Node tree, int target, int closest){
        var currentNode = tree;
        while(currentNode != null){
            if(Math.abs(target - closest) > Math.abs(target - currentNode.value)){
                closest = currentNode.value;
            }
            if(target < currentNode.value){
                currentNode = currentNode.left;
            } else if (target > currentNode.value)
                currentNode = currentNode.right;
            else
                break;
        }
        return closest;
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
