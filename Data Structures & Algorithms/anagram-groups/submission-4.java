class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
        for(String str : strs){
            char [] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(map.containsKey(sortedString)){
                map.get(sortedString).add(str); 
            }
            else{
                map.put(sortedString, new ArrayList<String>()); 
                map.get(sortedString).add(str); 
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
