class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1 ) return 0; 
        Arrays.sort(nums);
        int res = 1; 
        int l = 1; 
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1])continue; 
            if(nums[i] - nums[i-1] == 1 )l++; 
            else l = 1; 
            if(l > res ) res = l; 
        }
        return res; 
    }
}
