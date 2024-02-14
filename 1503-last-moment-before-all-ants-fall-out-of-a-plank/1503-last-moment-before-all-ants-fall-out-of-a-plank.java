class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        //Write code here
        int lastMoment = 0; 

        // Ants traveling left
        for (int position : left) {
            lastMoment = Math.max(lastMoment, position);  
        }

        // Ants traveling right
        for (int position : right) {
            lastMoment = Math.max(lastMoment, n - position); 
        }

        return lastMoment;
    }
}