"""
Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem,
you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array, our convention is
to consider the part of the array starting at index start and continuing to the end of the array. The caller can specify
the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.
groupSum(0, [2, 4, 8], 10) → true
groupSum(0, [2, 4, 8], 14) → true
groupSum(0, [2, 4, 8], 9) → false
The calculation is done by selecting each value of the array and in one case subtracting it from “target”, while in the other leaving “target” unchanged(backtrack - deselecting).
Thus, all possible combinations will eventually be checked for true path.
Finally, the method returns “true” once one of the results is “true”, which is a property of short-circuit evaluation of logical disjunctions.
"""
def groupSum(st,nums,target):
    if st>=len(nums):
        return target==0
    elif groupSum(st+1,nums,target-nums[st]):
        return True
    elif groupSum(st+1,nums,target): #Checking for backtracking use case
        return True
    return False
def groupSum2(st,nums,target): #other way to do
    if st>=len(nums):
        return target==0 #when u reach end of array make sure target ==0 i.e to meet target case
    return groupSum2(st + 1, nums, target - nums[st]) or groupSum2(st + 1, nums, target) #check with actual or backtracked i.e chosen that val or unchosen(keeping target same)
print groupSum(0, [2, 4, 8], 10)
print groupSum(0, [2, 4, 8], 14)
print groupSum(0, [2, 4, 8], 9)