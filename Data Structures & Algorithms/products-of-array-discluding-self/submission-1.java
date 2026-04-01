class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pr= 1; 
        int [] ans = new int [nums.length];
        int flag = 0;  
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) flag++; 
            else pr *=nums[i]; 
        }
        for(int i=0; i<nums.length; i++){
            if( nums[i] == 0 && flag <2) ans[i] = pr; 
            else if ( flag >= 1  ) nums[i] = 0; 
            else ans[i] = pr / nums[i]; 
        }
        return ans; 
    }
}  
