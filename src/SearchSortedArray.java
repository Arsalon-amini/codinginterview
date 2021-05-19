public class SearchSortedArray {
    //O(n * m) time | wost case where n is width and m is the height of the matrix 
    //O(1) space
    public static int [] searchInSortedMatrix(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] > target)
                col--;
            else if (matrix[row][col] < target)
                row++;
            else
                return new int[]{row, col};
        }
        return new int [] { -1 , 1};
    }
}
