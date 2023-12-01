class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int profit = 0;
        int firstbuy = Integer.MIN_VALUE;
        int secondbuy = Integer.MIN_VALUE;
        int fs = 0, ss = 0;
        

        for(int i = 0; i<prices.length;i++){
            firstbuy = Math.max(firstbuy, -prices[i]);
            fs = Math.max(fs, firstbuy+prices[i]);
            secondbuy = Math.max(secondbuy, fs-prices[i]);
            ss = Math.max(ss , secondbuy+prices[i]);
        }
        return ss;
     }
}
