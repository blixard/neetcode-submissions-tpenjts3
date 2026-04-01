class Solution:
    def createKey(s):
        charMap = [0] * 26  
        key = ''
        for char in s: 
            x = ord(char) - 97
            charMap[x]+= 1 

        for i in range(len(charMap)):
            key += chr(i) +str(charMap[i]) 
            print(key)
        return key 

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = [] 
        strMap = {}
        for s in strs: 
            sortedS = Solution.createKey(s)
            if sortedS in strMap:
                strMap[sortedS].append(s)
            else: 
                strMap[sortedS] = []
                strMap[sortedS].append(s) 
        for key in strMap: 
            ans.append(strMap[key])

        return ans




