public class ValidStartingCity {
    //O(n^2) time | O(1) space
    public static int validStartingCity(int [] distance, int [] fuel, int mpg){
        int numOfCities = distance.length;

        for(int startCityIdx = 0; startCityIdx < numOfCities; startCityIdx++){
            int milesOfFuelRemaining = 0;

            for(int currentCityIdx = startCityIdx; currentCityIdx < startCityIdx + numOfCities; currentCityIdx++){
                if(milesOfFuelRemaining < 0) continue;

                int currentCityIdxRotated = currentCityIdx % numOfCities;

                int gallonsFromCurrentCity = fuel[currentCityIdxRotated];
                int distanceToNextCity = distance[currentCityIdxRotated];
                milesOfFuelRemaining += gallonsFromCurrentCity * mpg - distanceToNextCity;

            }
            if(milesOfFuelRemaining >= 0)
                return startCityIdx;
        }
        return -1;
    }


    //O(n) time | O(1) space
    public static int validStartingCityOptimized(int[] distance, int[] fuel, int mpg) {
        int numOfCities = distance.length;
        int milesOfFuelRemaining = 0;

        int idxValidStartingCityCandidate = 0;
        int minMilesFuelRemaining = 0;

        for (int cityIdx = 1; cityIdx < numOfCities; cityIdx++) {
            int previousCityDistance = distance[cityIdx - 1];
            int gallonsFromPreviousCity = fuel[cityIdx - 1];

            milesOfFuelRemaining += gallonsFromPreviousCity * mpg - previousCityDistance;

            if (milesOfFuelRemaining < minMilesFuelRemaining)
                idxValidStartingCityCandidate = cityIdx;
        }
        return idxValidStartingCityCandidate;
    }
}


