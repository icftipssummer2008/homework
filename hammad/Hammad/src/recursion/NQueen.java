package recursion;

public class NQueen {
	public static void main(String[] args) {
		
		for(int i = 4; i <= 4; i++) {
			int [][] matrix = new int [i][i];
			
			if(check(matrix, 0)) {
				//printMatrix(matrix);				
			}
			else {
				System.out.format("No solution for %dx%d \n", i, i) ;
			}
		}
		
			//clearMatrix(matrix);
		System.out.println("....");
	}
	
	public static void clearMatrix(int [][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix.length; y++) {
				matrix[x][y] = 0;
			}
		}
		
	}
	public static void printMatrix(int [][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print("|" + val + " ");
			}
			System.out.println();
		}
		
		System.out.println(" ");
		System.out.println(" ");
	}
	
	public static boolean isSafe(int [][] matrix, int row, int col) {
		// Check left side.
		for(int i = 0; i < col ; i++) {
			if(matrix[row][i] == 1) {
				System.out.println("Already a queen is on left side");
				return false;
			}
		}
		
		for(int i = row, j = col; i>=0 && j >=0; i--,j-- ) {
			if(matrix[i][j] == 1) {
				System.out.println("Already a queen is on left-top side");
				return false;
			}
		}

		for(int i = row, j = col; i < matrix.length && j >=0; i++,j-- ) {
			if(matrix[i][j] == 1) {
				System.out.println("Already a queen is on left-down side");
				return false;
			}
		}
		
		return true;

	}
	
	
	public static boolean check(int [][] matrix, int col) {
		System.out.format("\ncol = %d\n", col);
		printMatrix(matrix);

		if(col >= matrix.length) {
			System.out.println("++++++++++++++++++++++++");
			printMatrix(matrix);
			System.out.println("++++++++++++++++++++++++");
			return true;
		}
		boolean isSolution = false;
		for(int r = 0; r < matrix.length; r++) {
			System.out.format("row = %d\n", r);
			if(isSafe(matrix, r, col)) {
				matrix[r][col] = 1;
				isSolution = check(matrix, col + 1) || isSolution;
				matrix[r][col] = 0;
			}
		}
		
		return isSolution;
		
	}
}
