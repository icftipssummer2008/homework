package dp;

public class Fibonaci {
	
	final private static int[] dp = new int[100];
	
	
	public static void main(String[] args) {
		initialize();
		for(int i = 0;  i < 10; i++) {
			System.out.println(topDown(i));
		}
		
		initialize();
		
		for(int i = 0;  i < 10; i++) {
			System.out.println(bottomUp(i));
		}

		for(int i = 0;  i < 10; i++) {
			System.out.println(vanila(i));
		}
		
		
	}
	
	private static void initialize() {
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
	}
	
	public static int topDown(int i) {
		if(dp[i] == -1) {
			if(i <= 1) {
				dp[i] = i;
			}
			else {
				dp[i] = topDown(i - 1) + topDown(i - 2);
			}
		}

		return dp[i];
	}
	
	public static int bottomUp(int n) {
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		return dp[n];
	}

	public static int vanila(int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		
		for(int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
}
