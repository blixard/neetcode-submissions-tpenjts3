class Solution {
    public int evalRPN(String[] tokens) {
        String operators = "+-*/"; 
        Stack<Integer> stack = new Stack<Integer>(); 
        for(String i: tokens){
            if(operators.contains(i)){
                int x = stack.pop(); 
                int y = stack.pop(); 
                if(i.equals("+") ){
                    int z = x + y; 
                    stack.push(z); 
                }
                else if(i.equals("*")){
                    int z = x * y; 
                    stack.push(z); 
                }
                else if(i.equals("-")){
                    int z = y - x; 
                    stack.push(z); 
                }else if(i.equals("/")){
                    int z = y/x; 
                    stack.push(z); 
                }
            }
            else{
                stack.push(Integer.valueOf(i)); 
            }
        }
        return stack.pop(); 

    }
}
