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

}
