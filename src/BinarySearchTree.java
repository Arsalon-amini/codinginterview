public class BinarySearchTree {
    static class BST {
        public int value;
        public BST rightNode;
        public BST leftNode;

        public BST(int value) {
            this.value = value;
        }

        //Average: O(log(n)) time | O(1) space
        //Worst: O(n) time | O(1) space
        public BST insert(int value) {
            BST current = this;
            var newNode = new BST(value); //instantiate a new node to hold value

            if (current == null) {
                current = newNode; //initialize root node
                return newNode;
            }

            //place according to BST property (greater than all left nodes, less or equal to right nodes)
            while (true) {
                if (value < current.value) {
                    if (current.leftNode == null) {
                        current.leftNode = newNode;
                        break;
                    }
                    current = current.leftNode; //continue traversal

                } else {
                    if (current.rightNode == null) {
                        current.rightNode = newNode;
                        break;
                    }
                    current = current.rightNode; //continue traversal
                }
            }
            return newNode;
        }

        //Average: O(log(n)) time | O(1) space
        //Worst: O(n) time | O(1) space
        public boolean contains(int value) {
            BST current = this;
            while (current != null) {
                if (value < current.value)
                    current = current.leftNode; //traverse left
                else if (value > current.value)
                    current = current.rightNode; //traverse right
                else
                    return true; //value == current.value
            }
            return false;

        }

        //Average: O(log (n)) time, O(1) space
        //Worst: O(n) time, O(n) space
        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parentNode) {
            BST current = this;

            while (current != null) {
                if (value < current.value) {
                    parentNode = current;
                    current = current.leftNode;
                } else if (value > current.value) {
                    parentNode = current;
                    current = current.rightNode;
                } else {
                    //Edge Case 1 - Node has both rightChild and leftChild
                    if (current.leftNode != null && current.rightNode != null) {
                        current.value = current.rightNode.getMinValue(); //find smallest value in rightSubtree (leftMost) & replace current value w/ this value
                        current.rightNode.remove(current.value, current); //remove smallest rightSubtree value from rightSubtree
                    //Edge Case 2 - Node has zero or one child but no parent (is a root node)
                    } else if (parentNode == null) {
                        if (current.leftNode != null) {
                            current.value = current.leftNode.value;
                            current.rightNode = current.leftNode.rightNode;
                            current.leftNode = current.leftNode.leftNode;
                        } else if (current.rightNode != null) {
                            current.value = current.rightNode.value; //update current node value to right child's value ("erase" overwrite current value)
                            current.rightNode = current.rightNode.rightNode; //set current node's right child to current.rightChild's right child
                            current.leftNode = current.rightNode.leftNode;
                        } else {
                            //Edge Case 3 - Node has zero children (is only node in the tree (root)), don't delete anything
                        }
                    //Edge Case 4 - Node has one or none children and is either a rightNode or leftNode
                    } else if (parentNode.leftNode == current) {  //check if current node (to remove) is a left node, if so, update it's left parent to skip it
                        parentNode.leftNode = current.leftNode != null ? current.leftNode : current.rightNode;
                    } else if(parentNode.rightNode == current){
                        parentNode.rightNode = current.rightNode !=null ? current.rightNode : current.leftNode;
                    }
                    break;
                }
            }
        }

        public int getMinValue() {
            if (leftNode == null) return value;
            else return leftNode.getMinValue();
        }
    }
}


