class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        chCount = {}
        for ch in s: 
            if ch in chCount:
                chCount[ch] += 1
            else: 
                chCount[ch] = 1  

        for ch in t: 
            if ch in chCount:
                chCount[ch] -=1 
            else: 
                return False

        for i in chCount: 
            if chCount[i] != 0: 
                return False 
        return True