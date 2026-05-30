class Solution {
    public HashMap<Integer, Integer> map = new HashMap<>(); 
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(0, cost), dfs(1, cost));
    }

    public int dfs(int i, int[] cost){
        if(i >= cost.length-2 ) return cost[i];
        int x= 0;
        int y = 0; 
        if(map.containsKey(i+1 )){
            x = map.get(i+1); 
        }
        else{
            x = dfs(i+1, cost); 
        }

        if(map.containsKey(i+2 )){
            y = map.get(i+2); 
        }
        else{
            y = dfs(i+2, cost); 
        }

        map.put(i, cost[i]+ Math.min(x,y)); 
        return cost[i]+ Math.min(x,y);   
    }
}
