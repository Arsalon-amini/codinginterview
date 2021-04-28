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

    //O(N) time, where N is # of input elements
    //O(N) space
    public static int [] arrayOfProductsVersion2(int [] array){
        int [] products = new int[array.length];
        int [] rightProducts = new int [array.length];
        int [] leftProducts = new int [array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++){
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for(int j = array.length - 1; j >= 0; j--){
            rightProducts[j] = rightRunningProduct;
            rightRunningProduct *= array[j];
        }

        for(int k = 0; k < array.length; k++){
            products[k] = leftProducts[k] * rightProducts[k];
        }

        return products;
    }

    //O(n) time
    //O(n) space
    public static int [] arrayOfProductsVersion3(int [] array){
        int [] products = new int[array.length];

        int leftRunningProduct = 1;
        for(int i =0; i < array.length; i++){
            products[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for(int i = array.length - 1; i >= 0; i--){
            products[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        return products;
    }
}
