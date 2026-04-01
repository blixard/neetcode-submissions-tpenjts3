class Solution {
    public  int trap(int[] height) {
        int l = 0; 
        int r = 0; 
        for(int i=0; i<height.length-1; i++){
            if(height[i] > height[i+1]){
                l = i; 
                break;
            }
        }
        r = l+1;
        int sm =0; 
        int sum = 0;  
        int lmax = 0; 
        int sx =0; 
        while(l<=r && l < height.length && r<height.length){
            
            if(height[r] >= height[l]  && r-l >= 2){
                int x = height[l] * (r - l -1) ; 
                sum += x - sm;
                l = r;
                sm = 0;
             }
             else{
                if(r-l >= 2 && height[r] > height[r-1]){
                    lmax = r;
                    sx = sm; 
                }
                sm += height[r]; 
             }
             r++; 
        }
        // for(int i=l; i<height.length; i++){
        //     if(height[i] > height[i-1] && ){

        //     }
        // }
        System.out.println(l + " " + lmax + " " + sx ); 
        if(l<lmax){
            for(int i=l+1; i<height.length; i++){
                if(height[i] > height[lmax] ){
                    l = i;
                    sx -= height[i]; 
                }
            }
            sum += ((height[lmax] * (lmax-l-1)) - sx);  
        }
        return sum; 
    }
}


/*
height=[0,1,0,2,1,0,1,3,2,1,2, 1]
        0 1 2 3 4 5 6 7 8 9 10 11 

Input: height = [0,2,0,3,1,0,1,3,2,1]
                 0 1 2 3 4 5 6 7 8 9 

    lmax = 2 , 1 
    3- 2 * 2 = 2 

    if contineous nothing happens, needs to be strictly increasing 
    and must have a left max which is greater than 0 

    algorithm: 

    intialise leftMax 
    leftMax = breakpoint where array is decreasing  
    current = breakpoint where array is increasing 
    leftMax = 0; 
    int areaTillCurrent= 0; 
    //i => current
    int sum =0; 
    for(int i=0; i<height.length-1; i++){
        if(height[i+1] < height[i]){
            lmax = i; 
        }
        if(height[i+1] > height[i]){
            int current = i+1; 
            height = Math.min(leftMax, current) 
            areaTillCurrent =  (currentIndex - leftMaxIndex ) * height
            sum+= areaTillCurrent; 
        }
    } 
    return sum; 

Output: 9

height = min(leftMax, current) 
areaTillCurrent =  (currentIndex - leftMaxIndex ) * height
if current = 0 cotinue 
Sum (areaTillCurrent) for all current = 0 to n 



*/