import java.util.List;

public class ConstructMinHeightBST {
    public static BST minHeightBSTSoln2(List<Integer> array){
        return constructMinHeightBSTV2(array, null, 0, array.size() - 1);
    }

    public static BST constructMinHeightBSTV2(List<Integer> array, BST currentNode, int startIdx, int endIdx){
        if(endIdx < startIdx) return  null;

        int midIdx = (startIdx + endIdx) / 2;
        var newNode = new BST(array.get(midIdx));

        if(currentNode == null)
            currentNode = newNode;
        else {
            if(array.get(midIdx) < currentNode.value){
               currentNode.left = newNode;
               currentNode = currentNode.left;
            } else {
                currentNode.right = newNode;
                currentNode = currentNode.right;
            }
        }
        constructMinHeightBSTV2(array, currentNode, startIdx, midIdx - 1); //construct left subtree
        constructMinHeightBSTV2(array, currentNode, midIdx + 1, endIdx); //construct right subtree
        return currentNode;
    }


    static class BST {
        public int value;
        public BST right;
        public BST left;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value){
            if(value < this.value){
                if(left == null) left = new BST(value);
                left.insert(value);
            } else {
                if(right == null) right = new BST(value);
                right.insert(value);
            }
        }
    }
}
