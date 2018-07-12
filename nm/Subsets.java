import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets{
  public static void main(String[] args){
    int[] nums = {1,2,3};

    List<List<Integer>> result = subsets(nums);

    for(List<Integer> list:result){
            System.out.println(list);
    }
  }

  public static List<List<Integer>> subsets(int[] nums) {
    return subsets(nums,new ArrayList(), new ArrayList(),0);
  }

  // Recursion, Select UnSelect, Will Have to print ALL Subsets so no need to return true or false in the tree
  public static List<List<Integer>> subsets(int[] nums,List<List<Integer>> result,List<Integer> subset,int index ) {
    if(index >= nums.length){
      result = process(result,subset);
    }else{
      //SELECT
      subset.add(nums[index]);
      subsets(nums,result,subset,index+1);

      //UNSELECT
      subset.remove(subset.size() - 1);
      subsets(nums,result,subset,index+1);
    }
    return result;
  }

  public static List<List<Integer>> process(List<List<Integer>> result,List<Integer>subset){
    result.add(new ArrayList<>(subset));
    return result;
  }
}
