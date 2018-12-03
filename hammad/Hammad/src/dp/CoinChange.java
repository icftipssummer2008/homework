package dp;

import java.util.Arrays;

public class CoinChange {
	private static int iterations = 0;
	private static Integer[] dp = new Integer[50];
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		
		System.out.println(coinChange(coins, 12));
		System.out.format("No of iterations: %d\n", iterations);
		
		iterations = 0;
		
		System.out.println(coinChangeTopDown(coins, 12));
		System.out.format("No of iterations: %d", iterations);

		
		System.out.println("\n abc: " + coinChangeBottomUp(coins, 12));
	}
	
	
	public static int coinChangeBottomUp(int[] coins, int amount) {
		
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		
		Arrays.fill(dp, max);
		dp[0] = 0;
		
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if(coin <= i) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		
		return dp[amount] > amount ? -1 : dp[amount];
		
	}
	
	
    public static int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    	
    }

    public static int coinChangeTopDown(int[] coins, int amount) {
    	return coinChangeTopDown(0, coins, amount);
    	
    }
    public static int coinChangeTopDown(int idx, int[] coins, int amount) {
    	
    	iterations ++;
    	
    	//System.out.println(Arrays.toString( dp));
    	
    	if(dp[amount] != null) {
    		//System.out.println(dp[amount]);
    		return dp[amount];
    	}
    	
    	if(amount == 0) {
    		return amount;
    	}
    	
    	if(idx < coins.length) {
    		int minCoins = Integer.MAX_VALUE;
    		int noOfCoins = amount / coins[idx];
    		
    		for(int i = 0; i <= noOfCoins; i++) {
    			int result = coinChangeTopDown(idx + 1, coins, amount - i * coins[idx]);
    			if(result != -1) {
    				minCoins = Math.min(minCoins, result + i);
    	    		if(dp[amount] == null) {
    	    			dp[amount] = minCoins;
    	    		}
    			}
    		}
    		int finalResult = minCoins == Integer.MAX_VALUE ? -1: minCoins;
    		

    		
    		
    		
			return finalResult;
    	}
    	
    	return -1;

    }

    public static int coinChange(int idx, int[] coins, int amount) {
    	
    	iterations ++;
    	if(amount == 0) {
    		return amount;
    	}
    	
    	if(idx < coins.length) {
    		int minCoins = Integer.MAX_VALUE;
    		int noOfCoins = amount / coins[idx];
    		
    		for(int i = 0; i <= noOfCoins; i++) {
    			int result = coinChange(idx + 1, coins, amount - i * coins[idx]);
    			if(result != -1) {
    				minCoins = Math.min(minCoins, result + i);
    			}
    		}
    		return minCoins == Integer.MAX_VALUE ? -1: minCoins;
    	}
    	
    	return -1;
    	
    }

    
    
    
    
    
    
    
    
    
    
    
     
    public static int coinChangeB(int idx, int[] coins, int amount) {
    	
    	if(amount == 0) {
    		return 0;
    	}
    	
    	if(idx < coins.length) {
    		int  maxVal = amount/coins[idx];
    		int  minCost = Integer.MAX_VALUE;
    		
    		for(int i = 0; i <= maxVal; i++) {
    			if(amount >= i * coins[idx]) {
    				int result = coinChange(idx + 1,  coins, amount - i * coins[idx]);
    				if(result != -1) {
    					minCost = Math.min(minCost, result + i);
    				}
    			}
    		}
    		
    		return (minCost == Integer.MAX_VALUE ? -1: minCost);
    	}
    	
    	return -1;
    	
    }
}