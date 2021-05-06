import java.util.Arrays;

public class CycleInGraph {
    //O(V+E) time where V = #vertices and E=#of edges
    //O(V) space
    public boolean hasCycle(int[][] edges){
        int numberOfVertices = edges.length;
        boolean [] visited = new boolean[numberOfVertices];
        boolean [] inStack = new boolean[numberOfVertices];

        Arrays.fill(visited, false);
        Arrays.fill(inStack, false);

        for(int vertex = 0; vertex < numberOfVertices; vertex++){
            if(visited[vertex]) continue; //skip already visited nodes

            boolean containsCycle = depthFirstTraverse(vertex, edges, visited, inStack); //perform DFS
            if(containsCycle) return true;
        }
        return false;
    }

    public boolean depthFirstTraverse(int vertex, int[][]edges, boolean[] visited, boolean [] inStack){
        visited[vertex] = true; //update visited for current node to true
        inStack[vertex] = true; //update inStack for current node to true

        int [] neighbors = edges[vertex];
        for(int neighbor : neighbors){
            if(!visited[neighbor]) //not visited
                depthFirstTraverse(neighbor, edges, visited, inStack); //perform depth first recursive call
            if(inStack[neighbor]) //neighbor is an ancestor (back edge - pointing back to ancestor in call stack)
                return true;
        }
        inStack[vertex] = false; //remove value from inStack after visiting all edges
        return false;
    }

}
