import java.util.Scanner;

public class GroupSum{
  public static void main(String[] args){

  }

  public static boolean groupSum(int[] arr,int target){
      return groupSum(arr,0,target);
  }

  //Recursion, Select,UnSelect, Since we are only interested in ONE, ie if it exists,
  // return true or false to break the tree when found :)
  public static boolean groupSum(int[] arr,int start, int target){
      if(start >= arr.length) return target==0;
      return groupSum(arr,start+1,target-arr[start])
        || groupSum(arr,start+1,target);
  }

}
