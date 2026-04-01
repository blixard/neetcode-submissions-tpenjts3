class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] prefix = new int [nums.length];
        int suffix = 1; 
        prefix[0] = 1; 
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1]; 
        }
        for(int i=nums.length-1; i>=0; i--){
            prefix[i] *= suffix;
            suffix *= nums[i];  
        }
        return prefix;
    }
}  

// 1 2 4 6 
// 1 1 2  8 


