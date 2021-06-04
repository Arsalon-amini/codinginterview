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

    //O(n) time
    //O(1) space - using a stringBuilder mutable string
    public static boolean isPalindrome1(String str){
        StringBuilder reversed = new StringBuilder();
        for(var i = str.length() -1; i >=0; i--){
            reversed.append(str.charAt(i));
        }
        return str.contentEquals(reversed);
    }

    //O(n) time
    //O(n) space - using recursive stack
    public static boolean isPalindrome2(String str){
        return isPalindrome2(str, 0);
    }
    public static boolean isPalindrome2(String str, int i){
        int j = str.length() - 1 - i;
        return i >= j ? true : str.charAt(i) == str.charAt(j) && isPalindrome2(str, i+1);
    }

}
