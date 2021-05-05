import java.util.ArrayList;
import java.util.Stack;

public class RemoveIslands {
    //O(wh) time where w is width and h is the height
    //O(wh) space
    public static int[][] removeIslands(int[][] matrix){
        //initialize auxiliary data structure
        boolean [][] isConnectedToBorderOnes = new boolean[matrix.length][matrix[0].length];

        //loop through 2D matrix - find all 1's connected to borders
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                //establish boolean pointers indicating borders
                boolean isBorderRow = row == 0 || row == matrix.length - 1;
                boolean isBorderCol = col == 0 || col == matrix[0].length - 1;
                boolean isBorderPosition = isBorderRow || isBorderCol;

                //skip non relevant 1's
                if(!isBorderPosition) continue; //skip non-border 1's
                if(matrix[row][col] != 1) continue; //skip 0's on border

                //if isBorderPosition && is a 1 -> perform depth first search (find 1's connected to borders)
               findOnesConnectedToBorders(matrix, row, col, isConnectedToBorderOnes);
            }
        }

        //remove islands (1's not connected to borders)
        for(int row = 1; row < matrix.length - 1; row++){
            for(int col = 1; col < matrix[row].length - 1; col++){
                if(isConnectedToBorderOnes[row][col]) continue; //skip 1's connected to borders
                matrix[row][col] = 0;
            }
        }
        return matrix;
    }

    public static void findOnesConnectedToBorders(int[][] matrix, int startRow, int startCol, boolean [][] isConnectedToBorders){
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{startRow, startCol}); //first position on stack (DFS)

        //Depth first search
        while(stack.size() > 0){
            int[] currentPosition = stack.pop();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            boolean isVisited = isConnectedToBorders[currentRow][currentCol]; //ensures not considering same position multiple times
            if(isVisited) continue; //if connected to border, don't add to stack or perform additional operations

            isConnectedToBorders[currentRow][currentCol] = true; //element popped from stack was connected to border (only adding connected to border 1s)

            ArrayList<int[]> neighbors = getNeighbors(matrix, currentRow, currentCol); //get current 1's position neighbors

            //check to see if any neighbors are 1's, if so, add to stack (connected to border 1's)
            for(int [] neighbor: neighbors){
                int row = neighbor[0];
                int col = neighbor[1];

                if(matrix[row][col] != 1) continue; //skip 0's in neighbors
                stack.push(neighbor); //push neighbor 1's of border 1's to stack
            }

        }
    }

    public static ArrayList<int[]> getNeighbors (int[][] matrix, int row, int col){
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        ArrayList<int[]> neighbors = new ArrayList<int[]>();

        if(row - 1 >=0 )
            neighbors.add(new int[]{row - 1, col}); //UP neighbor (if not on border)
        if(row + 1 < numRows)
            neighbors.add(new int[]{row + 1, col}); //DOWN neighbor
        if(col - 1 >= 0)
            neighbors.add(new int[]{row, col - 1}); //LEFT neighbor
        if(col + 1 < numCols)
            neighbors.add(new int[]{row, col + 1}); //RIGHT neighbor

        return neighbors;
    }
}
