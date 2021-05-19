import java.util.HashMap;

public class StairCaseTraversal {
    ///O(k^n) time | O(n) space - where k is maxSteps and n is height
    public static int staircaseTraversal(int height, int maxSteps){
        return getNumberOfWaysToTop(height, maxSteps);
    }

    public static int getNumberOfWaysToTop(int height, int maxSteps){
        if (height <= 1)
            return 1;

        int numberOfWays = 0;
        for(int step = 1; step < Math.min(maxSteps, height) + 1; step++){
            numberOfWays += getNumberOfWaysToTop(height - step, maxSteps);
        }
        return numberOfWays;
    }

    //O(n * k) time | O(n) space - where n is height and k is maxSteps
    public static int stairCaseTraversalV2(int height, int maxSteps){
        HashMap<Integer, Integer> memoize = new HashMap<Integer, Integer>();
        memoize.put(0, 1);
        memoize.put(1, 1);
        return getNumberOfWaysToTopV2(height, maxSteps, memoize);
    }

    public static int getNumberOfWaysToTopV2(int height, int maxSteps, HashMap<Integer, Integer> memoize){
       if(memoize.containsKey(height))
           return memoize.get(height);

        int numWaysToTop = 0;
        for(int step = 1; step < Math.min(height, maxSteps) + 1; step++){
            numWaysToTop += getNumberOfWaysToTopV2(height - step, maxSteps, memoize);
        }
        memoize.put(height, numWaysToTop);
        return numWaysToTop;
    }

    //O(n*k) time and O(n) space
    public static int stairCaseTraversalV3(int height, int maxSteps){
        int [] waysToTop = new int[height + 1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;

        for(int currentHeight = 2; currentHeight < height + 1; currentHeight++){
            int step = 1;
            while(step <= maxSteps && step <= currentHeight){
                waysToTop[currentHeight] = waysToTop[currentHeight] + waysToTop[currentHeight - step];
                step += 1;
            }
        }
        return waysToTop[height];
    }
}
