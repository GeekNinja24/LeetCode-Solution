class Solution {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if(heights==null||heights.length==0||heights[0].length==0) return ans;

        int row =heights.length;
        int col =heights[0].length;

        boolean[][] pacific = new boolean[row][col];
          boolean[][] atlantic = new boolean[row][col];

          //dfs

          for(int i =0;i<row;i++){
              dfs(i,0,Integer.MIN_VALUE,heights,pacific);
                dfs(i,col-1,Integer.MIN_VALUE,heights,atlantic);
          }
            

            for(int i =0;i<col;i++){
              dfs(0,i,Integer.MIN_VALUE,heights,pacific);
                dfs(row-1,i,Integer.MIN_VALUE,heights,atlantic);
          }


          for(int i=0;i<row;i++){
              for(int j =0;j<col;j++){

                 if(pacific[i][j]&&atlantic[i][j]){

                     ans.add(Arrays.asList(i,j));
                 }

              }
          }

          return ans;
    }


    public void dfs(int i,int j, int prev, int[][] heights,boolean[][]ocean){
          if(i<0||j<0||i>=heights.length||j>=heights[0].length) return;
          if(ocean[i][j]||heights[i][j]<prev){
              return;
          }
          ocean[i][j]=true;

          for(int k =0;k<dir.length;k++){
              int nr = i+dir[k][0];
              int nc =j+ dir[k][1];
             
             dfs(nr,nc,heights[i][j],heights,ocean);

          }


    }
}