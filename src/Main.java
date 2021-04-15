public class Main {
    public static void main(String[] args) {
        var root = new BinarySearchTree.BST(10);

        root.leftNode = new BinarySearchTree.BST(5);
        root.leftNode.leftNode = new BinarySearchTree.BST(2);
        root.leftNode.rightNode = new BinarySearchTree.BST(5);
        root.leftNode.leftNode.leftNode = new BinarySearchTree.BST(1);

        root.rightNode = new BinarySearchTree.BST(15);
        root.rightNode.leftNode = new BinarySearchTree.BST(13);
        root.rightNode.rightNode = new BinarySearchTree.BST(22);

        root.rightNode.leftNode.leftNode = new BinarySearchTree.BST(12);
        root.rightNode.leftNode.rightNode = new BinarySearchTree.BST(14);



        root.insert(15);
        root.contains(14);
        root.remove(10);

        System.out.println(root);
    }
}

