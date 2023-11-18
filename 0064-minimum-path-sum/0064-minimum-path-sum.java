class Solution {
    public int helper(int grid[][] ,int i, int j,int[][] dp){
        if( i == 0 && j == 0){
            return grid[0][0];
        }
        if(i<0 || j <0){
            return (int)1000000009;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + helper(grid,i-1,j,dp);
        int left = grid[i][j] + helper(grid,i,j-1,dp);
        return dp[i][j] = Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int dp[][]= new int[grid.length][grid[0].length];
        for( int i =0;i<grid.length;i++){
            for( int j=0;j<grid[0].length;j++){
                dp[i][j] =  -1;
            }
        }
        return helper(grid,grid.length-1,grid[0].length-1,dp);
    }
}