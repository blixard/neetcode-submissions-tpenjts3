class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
        for(Character ch : s.toCharArray()){
            if(map.containsKey(ch)) map.put(ch, map.get(ch) + 1); 
            else map.put(ch,1); 
        }
        for(Character ch : t.toCharArray()){
            if (map.containsKey(ch)) map.put(ch, map.get(ch) + -1); 
            else return false; 
        }

        for(Character ch : map.keySet()){
            if(map.get(ch) != 0) return false;
        } 

        return true; 
    }
}
