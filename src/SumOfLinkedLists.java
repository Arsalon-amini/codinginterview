public class SumOfLinkedLists {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    //O(max(N, M)) time where N is length of LL1 and M is length of LL2
    //O(max(N,M)) space
    public Node sumOfLinkedLists(Node headOfLinkedListOne, Node headOfLinkedListTwo){
        Node outputLinkListHeadPtr = new Node(0); //dummy node to begin building output linkedList
        Node currentNode = outputLinkListHeadPtr;
        int carry = 0;

        Node nodeOne = headOfLinkedListOne;
        Node nodeTwo = headOfLinkedListTwo;

        while(nodeOne != null || nodeTwo != null || carry != 0){
            int valueOne = (nodeOne != null) ? nodeOne.value : 0;
            int valueTwo = (nodeTwo != null) ? nodeTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int firstDigit = sumOfValues % 10; //gives first digit to append
            Node newNode = new Node(firstDigit);
            currentNode.next = newNode; //append to output linklist
            currentNode = newNode; //update ptr

            carry = sumOfValues / 10; //gives us the carry
            nodeOne = (nodeOne != null) ? nodeOne.next : null;
            nodeTwo = (nodeTwo != null) ? nodeTwo.next: null;
        }
        return outputLinkListHeadPtr.next;
    }
}
