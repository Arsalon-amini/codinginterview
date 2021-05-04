import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
           this.name = name;
        }
        public Node addChild(String name){
            var newNode = new Node(name);
            children.add(newNode);
            return this;
        }

        //O(v + e) time | O(v) space
        public List<String> breadthFirstSearch(List<String> array){
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(this);

            while(!queue.isEmpty()) {
                var current = queue.poll(); //pops out element at top of queue
                array.add(current.name);
                queue.addAll(current.children);
            }
            return array;
        }
    }
}
