public class RemoveKthNodeFromEnd {
    //O(n) time, O(1) space
    public static void removeKthNodeFromEnd(Node head, int k){
        int counter = 1;
        Node first = head;
        Node second = head;

        //move second pointer k nodes up
        while(counter <= k){
            second = second.next;
            counter++;
        }

        //case where kth node is head
        //second already pointing to null
        // garbage collect head, update bindings
        if(second == null){
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        //move both pts until second points to null (reached end of linkedList)
        while(second.next != null){
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next; //garbage collect (kth node) by removing it's bindings
    }

    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
