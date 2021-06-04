public class LongestPalindromeSubString {

    //O(n^3) time | O(n) space
    //generates all possible substrings in O(n^2)
    //checks if they're palindromes, updating longest
    public static String longestPalindromicSubStringV1(String str){
        String currentLongestPalindrome = "";
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                String substring = str.substring(i, j + 1);
                if(substring.length() > currentLongestPalindrome.length() && isPalindrome(substring)){
                    currentLongestPalindrome = substring;
                }
            }
        }
        return currentLongestPalindrome;
    }

    public static boolean isPalindrome(String str){
        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        while(leftIdx < rightIdx){
            if(str.charAt(leftIdx) != str.charAt(rightIdx))
                return false;

            leftIdx++;
            rightIdx++;
        }
        return true;
    }

    //O(n^2) time | O(1) space
    public static String longestPalindromicSubstring(String str){
        int[] longestPalindromicSubstring = {0 , 1};
        for(int i = 1; i < str.length(); i++){
            int [] oddPalindromicSubstring = getLongestPalindromeFromStart(str, i - 1, i + 1); //oddPalindromicSubstring palindrome middle
            int [] evenPalindromicSubstring = getLongestPalindromeFromStart(str, i - 1, i); //evenPalindromicSubstring palindrome middle
            int [] currentLongestPalindromicSubstring = oddPalindromicSubstring[1] - oddPalindromicSubstring[0] > evenPalindromicSubstring[1] - evenPalindromicSubstring[0]
                    ? oddPalindromicSubstring : evenPalindromicSubstring; //endIdx - startIdx = palindrome len

            longestPalindromicSubstring = longestPalindromicSubstring[1] - longestPalindromicSubstring[0] > currentLongestPalindromicSubstring[1] - currentLongestPalindromicSubstring[0] ? longestPalindromicSubstring : currentLongestPalindromicSubstring;
        }
        return str.substring(longestPalindromicSubstring[0], longestPalindromicSubstring[1]); //builds palindromic substring from indices (non inclusive of end index value)
    }

    public static int[] getLongestPalindromeFromStart(String str, int leftIdx, int rightIdx){
        while(leftIdx >= 0 && rightIdx < str.length()){
            if(str.charAt(leftIdx) != str.charAt(rightIdx))
                break;
            leftIdx--;
            rightIdx++;
        }
        return new int[] {leftIdx + 1, rightIdx}; //rightIdx + 1 not neccessary bcuz we later build a string whose range is non inclusive of end index
    }
}
