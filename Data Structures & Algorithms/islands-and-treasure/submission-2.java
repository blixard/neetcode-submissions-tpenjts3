class Solution {

    public final int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}}; 
    public final int inf = Integer.MAX_VALUE; 
    public void islandsAndTreasure(int[][] grid) {
        getDistance2(grid); 
    }

    public void getDistance2 (int [][] grid){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j); 
                }
            }
        }
    }

    public void dfs(int [][] grid, int r, int c){
        for(int[] dir: directions){
            int nr = dir[0] + r; 
            int nc = dir[1] + c; 
            if(nr < 0 || nc < 0 || nr>= grid.length || nc >= grid[0].length) continue; 

            if(grid[nr][nc] > 0 && grid[nr][nc] > (grid[r][c] + 1)){
                grid[nr][nc] = grid[r][c] + 1; 
                dfs(grid, nr, nc);
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
}
