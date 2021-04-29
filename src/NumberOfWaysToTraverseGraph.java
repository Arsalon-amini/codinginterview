public class NumberOfWaysToTraverseGraph {

    //Recursive solution -
    //O(2 ^ (n+m) ) time | O(n + m) space - where n
    // is the width of the graph and m is the height
    public int numberOfWaysToTraverseGraphRecursive(int width, int height){
        if(width == 1 || height == 1) return 1; //base case (leftMost column -> only move right = 1, topRow -> can only move down = 1 )
        return numberOfWaysToTraverseGraphRecursive(width - 1, height)
                + numberOfWaysToTraverseGraphRecursive(width, height - 1);
    }

    //Dynamic programming -
    //O(NM) time | O(NM) space where N = width and M = height of graph
    //space comes from making a 2D array for storing intermediary values
    //can lower space complexity to O(Min(N,M)) by storing only portions of 2D array
    public static int numberOfWaysToTraverseGraph(int width, int height){
        int [][] numberOfWays = new int[height + 1][width + 1];

        for(int columnIdx = 1; columnIdx < width + 1; columnIdx++){
            for(int rowIdx = 1; rowIdx < height + 1; rowIdx++){
                if(columnIdx == 1 || rowIdx == 1){
                    numberOfWays[rowIdx][columnIdx] = 1; //base case
                } else {
                    int waysLeft = numberOfWays[rowIdx][columnIdx - 1]; //look left
                    int waysUp = numberOfWays[rowIdx - 1][columnIdx]; //look up
                    numberOfWays[rowIdx][columnIdx] = waysLeft + waysUp;
                }
            }
        }
        return numberOfWays[height][width];
    }

}
