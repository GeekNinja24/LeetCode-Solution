class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(board[row][col] == word.charAt(0)){
                    if(exist(row, col, board, 0, word, vis)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean exist(int row, int col, char[][] board, int index, String word, int[][] vis) {
        if(index >= word.length()){
            return true;
        }

        if(row < 0 || col <0 || row >= board.length || col >= board[0].length || vis[row][col] == 1){
            return false;
        }

        if(board[row][col] != word.charAt(index)){
            return false;
        }

        vis[row][col] = 1;
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};
        for(int i=0; i<4; i++){
            int deltaRow = row + rowDir[i];
            int deltaCol = col + colDir[i];
            if(exist(deltaRow, deltaCol, board, index+1, word, vis)){
                return true;
            }
        }

        vis[row][col] = 0;
        return false;
    }
}