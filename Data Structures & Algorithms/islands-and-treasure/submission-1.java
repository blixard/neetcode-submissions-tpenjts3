class Solution {

    public final int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}}; 
    public HashMap <String, Integer> map = new HashMap<String, Integer>(); 
    public final int inf = Integer.MAX_VALUE; 
    public void islandsAndTreasure(int[][] grid) {
        getDistance2(grid); 
    }

    public void getDistance2 (int [][] grid){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 0){
                    bfs(grid,i,j); 
                }
            }
        }
    }

    public void bfs(int[][] grid, int r, int c){
        Queue<int [] > q = new LinkedList<>();
        q.add(new int []{r,c}); 

        while(!q.isEmpty()){
            int[] curr = q.poll(); 
            int i = curr[0]; 
            int j = curr[1]; 

            for(int[] dir : directions){
                int nr = i + dir[0]; 
                int nc = j + dir[1]; 

                if(nr < 0 || nc < 0 || nr>= grid.length || nc >= grid[0].length) continue; 
                int dist = grid[i][j] + 1;
                if(grid[nr][nc] > 0 ) {
                    if(grid[nr][nc] > dist){
                        grid[nr][nc] = dist;
                        q.add(new int [] {nr, nc}); 
                    }

                } 
            }
        }
    }


    public void getDistance (int [][] grid, int r, int c){
        Queue<int [] > q = new LinkedList<>();
        q.add(new int [] {0,0}); 
        final int inf = Integer.MAX_VALUE; 
        int min = Integer.MAX_VALUE; 
        while(!q.isEmpty()){
            int [] curr = q.poll(); 
            int i = curr[0]; 
            int j = curr[1]; 
            if(grid[i][j] == -1) continue;

            for(int [] dir: directions){
                int nr = i + dir[0]; 
                int nc = j + dir[1]; 
                if(nr <0 || nc < 0 || nr>= grid.length || nc >= grid[0].length ) continue; 

                String key = nr+ "_"+ nc; 

                if(map.containsKey(key)){
                    int temp = map.get(key);  
                     grid[r][c] = Math.min(grid[r][c], temp + 1);
                }
                else if(grid[nr][nc] == inf){
                    q.add(new int [] {nr, nc});
                }
                else if(grid[nr][nc] == 0 ){
                    grid[r][c] = 1; 
                }
                else if(grid[nr][nc] != -1){
                    grid[r][c] = Math.min(grid[r][c], grid[nr][nc] + 1);
                }
            }
            String key = r + "_" + c; 
            map.put(key, grid[r][c]); 
        }
    }
}
