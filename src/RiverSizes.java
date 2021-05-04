import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix){
        List<Integer> riverSizes = new ArrayList<Integer>(); //output contains river riverSizes
        boolean [][] visited = new boolean[matrix.length][matrix[0].length]; //init to input dimensions, w/ defaults = false

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(visited[row][col]) continue; //if node already visited, skip
                traverseNode(row, col, matrix, visited, riverSizes); //traverse unvisited node
            }
        }
        return riverSizes;
    }

    private static void traverseNode(int row, int col, int[][] matrix, boolean[][] visited, List<Integer> riverSizes){
        int currentRiverSize = 0;
        var nodesToExplore = new Stack<Integer[]>(); //each value is a [row, column] index for a node aka x = [ [row, col], [row, col] ]

        nodesToExplore.push(new Integer[]{row, col}); //first node to explore is current

        //depth first search (iteratively)
        while(!nodesToExplore.empty()){
            var currentNode = nodesToExplore.pop(); //pops off [row,col] int array
            row = currentNode[0];
            col = currentNode[1];

            if(visited[row][col]) continue; //visited already, skip
            visited[row][col] = true; //else, mark as visited
            if(matrix[row][col] == 0) continue; //skip O's, don't visit neighbors

            currentRiverSize++; //current node hasn't been visited is a 1, increment river size

            //get current node's neighbors append to nodes to explore stack (depth first traversal)
            var unvisitedNeighbors = getUnvisitedNeighbors(row, col, matrix, visited);

            //append unvisited neighbors to our nodes to explore stack
            for(Integer[] neighbor : unvisitedNeighbors){
                nodesToExplore.add(neighbor);
            }
        }
        if (currentRiverSize > 0) riverSizes.add(currentRiverSize);
    }

    public static List<Integer[]> getUnvisitedNeighbors(int row, int col, int[][] matrix, boolean[][] visited){
        var unvisitedNeighbors = new ArrayList<Integer[]>(); //empty array, follows List interface

        if(row > 0 && !visited[row - 1][col])  //neighbor above current node (not top row)
            unvisitedNeighbors.add(new Integer[]{row - 1, col}); //append indices of neighbor above

        if(row < matrix.length - 1 && !visited[row + 1][col]) //neighbor below (not bottom row)
            unvisitedNeighbors.add(new Integer[]{row + 1, col});

        if(col > 0 && !visited[row][col - 1])  //neighbor left (not leftMost column)
            unvisitedNeighbors.add(new Integer [] {row, col - 1});

        if(col < matrix[0].length - 1 && !visited[row][col + 1]) //neighbor right (not rightMost column)
            unvisitedNeighbors.add(new Integer[]{row, col + 1});

        return unvisitedNeighbors;
    }
}
