class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        countMap = {}; 
        for i in nums: 
            if i in countMap: 
                return True 
            else: 
                countMap[i] = 1 

        return False
        