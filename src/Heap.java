import java.util.ArrayList;
import java.util.List;

public class Heap {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array){
            heap = buildHeap(array);
        }

        //O(n) time, O(1) space
        public List<Integer> buildHeap (List<Integer> array){
            int lastParentIdx = (array.size() - 2) / 2;
            for(int currentIdx = lastParentIdx; currentIdx >= 0; currentIdx--){
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        //O(log(n)) time | O(1) space
        public void siftUp(int currentIdx, List<Integer> heap){
            //calc parent index, compare child with parent, move up (swap), update pointers
            int parentIdx = (currentIdx - 1) / 2;
            while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)){
                swap(currentIdx, parentIdx, heap); //move value upwards
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }

        }

        //O(log (n)) time, O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap){
            //calc children indices, compare with parent, swap smallerChild w/ parent (if smaller than parent)
            int childOneIdx = currentIdx * 2 + 1;

            while(childOneIdx <= endIdx){
                int childTwoIdx =
                        currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2: -1;
                int smallerIdx;
                if(childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx))
                    smallerIdx = childTwoIdx;
                else
                    smallerIdx = childOneIdx;

                if(heap.get(smallerIdx) < heap.get(currentIdx)){
                    swap(currentIdx, smallerIdx, heap);
                    currentIdx = smallerIdx;
                    childOneIdx = currentIdx * 2 + 1;
                } else
                    return;
            }
        }

        public int peek(){
            return heap.get(0); //returns min value (root)
        }

        public int remove(){
            swap(0, heap.size() - 1, heap); //swap root with last value
            int root = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap); //bubble value into place
            return root;
        }

        public void insert(int value){
            heap.add(value);
            siftUp(heap.size() - 1, heap); //append to end of array (sift up into place)5
        }

        public void swap(int idx1, int idx2, List<Integer> heap){
            Integer temp = heap.get(idx2);
            heap.set(idx2, heap.get(idx1));
            heap.set(idx1, temp);
        }

    }
}
