class Solution {
    public int rob(int[] nums) {
        int sum1=0; 
        if(nums.length==3){
            return Math.max(nums[0] + nums[2], nums[1]); 
        }
        else if(nums.length == 2){
            return Math.max(nums[0], nums[1]); 
        }
        else if(nums.length<=1) return nums[0]; 
        nums[nums.length-3] = nums[nums.length-3] + nums[nums.length-1]; 
        for(int i=nums.length-4; i>=0 ; i--){
            nums[i] = nums[i] + Math.max(nums[i+2], nums[i+3]); 
        }

        return Math.max(nums[0], nums[1]); 
    }
}
