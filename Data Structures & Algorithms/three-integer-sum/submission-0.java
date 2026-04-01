class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(); 
        Set<List<Integer>> res = new HashSet<List<Integer>>(); 
        HashSet<String> dup = new HashSet<String>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i); 
            }
            else{
                map.put(nums[i], new HashSet<Integer> (Arrays.asList(i))); 
            }
        }
        for(int i=0; i<nums.length; i++){
            int rem = 0 - nums[i]; 
            for(int j=i+1; j<nums.length; j++){
                int xRem = rem - nums[j];
                if(map.containsKey(xRem)){
                    HashSet <Integer> set = map.get(xRem);
                    for(int k: set){
                        if (k!=j && k!= i){
                            ArrayList<Integer> re = new ArrayList<Integer>(); 
                            re.add(nums[i]); 
                            re.add(nums[j]);
                            re.add(nums[k]);
                            Collections.sort(re); 
                            String st = "";
                            for(int b: re){
                                st += String.valueOf(b); 
                            }
                            if(dup.contains(st)) continue; 
                            dup.add(st);
                            res.add(re);
                        }
                    }
                } 
            }
        }
        return new ArrayList<List<Integer>> (res);
    }
}
