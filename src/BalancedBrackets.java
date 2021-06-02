import java.util.*;

public class BalancedBrackets {

    private String input;
    private final List<Character> leftBrackets
            = Arrays.asList('(', '<', '[', '{'); //creates an array list stores left brackets
    private final List<Character> rightBrackets
            = Arrays.asList(')', '>', ']' , '}'); //creates an array list stores right brackets

    public BalancedBrackets(String input){
        this.input = input;
    }

    public boolean isBalanced (){
        Stack<Character> stack = new Stack<>();

        for(char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty()) return false; //error handling

                var top = stack.pop(); //pops the previously stored (left bracket)
                if (!bracketsMatch(top, ch)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch){
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch){
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right); //compares index of char in left w/ index of char of right
    }

    //O(n) time | O(n) space
    public static boolean balancedBracketsSol2 (String str){
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Map<Character, Character> matchingBrackets = new HashMap<Character, Character>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']','[');
        matchingBrackets.put('}', '{');

        List<Character> stack = new ArrayList<Character>();
        for(int i = 0; i < str.length(); i++){
            char letter = str.charAt(i);
            if(openingBrackets.indexOf(letter) != -1) //add to stack if opening bracket
                stack.add(letter);
            else if (closingBrackets.indexOf(letter) != -1){ //
                if(stack.size() == 0)
                    return false;
                if(stack.get(stack.size() - 1) == matchingBrackets.get(letter)){
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
