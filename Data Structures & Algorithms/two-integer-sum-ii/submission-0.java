class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2]; 
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(); 
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(numbers[i])){
                map.get(numbers[i]).add(i); 
            }
            else{
                map.put(numbers[i], new HashSet<Integer> (Arrays.asList(i))); 
            }
        }
        for(int i=0; i<numbers.length; i++){
            int rem = target - numbers[i]; 
            if(map.containsKey(rem)){
                HashSet<Integer> set = map.get(rem);
                for(int j: set){
                    if(j> i ){
                        res[0] = i+1; 
                        res[1] = j+1; 
                        System.out.println("yoo");
                        return res;
                    }
                } 
            }
        }
        return res; 
    }
}
