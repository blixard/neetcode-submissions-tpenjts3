class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length; 
        Stack<Integer> stack = new Stack<Integer>(); 
        int [] res = new int [n];
        stack.push(n-1); 
        int i = n-2; 
        while(i>=0){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop(); 
            }
            if(!stack.isEmpty()) res[i] = stack.peek() -i;
            else res[i] = 0; 
            stack.push(i); 
            i--; 

        }
        return res; 
    }
}
