class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=0)return 0; 
        int max = 1; 
        int l = 0; 
        int r = 1; 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(l), l); 
        int count = 1; 
        while( l<s.length() && r < s.length()){
            System.out.println(r+ " " + s.charAt(r) + " count: " + count);
            if( !map.containsKey(s.charAt(r))){ 
                count++; 
                System.out.println(s.charAt(l) + " " + s.charAt(r) + count);
                map.put(s.charAt(r), r); 
                r++;
                // if(r == s.length() && count!=1 ) count++;
                max = Math.max(count, max); 
            }
            else{
                l = map.get(s.charAt(r)) + 1 ; 
                map = new HashMap<Character, Integer>(); 
                map.put(s.charAt(l), l);              
                r= l+1; 
                count = 1; 
            }
        }
        return max; 
    }
}
