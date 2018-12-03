package dp;

public class TakeSteps {
	
	private static Integer[] dp = new Integer[100];
	
	public static void main(String[] args) {
		System.out.println(topDown(3));
		System.out.println(recursion(3));
		System.out.println(bottonUpDp(3));
	}
	
	public static int topDown(int n) {
		
		if(n < 1) {
			return 0;
		}

		if(dp[n] != null) {
			return dp[n];
		}
		
		dp[n] = 1 + topDown(n-1) + topDown(n-2) + topDown(n-3);
		
		return dp[n];
	}
	
	public static int recursion(int n) {
		
		if(n < 1) {
			return 0;
		}
		
		int sum = 1 + recursion(n-1) + recursion(n-2) + recursion(n-3);
		
		return sum;
	}
	
	public static int bottonUpDp(int n) {
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		return dp[n];
	}
}
