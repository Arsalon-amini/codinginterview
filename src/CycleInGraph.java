import java.util.ArrayList;
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

    //-------Solution2---------
    //O(V + E) time, where V is # vertices and E is number of edges
    //O(V) space - creating auxiliary "colors" array to store information
    //unVisited = 0, inStack = 1, completed = 2
    public int WHITE = 0; //unvisited
    public int GREY = 1; //inStack
    public int BLACK = 2; //completed
    public boolean hasCycleV2(int[][]edges){
        int numVertices = edges.length;
        int[] colors = new int[numVertices];
        Arrays.fill(colors, WHITE);

        for(int vertex = 0; vertex < colors.length; vertex++){
            if(colors[vertex] != WHITE) continue;
            boolean containsCycle = depthFirstColoring(vertex, edges, colors);
            if(containsCycle) return true;
        }
        return false;
    }

    public boolean depthFirstColoring(int vertex, int[][]edges, int[] colors){
        colors[vertex] = GREY; //update current vertex to inStack

        int [] neighbors = edges[vertex];
        for(int neighbor : neighbors){
            int neighborColor = colors[neighbor];
            if(neighborColor == GREY)
                return true;
            if(neighborColor == BLACK)
                continue;

            //optimization to terminate recursive early after first cycle detected
            boolean hasCycle = depthFirstColoring(neighbor, edges, colors);
            if(hasCycle) return true;
        }
        colors[vertex] = BLACK; //traversed through all edges of current node, completed DFS for this node (moving up call stack)
        return false; //if cycle is present, will return in the for each loop
    }

}
