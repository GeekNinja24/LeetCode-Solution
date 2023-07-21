class Solution {
    class Subseq{
        int len;
        int count;

        Subseq(int len, int count){
            this.len = len;
            this.count = count;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        Subseq[] dp = new Subseq[n];

        int maxLen = 0;
        int maxLenCount = 0;

        for(int i = n - 1; i >= 0; i--){
            int len = 1;
            int count = 1;

            for(int j = i + 1; j < n; j++){
                if(nums[j] > nums[i]){
                    if((1 + dp[j].len) > len){
                        len = 1 + dp[j].len;
                        count = dp[j].count;
                    }
                    else if((1 + dp[j].len) == len){
                        count += dp[j].count;
                    }
                }
            }

            dp[i] = new Subseq(len, count);
     
            if(len > maxLen){
                maxLen = len;
                maxLenCount = count;
            }
            else if(len == maxLen){
                maxLenCount += count;
            }
        }

        return maxLenCount;
    }
}