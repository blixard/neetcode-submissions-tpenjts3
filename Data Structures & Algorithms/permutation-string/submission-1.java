class Solution {
    public String getPermutationCode(String s){
        int [] charCount = new int[26]; 
        for(int i=0; i<s.length(); i++){
            charCount[s.charAt(i) - 'a']++; 
        }
        String code = ""; 
        for(int i=0; i<charCount.length; i++){
            if(charCount[i] > 0)
            code+= String.valueOf(i) + "_" + String.valueOf(charCount[i])+"_"; 
        }
        return code; 
    }
    
    public boolean checkInclusion(String s1, String s2) {
        int l=0; 
        int r=s2.length()-1; 
        String s1Code = getPermutationCode(s1); 
        System.out.println(s1Code); 
        for(int i=0; i<s2.length()-s1.length()+1; i++){
            String temp = getPermutationCode(s2.substring(i, i+s1.length())); 
            System.out.println(temp); 
            if(temp.equals(s1Code)  ) return true; 
        }
        return false;
    }
}
