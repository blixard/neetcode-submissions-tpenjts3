class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1; 
        for(int i=0; i< piles.length; i++){
            if(piles[i] > max) max = piles[i]; 
        }
        int l = 1; 
        int r = max;
        int ans = max; 
        while(l<=r){
            int i = l+ ((r-l)/2); 
            long sum = 0; 
            for(int p : piles){
                if(p%i != 0){
                    sum += (p/i) + 1;  
                }
                else sum+= p/i; 
            }
            if(sum <= h) {
                ans = Math.min(ans, i);
                r = i -1;  
            }
            else{
                l = i+1; 
            }
        } 
        // for(int i=1; i<=max;  i++){
        //     long sum = 0; 
        //     for(int p : piles){
        //         if(p%i != 0){
        //             sum += (p/i) + 1;  
        //         }
        //         else sum+= p/i; 
        //     }
        //     if(sum <= h) return i; 
        // }
        return ans; 
    }
}
