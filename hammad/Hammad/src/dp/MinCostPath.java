package dp;

public class MinCostPath {
	
	public static void main(String[] args) {
		int[][] twoDimentionalMatrix =  { 
											{1,2,3},
											{4,8,2},
											{1,5,3}
										};
		
		int minCost = minCost(2, 2, twoDimentionalMatrix);
		
		System.out.println(minCost);
				
	}
	
	public static int min(int a, int b, int c) {
		if(a > b) {
			return b > c ? c : b;
		}
		else {
			return a > c ? c : a;
		}
	}
	
	public static int minCost(int row, int col, int[][] arr) {
		if(row < 0 || col < 0) {
			return Integer.MAX_VALUE;
		}
		
		if(row == 0 && col == 0) {
			return arr[row][col];
		}
		
		int left =  minCost(row, col - 1, arr);
		int top =   minCost(row - 1, col, arr);
		int topLeft =  minCost(row - 1, col - 1, arr);
		
		return min(left, top, topLeft) + arr[row][col];
		
	}
	
	public static int minCostDP(int row, int col, int[][] arr) {
		int dp[][] = new int[row + 1][col + 1];
		
		dp[0][0] = arr[0][0];
		
		for(int r = 1; r <= row; r++) {
			dp[r][0] = dp[r-1][0] + arr[r][0];
		}
		
		for(int c = 1; c <= col; c++) {
			dp[0][c] = dp[0][c-1] + arr[0][c];
		}
		
		for(int r = 1; r <= row; r++) {
			for(int c = 1; c <= col; c++) {
				dp[r][c] = min(dp[r-1][c], dp[r-1][c-1], dp[r][c-1]) + arr[r][c];
			}
		}
		
		return dp[row][col];

	}

}
