class MinStack {
    Stack<Integer>  stack;
    public MinStack() {
        stack = new Stack<Integer>(); 
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop(); 
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE; 
        for(int i: stack){
            if(i < min) min = i; 
        }
        return min; 
    }
}
