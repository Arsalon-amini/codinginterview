public class HasSingleCycle {
    //O(n) time where n is length of input array
    //O(1) space
    //
    public static boolean hasSingleCycle(int [] array){
        int numElementsVisited = 0;
        int currentIdx = 0;
        while(numElementsVisited < array.length){
            if(numElementsVisited > 0 && currentIdx == 0) return false; //has an cycle independent
            numElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0; //did we make it back to the start (has a loop)
    }

    public static int getNextIdx(int currentIdx, int[] array){
        int jump = array[currentIdx];
        int nextIdx = (currentIdx + jump) % array.length; //when hits array bounds, idx wraps around
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }
}
