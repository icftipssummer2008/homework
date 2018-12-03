package dp;

public class largestSubArraySum {
   static int array[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
   //static int allNegativeArray[] =  {-2, -3, -4, -1, -2, -1, -5, -3}; 
   // if asked for -ve number sum then use the max number instead of zero
   
   public static void main(String[] args) {
	   System.out.format("Brute Force: %d\n",getSubArrayBruteForce(0, 0, array));
	   System.out.format("One Loop: %d\n",getSubArrayOneLoop(0, 0, array));
   }
   
   public static int getSubArrayBruteForce(int start, int end, int[] array) {
	   int maxSum = 0;
	   for(int i = 0; i < array.length; i++) {
		   for(int j = 0; j < array.length; j++) {
			   int sum = 0;
			   for(int k = i; k <= j; k++) {
				   sum +=  array[k];
			   }
			   if(sum > maxSum) {
				   maxSum = sum;
			   }
		   } 
	   }
	   
	   return maxSum;
   }
   
   public static int getSubArrayOneLoop(int start, int end, int[] array) {
	   int maxSum = 0;
	   int maxTemp = 0;
	   for(int i = 0; i < array.length; i++) {
		   maxTemp += array[i];
		   if(maxTemp < 0) {
			   maxTemp = 0;
		   }
		   if(maxSum < maxTemp) {
			   maxSum = maxTemp;
		   }
	   }
	   
	   return maxSum;
   }

   
}
