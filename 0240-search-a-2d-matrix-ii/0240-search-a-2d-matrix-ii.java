class Solution {
    public boolean rowSearch(int mat[][], int row, int left, int right, int target)
    {
      if(left>right)
      return false;
      if(left<=right)
      {
        int mid = (left+right)/2;
        if(mat[row][mid]==target)
        return true; 
        else if(mat[row][mid]>target) 
        return rowSearch(mat, row, left, mid-1, target);
        else
        return rowSearch(mat, row, mid+1, right, target); 
      }
      return false;
    }

    public boolean colSearch(int mat[][], int col, int left, int right, int target )
    {
     if(left>right)
     return false; 
     if(left<=right)
     {
      int mid = (left+right)/2;
      if(mat[mid][col]==target)
      return true; 
      else if(mat[mid][col]>target)
      return colSearch(mat, col, left, mid-1, target);
      else
      return colSearch(mat, col, mid+1, right, target);
     }
     return false; 
    }

    public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length; 
    int row = 0; 
    int col = 0; 
    
    while(row<m && col<n)
    {
      if(rowSearch(matrix, row, col, n-1, target)==true || colSearch(matrix, col, row, m-1, target)==true ) 
      return true; 
      row++; 
      col++;  
    }

    return false; 


        
    }
}