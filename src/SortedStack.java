import java.util.ArrayList;

public class SortedStack {
    //complexity
    //O(n^2) time | O(n) space

    public ArrayList<Integer> sortedStack(ArrayList<Integer> stack){
        if(stack.size() == 0){
            return stack; //step 1 - check rec fn base case
        }

        int top = stack.remove(stack.size() - 1); //step 2

        sortedStack(stack); //step 3 - recursive call (O(n) operation)

        insertInSortedOrder(stack, top);

        return stack;
    }

    public void insertInSortedOrder(ArrayList<Integer> stack, int value){
        //rec base case
        if(stack.size() == 0 || (stack.get(stack.size() - 1) <= value)) {
            stack.add(value);
            return;
        }

        int top = stack.remove(stack.size() - 1);

        insertInSortedOrder(stack, value); //recursive call (O(n) operation)

        stack.add(top); 
    }
}
