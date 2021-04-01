public class removeDuplicates {
    private class LinkedList{
        private Node first;
        private Node last;
        private int size;

        private class Node{
            private int value;
            private Node next;

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
    }

    public LinkedList removeDuplicates(LinkedList list){
        var currentNode = list.first;
        while(currentNode != null){
            var nextDistinctNode = currentNode.next;
            while(nextDistinctNode != null && nextDistinctNode.value == currentNode.value){
                nextDistinctNode = nextDistinctNode.next; //skips all nonDistinct values
            }
            currentNode.next = nextDistinctNode; //set next node in output list to nextDistinctNode
            currentNode = nextDistinctNode;
        }
        return list;
    }
}
