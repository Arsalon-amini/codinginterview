public class ValidStartingCity {
    public int validStartingCity(int [] distances, int [] fuel, int mpg){
        //O(n^2) time, O(1) space
        int numberOfCities = distances.length;

        for(int startCity = 0; startCity < numberOfCities; startCity++){
            int availableFuel = 0;
            //loop from starting city through all other cities (back to self)
            for(int currentCity = startCity; currentCity < startCity + numberOfCities; currentCity++) { //iterates all cities
                if (availableFuel < 0) continue;

                int currentCityIdx = currentCity % numberOfCities; //wraps index from ending back to beginning indices

                int gallonsAvailableAtCurrentCity = fuel[currentCityIdx];
                int distanceToNextCity = distances[currentCityIdx];
                availableFuel += gallonsAvailableAtCurrentCity * mpg - distanceToNextCity;
            }
            if(availableFuel >= 0)
                return startCity;
        }
        return -1;
    }

    public int validStartingCityV2(int [] distances, int [] fuel, int mpg){
        //O(n) time, O(1) space
        int numberOfCities = distances.length;
        int availableFuel = 0;

        int minFuelSoFar = 0;
        int minCityIdxSoFar = 0;

        for(int i = 1; i < numberOfCities; i++){
            int distanceFromPreviousCity = distances[i - 1];
            int previousCityGallons = fuel[i - 1];

            availableFuel += previousCityGallons * mpg - distanceFromPreviousCity;

            if(availableFuel < minFuelSoFar){
                minFuelSoFar = availableFuel;
                minCityIdxSoFar = i;
            }
        }
        return minCityIdxSoFar;
    }
}


