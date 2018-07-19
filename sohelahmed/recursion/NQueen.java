package com.sohel.recursion;

public class NQueen {

	 final int N = 4;

    boolean solveNQ()
    {
        int board[][] = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
 
        if (solveNQUtil(board, 0) == false)
        {
            System.out.print("Solution does not exist");
            return false;
        }
 
        printSolution(board);
        return true;
    }
 
    private void printSolution(int[][] board) {
		// TODO Auto-generated method stub
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			System.out.print("|"); 
    			if (board[i][j]==1) System.out.print("Q");
    			System.out.print("|");
    		}
    		System.out.println();
    	}
	}

	private boolean solveNQUtil(int[][] board, int col) {
		// TODO Auto-generated method stub
		//base case if all queens are placed return true 
		if(col >= N) return true;
		for(int i=0; i<N; i++) {
			if (isSafe(board,i,col)) {
				board[i][col]=1; //
				if(solveNQUtil(board,col+1)==true) { // Check the queen in next column is also correct 
					return true;
				}
				board[i][col]=0; //backtrack 
			}
		}
		return false;
	}

	private boolean isSafe(int[][] board, int row, int col) {
		// TODO Auto-generated method stub
		int i, j;
		//check in the row 
		for(i=0; i<col; i++) {
			if(board[row][i] == 1) {
				return false;
			}
		}
		
		//check upper left diagonal 
		for(i=row,j=col; i>=0 && j>=0; i--,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		//check upper left diagonal 
		for(i=row,j=col; i>=0 && j<N; i--,j++) {
			if(board[i][j] == 1) {
				return false;
			}
  	    }
		return true;
	}

	// driver program to test above function
    public static void main(String args[])
    {
        NQueen Queen = new NQueen();
        Queen.solveNQ();
    }
}
	
