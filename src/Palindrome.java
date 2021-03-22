public class Palindrome {
    //O(n) time
    //O(1) space - two pointers
    public static boolean isPalindrome(String str){
        int leftIdx = 0;
        int rightIdx = str.length() - 1;

        while(leftIdx < rightIdx){
            if(str.charAt(leftIdx) != str.charAt(rightIdx)){
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
}
