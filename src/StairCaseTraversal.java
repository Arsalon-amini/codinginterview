public class StairCaseTraversal {
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
}
