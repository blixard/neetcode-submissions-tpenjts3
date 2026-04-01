class Solution {
    public boolean isPalindrome(String s) {
        int st = 0; 
        int e = s.length()-1; 
        while(st<e && st<s.length() && e>=0 ){
            System.out.println(s.charAt(st) + " " + s.charAt(e)); 
            while( st<s.length() && !Character.isLetterOrDigit(s.charAt(st)) ) st++;
            while(  e>=0 && !Character.isLetterOrDigit(s.charAt(e)) ) e--; 
            if(st < s.length() && e>=0  && Character.toLowerCase(s.charAt(st++)) != Character.toLowerCase(s.charAt(e--))) return false; 
        }
        return true;
    }
}
