class Solution {
    int visited[];
   
    public int climbStairs(int n) {
       visited = new int[n+1];
       visited[0]=1;
       visited[1] =1;
       return getSolution(n);
    }

    public int getSolution(int n){
        if(n < 0){
            return 0;
        }
        else if(visited[n]!=0){
            return visited[n];
        }else {
            visited[n] = getSolution(n-1) + getSolution(n-2);
            return  visited[n];
        }
    }


}