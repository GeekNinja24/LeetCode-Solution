class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 1; i < m; i++){
            if(dp[i - 1][0] == Integer.MAX_VALUE || obstacleGrid[i][0] == 1){
                dp[i][0] = Integer.MAX_VALUE;
            }
            else{
                dp[i][0] = 1;
            }
        }
        for(int j = 1; j < n; j++){
            if(dp[0][j - 1] == Integer.MAX_VALUE || obstacleGrid[0][j] == 1){
                dp[0][j] = Integer.MAX_VALUE;
            }
            else{
                dp[0][j] = 1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0){
                    if(dp[i - 1][j] == Integer.MAX_VALUE || dp[i][j - 1] == Integer.MAX_VALUE){
                        dp[i][j] = dp[i - 1][j] == Integer.MAX_VALUE ? dp[i][j - 1] : dp[i - 1][j];
                    }
                    else{
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }                    
                }
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return dp[m - 1][n - 1] == Integer.MAX_VALUE ? 0 : dp[m - 1][n - 1];
    }
}