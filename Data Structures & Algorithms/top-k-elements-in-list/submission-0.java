class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1); 
            }
            else{
                map.put(i, 1); 
            }
        }

        LinkedHashMap<Integer, Integer> sortedMap =  map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
        int [] arr = new int[k];
        int c = 0; 
        for (int key : sortedMap.keySet()){
            System.out.println(key + " " + sortedMap.get(key));
            if ( c >= k ) break;
            arr[c++] = key;
        }
        return arr;
    }
}
