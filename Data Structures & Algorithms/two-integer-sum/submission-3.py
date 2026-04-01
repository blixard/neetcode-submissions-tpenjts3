class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mapVal = {}
        for i in range( len(nums)): 
            mapVal[nums[i]] = i
        
        for i in range(len(nums)):
            if ( (target - nums[i]) in mapVal and i != mapVal.get(target - nums[i]) ): 
                return [i, mapVal.get(target-nums[i])]