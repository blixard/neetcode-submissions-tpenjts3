class Solution {
    public  int trap(int[] height) {
 int l = 0; 
        int r = 0; 
        int flag = 0;
        for(int i=0; i<height.length-1; i++){
            if(height[i] > height[i+1]){
                l = i; 
                flag = 1; 
                break;
            }
        }
        if(flag == 0 ) return 0; 
        r = l+1;
        int sm =0; 
        int sum = 0;  
        while(l<=r && l < height.length && r<height.length){
            if(height[r] >= height[r-1]  && r-l >= 2){
                int x = r;
                int sy = 0; 
                while(x < height.length ){
                    if(height[r] > height[l]) break; 
                    if( height[r] < height[x]){
                        sm += sy; 
                        sy = 0; 
                        r = x; 
                    }
                    sy += height[x];
                    x++;
                }
                for(int i=l+1; i<r; i++){
                    if(height[i] > height[r] ){
                        l = i;
                        sm -= height[i]; 
                    }
                }
                int y = Math.min(height[l], height[r]) * (r - l -1); 
                sum += y - sm;
                while(r+1 < height.length && height[r+1] >= height[r]){
                    r++;
                }
                l = r;
                sm = 0;
             }
             else{
                sm += height[r]; 
             }
             r++; 
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