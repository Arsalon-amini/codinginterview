public class NumberOfWaysToTraverseGraph {

    //Recursive solution -
    //O(2 ^ (n+m) ) time | O(n + m) space - where n
    // is the width of the graph and m is the height
    public int numberOfWaysToTraverseGraphRecursive(int width, int height){
        if(width == 1 || height == 1) return 1; //base case (leftMost column -> only move right = 1, topRow -> can only move down = 1 )
        return numberOfWaysToTraverseGraphRecursive(width - 1, height)
                + numberOfWaysToTraverseGraphRecursive(width, height - 1);
    }
}
