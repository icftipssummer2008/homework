
public class GroupSum {

	public static void main(String[] args) {
		System.out.print(groupsum(new int[]{2,4,6},6,0));

	}
	
	public static boolean groupsum(int[] A, int target, int n) {
		if(n>=A.length) {
			if(target == 0) {
				return true;
			}
			else
				return false;
		}
		else
			return groupsum(A,target-A[n],n+1) || groupsum(A,target,n+1);
		
	}

}
