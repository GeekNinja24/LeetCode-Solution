class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int arraySum = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            arraySum = arraySum + nums[i];
        }

        sum = (n*(n+1))/2;

        return sum - arraySum;
    }
}