class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false; 
        int [] arr = new int [26]; 
        for(Character ch: s.toCharArray()){
            arr[ch-'a']++; 
        }
        for(Character ch: t.toCharArray()){
            arr[ch-'a']--; 
        }
        for(int i: arr){
            if(i != 0) return false;
        }
        return true; 
    }
}
