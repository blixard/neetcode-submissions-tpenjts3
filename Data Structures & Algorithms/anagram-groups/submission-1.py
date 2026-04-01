class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = [] 
        strMap = {}
        for s in strs: 
            sortedS = ''.join(sorted(s))
            if sortedS in strMap:
                strMap[sortedS].append(s)
            else: 
                strMap[sortedS] = []
                strMap[sortedS].append(s) 
        for key in strMap: 
            ans.append(strMap[key])

        return ans