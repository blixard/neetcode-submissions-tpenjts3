class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>(); 
        HashMap<Character, Character> map = new HashMap<Character, Character>(); 
        map.put('[', ']'); 
        map.put('(', ')'); 
        map.put('{', '}'); 
        stack.push(s.charAt(0)); 
        for(int i=1; i<s.length(); i++){
            if(stack.size() == 0  ) stack.push(s.charAt(i)); 
            else if( stack.size()>0 && map.containsKey(stack.peek()) && !map.containsKey(s.charAt(i))){
                if( map.get(stack.pop()) != s.charAt(i)) return false; 
            }
            else{
                stack.push(s.charAt(i)); 
            }

        }
        if(stack.size()==0 ) return true;
        return false;
    }
}
