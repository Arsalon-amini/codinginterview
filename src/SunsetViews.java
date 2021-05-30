import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SunsetViews {

    //O(n) time and O(n) space where n is the length of the input array
    public ArrayList<Integer> sunsetViewsSol1(int [] buildings, String direction){
        ArrayList<Integer> buildingsWithSunsetViews = new ArrayList<Integer>();

        int startIdx = buildings.length - 1;
        int step = -1;

        if(direction.equals("WEST")){
            startIdx = 0;
            step = 1;
        }

        int idx = startIdx;
        int runningMaxHeight = 0;

        while(idx >= 0 && idx < buildings.length){
            int buildingHeight = buildings[idx];

            if(buildingHeight > runningMaxHeight){
                buildingsWithSunsetViews.add(idx);
                runningMaxHeight = buildingHeight;
            }

            idx += step;
        }

        if(direction.equals("EAST"))
            Collections.reverse(buildingsWithSunsetViews);

        return buildingsWithSunsetViews;
    }

    //O(n) time and O(n) space where n is the length of the input array
    public ArrayList<Integer> sunsetViews(int [] buildings, String direction){
        ArrayList<Integer> candidateBuildings = new ArrayList<Integer>();

        int startIdx = buildings.length - 1;
        int step = -1;

        if(direction.equals("EAST")){
            startIdx = 0;
            step = 1;
        }

        int idx = startIdx;
        while(idx >=0 && idx < buildings.length){
            int buildingHeight = buildings[idx];

            while(candidateBuildings.size() > 0
            && buildings[candidateBuildings.get(candidateBuildings.size() - 1)] <= buildingHeight){
                candidateBuildings.remove(candidateBuildings.size() - 1);
            }

            candidateBuildings.add(idx);
            idx += step;
        }

        if(direction.equals("WEST")){
            Collections.reverse(candidateBuildings);
        }
        return candidateBuildings;
    }
}
