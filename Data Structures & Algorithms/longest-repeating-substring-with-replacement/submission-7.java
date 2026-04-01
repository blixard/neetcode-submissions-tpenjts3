class Solution {
    public int getLargeSubstring(String s, int k){
        int large = 0; 
        for(int i=0; i<s.length(); i++){
            int count =1;
            int temp = k; 
            Character ch = s.charAt(i); 
            for(int j=i+1; j<s.length(); j++){
                int flag = 0; 
                System.out.println(String.valueOf(s.charAt(j)) + " " + String.valueOf(ch) ); 
                if(s.charAt(j) == ch) count++; 
                else if(temp>0 ){
                    count++; 
                    temp--; 
                    flag = 1; 
                }
                else break; 
                if(flag == 0 ){
                    ch = s.charAt(j); 
                }
                System.out.println(String.valueOf(s.charAt(j)) + " " + String.valueOf(ch) + " " + i + " " + j + " " + count );
            }
            large = Math.max(large, count); 
        }
        return large;
    }
    public int characterReplacement(String s, int k) {
        int l=0; 
        int r=1;
        int [] charCount = new int[26];  
        charCount[s.charAt(l) - 'A']++;
        charCount[s.charAt(r) - 'A']++; 
        int ans = 0; 
        while(l<=r && l<s.length() && r<s.length()){
            int largeIndex = 0;
            int sum =0;  
            for(int i=0; i<charCount.length; i++){
                if(charCount[i] > charCount[largeIndex]) largeIndex = i; 
                sum += charCount[i];
            }
            System.out.println(s + " " + s.charAt(l) + " " + s.charAt(r)); 
            System.out.println("left: " + l + " right: " + r + " ans: " + ans + " sum: " + sum + " largestCount: "+ charCount[largeIndex]); 
            if( (sum-charCount[largeIndex]) <= k ){
                ans = Math.max(ans, r-l ); 
                System.out.println("increase right: " + r);
                if(r+1<s.length()){
                    r++; 
                    charCount[s.charAt(r) - 'A']++; 
                }
                else break;
                
            }
            else{
                charCount[s.charAt(l)- 'A']--; 
                l++; 
            }
            System.out.println("ans cal: " + ans + " r: " + r + " l: " + l + " " + (r-l));    
        }
        return ans+1; 
    }
}
