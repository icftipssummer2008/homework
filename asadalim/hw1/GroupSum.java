/**
 * Created by asad.alim on 7/6/18.
 */
public class GroupSum {
    public boolean groupSum(int[] nums,int target) {
        return groupSumHelper(0,nums,target);
    }

    public boolean groupSumHelper(int start,int[] nums,int target) {
        if (start >= nums.length ) return (target == 0);

        // Select
        if ( groupSumHelper(start+1,nums,target-nums[start] )) return true;

        // Not Select
        if ( groupSumHelper(start+1,nums,target)) return true;
        return false;
    }

    public static void main(String[] args) {
        GroupSum app = new GroupSum();
        System.out.println(app.groupSum(new int[]{2,4,6,8,3},9));
    }
}

