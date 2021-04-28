import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {
    //O(n log n) time - sorting twice 2(nlogn) + n ~= 3(nlogn) = O(n logn) time
    //O(1) space
    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights){
        Collections.sort(redShirtHeights, Collections.reverseOrder()); //tallest to shortest
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        String firstRowShirtColor =
                (redShirtHeights.get(0) < blueShirtHeights.get(0)) ? "RED" : "BLUE";
        for(int i = 0; i < redShirtHeights.size(); i++){
            int redShirtHeight = redShirtHeights.get(i);
            int blueShirtHeight = blueShirtHeights.get(i);

            if(firstRowShirtColor == "RED"){
                if(redShirtHeight >= blueShirtHeight) return false; //invalid state
            } else {
                if(blueShirtHeight >= redShirtHeight) return false; //blue cannot be in front row and taller than red
            }
        }
        return true;
    }
}
