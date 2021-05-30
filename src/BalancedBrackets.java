import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
}
