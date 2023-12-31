class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        for(int i=1; i <= amount; i++)
        {
            for(int coin: coins)
            {
                int subProb = i - coin;
                if(subProb < 0)
                continue;
                if(subProb == 0)
                ans[i] = 1;
                if(ans[subProb] != Integer.MAX_VALUE)
                ans[i] = Math.min(ans[i], 1 + ans[subProb]);
            }
        }
        return ans[amount] == Integer.MAX_VALUE ? -1 : ans[amount];
    }
}