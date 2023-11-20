class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] shags=new int[matrix.length*matrix[0].length];
         int start=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                shags[start]=matrix[i][j];
                start++;
            }
        }
        Arrays.sort(shags);
        return shags[k-1];
    }
}