public class Main {

    public static void main(String[] args) {
        var array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
	    var targetSum = 10;
        var program = new TwoNumSum();
       // program.twoPointers(array, targetSum);
        program.twoNumSum(array, targetSum);
     }
}

