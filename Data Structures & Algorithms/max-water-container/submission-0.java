class Solution {
    public int maxArea(int[] heights) {
        //formula to get the amount of water - 
        // Math.min(heights[l], heights[r]) * (r - l) 
        //Brute force approach would be to check all l,r combinations
        int res = -1;  
        for(int l=0; l<heights.length; l++){
            for(int r=l+1; r<heights.length; r++){
                int q = Math.min(heights[l], heights[r]) * (r-l);
                if(q>res) res = q; 
            }
        }
        return res;
    }
}
