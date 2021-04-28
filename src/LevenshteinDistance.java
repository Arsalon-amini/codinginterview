public class LevenshteinDistance {
    //O(NM) time, where N = str1.length and M = str2.length
    //O(NM) space
    public static int levenshteinDistance(String str1, String str2){
        int [][] edits = new int[str2.length() + 1][str1.length() + 1]; //initialize 2D array

        //initialize 2D array
        for(int row = 0; row < str2.length() + 1; row++){
            for(int col = 0; col < str1.length() + 1; col++){
                edits[row][col] = col; //edits[row][col] -> edits[0][col = 0, 1, 2, 3, 4] -> initialize top row zero columns
            }
            edits[row][0] = row; //edits[row][col] -> edits[row = 0, 1, 2, 3, 4][0] -> initialize col zero, rows to base case
        }

        for(int row = 1; row < str2.length() + 1; row++){
            for(int col = 1; col < str1.length() + 1; col++){
                if(str2.charAt(row - 1) == str1.charAt(col - 1)){
                    edits[row][col] = edits[row - 1][col - 1];
                } else {
                    edits[row][col] =
                            1 + Math.min(edits[row][col - 1], Math.min(edits[row - 1][col], edits[row - 1][col - 1]));
                }
            }
        }
        return edits[str2.length()][str1.length()]; //return final value in 2D array (solution)
    }

    //O(NM) time, where N is length of str1 and M is length of str2
    //O(min(N,M)) space
    public static int levenshteinDistanceV2(String str1, String str2){
        //determine which string is smaller
        var smallerString = str1.length() < str2.length() ? str1 : str2;
        var largerString = str1.length() >= str2.length() ? str2 : str1;

        //store only two rows of original 2D array
        int [] evenRow = new int[smallerString.length() + 1];
        int [] oddRow = new int[smallerString.length() + 1];

        //initialize base cases
        for(int col = 0; col < smallerString.length() + 1; col++) {
            evenRow[col] = col;
        }

        //pointers
        int[] currentRow;
        int [] previousRow;

        for(int i = 1; i < largerString.length() + 1; i++){
            if(i % 2 == 1){
                currentRow = oddRow;
                previousRow = evenRow;
            } else {
                currentRow = evenRow;
                previousRow = oddRow;
            }
            currentRow[0] = i;
            for(int col = 1; col < smallerString.length() + 1; col++){
                if(largerString.charAt(i - 1) == smallerString.charAt(col - 1)){
                    currentRow[col] = previousRow[col - 1];
                } else {
                    currentRow[col] =
                            1 + Math.min(previousRow[col - 1], Math.min(previousRow[col], currentRow[col - 1]));
                }
            }
        }
        return largerString.length() % 2 == 0 ? evenRow[smallerString.length()] : oddRow [smallerString.length()];
    }

}
