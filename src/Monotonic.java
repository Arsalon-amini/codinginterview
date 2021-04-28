public class Monotonic {

    //O(n) time, O(1) space
    public static boolean isMonotonic(int[] array) {
        if (array.length <= 2) return true;

        var direction = array[1] - array[0]; //calc initial direction (+ | -)
        for (int i = 2; i < array.length; i++) {
            if (direction == 0) { //current = previous
                direction = array[i] - array[i - 1]; //calc new direction
                continue;
            }
            if (breaksDirection(direction, array[i - 1], array[i])) return false;
        }
        return true;
    }

    public static boolean breaksDirection(int direction, int previous, int current) {
        var difference = current - previous; //( diff > 0 [non-decreasing] | diff < 0 [non-increasing] )
        if (direction > 0) return difference < 0; //direction was up, trend is breaking (going down)
        return difference > 0;
    }

    public boolean isMonotonicV2(int[] array) {
        var isNonIncreasing = true;
        var isNonDecreasing = true;


        for (int i = 1; i < array.length; i++) {
            var current = array[i];
            var previous = array[i - 1];
            if (current > previous) isNonIncreasing = false; //it is increasing
            if (current < previous) isNonDecreasing = false; //it is decreasing
        }
        return isNonIncreasing || isNonDecreasing; //if it's increasing or decreasing it's not monotonic
    }
}
