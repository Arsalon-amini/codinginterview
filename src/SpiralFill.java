import java.util.ArrayList;
import java.util.List;

//O(N) time where N is the total elements in the 2D array
//O(N) space where N is the total elements in the 2D array output into a 1D array of size N
public class SpiralFill {
    public static List<Integer> spiralTraverse(int [] [] array){
        if(array.length == 0) return new ArrayList<Integer>();

        var result = new ArrayList<Integer>();
        spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
        return result;
    }

    public static void spiralFill(int [][] array, int startRow, int endRow, int startCol, int endCol, ArrayList<Integer> result){
        if(startRow > endRow || startCol > endCol) return; //entire 2D array traversed

        //iterate top of perimeter (left to right)
        for(int c = startCol; c <= endCol; c++){
            result.add(array[startRow][c]);
        }
        //iterate right side of perimeter (top to bottom)
        for(int r = startRow + 1; r <= endRow; r++){
            result.add(array[r][endCol]);
        }

        //iterate bottom of perimeter (right to left)
        for(int c = endCol - 1; c >= startCol; c--){
            if(startRow == endRow) break; //edge case

            result.add(array[endRow][c]);
        }

        for(int r = endRow - 1; r >= startRow + 1; r--){

            if(startCol == endCol) break; //edge case
            result.add(array[r][startCol]);
        }

        spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
    }

}
