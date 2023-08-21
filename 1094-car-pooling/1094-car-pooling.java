class Solution {
   public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        
        for(int[] trip : trips){
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        
        int passengerCount = 0;
        for(int val: stops){
            passengerCount += val;
            if(passengerCount > capacity){
                return false;
            }
        }
        
        return true;
    }
}