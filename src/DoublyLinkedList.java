public class DoublyLinkedList {
    public Node head;
    public Node tail;

    //O(1) time | O(1) space
    public void setHead(Node node){
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        insertBefore(head, node);
    }

    public void setTail(Node node){
        if(tail == null){
            setHead(node);
            return;
        }
        insertAfter(tail, node);
    }

    //O(1) time | O(1) space
    public void insertBefore(Node target, Node nodeToInsert){
        if(nodeToInsert == head && nodeToInsert == tail) return; //linkedList w/ only one node (equal to NodeToInsert), cannot insert before itself, do nothing

        remove(nodeToInsert); //remove from linkedList, reposition

        nodeToInsert.prev = target.prev; //connect left binding
        nodeToInsert.next = target; //connect right binding

        if(target.prev == null)
            head = nodeToInsert; //update head
        else
            target.prev.next = nodeToInsert;

        target.prev = nodeToInsert;
    }

    //O(1) time | O(1) space
    public void insertAfter(Node target, Node nodeToInsert){
        if(nodeToInsert == head && nodeToInsert == tail) return;
        remove(nodeToInsert);
        nodeToInsert.prev = target;
        nodeToInsert.next = target.next;
        if(target.next == null)
            tail = nodeToInsert;
        else
            target.next.prev = nodeToInsert;

        target.next = nodeToInsert;
    }

    //O(p) time | O(1) space
    public void insertAtPosition(int position, Node nodeToInsert){
        if(position == 1){
            setHead(nodeToInsert);
            return;
        }
        Node node = head;
        int currentPosition = 1;

        while(node != null && currentPosition != position){
            node = node.next;
            currentPosition++;
        }
        if(node != null) //not at tail
            insertBefore(node, nodeToInsert); //reached position
        else
            setTail(nodeToInsert);
    }

    //O(n) space | O(1) time
    public boolean containsNodeWithValue(int value){
        //traverse linkedList
        Node node = head;
        while(node != null && node.value != value){
            node = node.next;
        }
        return node != null; //true (means broke while loop, found value)
    }

    //O(1) time | O(1) space
    public void remove(Node target){
        if(target == head)
            head = head.next; //removing first node, update head to next node in linkedList

        if(target == tail)
            tail = tail.prev; //removing last node, update tail to previous node

        removeNodeBindings(target);
    }


    //O(N) time | O(1) space
    public void removeNodesWithValue(int value){
        Node node = head; //start at head

        while(node != null){
            Node nodeToRemove = node;
            node = node.next; //establish a ptr so we don't lose access to next node, if removing current

            if(nodeToRemove.value == value)
                remove(nodeToRemove);
        }
    }

    public void removeNodeBindings(Node node){
        //update surrounding nodes
        if(node.prev != null) node.prev.next = node.next; //update left side node pointers
        if(node.next != null) node.next.prev = node.prev; //update right side node pointers
        //remove target node completely
        node.prev = null;
        node.next = null;
    }

    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node (int value){
            this.value = value;
        }
    }
}
