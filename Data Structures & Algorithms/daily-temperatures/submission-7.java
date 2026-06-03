class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length; 
        int [] res = new int [n]; 
        for(int i= n-2; i>=0; i--){
            if(temperatures[i] < temperatures[i+1]){
                res[i] = 1; 
                continue; 
            }
            int prev = i+1; 
            int jump = res[prev] + i + 1;
            //System.out.println("jump "+ jump); 
            while(temperatures[i] >= temperatures[jump] ){
                if(res[jump]== 0 ) break;
                prev = jump;
                jump =  res[prev] + prev ;
                //System.out.println(i + " " + prev + " " + jump + " " +temperatures[i] + " " +  temperatures[jump]);
            }
            if(temperatures[i] < temperatures[jump ]){
                //System.out.println(i + " Jump " + jump +" "+ res[prev] );
                res[i] = res[prev] + (prev - i); 
            }
            else{
                res[i] = 0; 
            }
            //System.out.println(i + " " + jump + " " + res[i]); 
        }
        return res; 
    }
}
