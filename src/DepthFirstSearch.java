import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChild(String name){
            var child = new Node(name);
            children.add(child);
            return this;
        }
    }

    //O(V + E) time
    //O(V) space

    public static List<String> depthFirstSearch(List<String> array, Node root){
        array.add(root.name);
        for(int i = 0; i < root.children.size(); i++){
            depthFirstSearch(array, root.children.get(i));
        }
        return array;
    }
}
