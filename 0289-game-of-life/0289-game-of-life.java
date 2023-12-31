class Solution {
    public void gameOfLife(int[][] board) {
        
        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board[x].length; y++) {
                int aliveNeighboursCount = findAliveNeighbours(board, x, y);

                if(board[x][y] == 1 && aliveNeighboursCount >= 2 && aliveNeighboursCount <=3  ) {
                    board[x][y] = 3;
                }

                if(board[x][y] == 0 && aliveNeighboursCount ==3  ) {
                    board[x][y] = 2;
                }
            }
        }

        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board[x].length; y++) {
                board[x][y] >>= 1;
            }    
        }
    }

    int findAliveNeighbours(int[][] board, int x, int y) {
        int aliveNeighboursCount = 0;
        for(int i = Math.max(x - 1, 0); i <= Math.min(x + 1, board.length - 1) ; i++) {
            for(int j = Math.max(y - 1, 0); j <= Math.min(y + 1, board[0].length - 1) ; j++) {
                aliveNeighboursCount += board[i][j] & 1;
            }
        }
        aliveNeighboursCount -= board[x][y] & 1;
        return aliveNeighboursCount;
    }
}