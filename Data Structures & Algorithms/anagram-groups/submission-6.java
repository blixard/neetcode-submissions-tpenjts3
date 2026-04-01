class Solution {

    class Key{
        public static int [] freq;
        public Key(int [] freq){
            this.freq = freq;
        }

        public boolean equals(Object o){
            return Arrays.equals( freq, ((Key)o).freq ); 
        }

        public int hashCode(){
            return Arrays.hashCode(freq); 
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Key, List<String>> map = new HashMap<>(); 
        for(String s : strs){
            int [] count = new int[26]; 
            for(char ch : s.toCharArray()){
                count[ch-'a']++; 
            }
            Key k = new Key(count); 
            if(map.containsKey(k)){
                map.get(k).add(s); 
            }
            else{
                map.put(k, new ArrayList<String>()); 
                map.get(k).add(s); 
            }
        }
        return new ArrayList<>(map.values()); 
    }
}
