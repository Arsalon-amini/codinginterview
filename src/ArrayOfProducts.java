public class ArrayOfProducts {
    //Brute Force Approach
    //O(n^2) time - where n is length of input
    //O(n) space - output array
    //algorithm - iterate the array with index i, at each i, perform a nested traversal to calculate the products
    public static int [] arrayOfProducts(int [] array){
        int [] products = new int[array.length];
        for (int i = 0; i < array.length; i++){
            int runningProduct = 1;
            for(int j = 0; j < array.length - 1; j++)
                if(i != j) runningProduct *= array[j];

                products[i] = runningProduct;
        }
        return products;
    }
}
