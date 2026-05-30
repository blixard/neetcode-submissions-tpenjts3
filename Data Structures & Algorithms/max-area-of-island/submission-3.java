class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0; 
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0; 
                    int area = islandArea(grid, i, j); 
                    System.out.println("Area at " + i + " " + j + " is: " + area);
                    if(area > max) max = area; 
                }
            } 
        }
        return max; 
    }

    public static int islandArea(int[][] grid, int r, int c){
        int [] directions [] = {{1,0},{0,1},{-1,0},{0,-1}}; 
        Queue<int [] > q = new LinkedList<>(); 
        q.add(new int [] {r,c}); 
        int count = 1; 
        while(!q.isEmpty()){
            int [] t = q.poll(); 
            r = t[0]; 
            c = t[1]; 
            
            for(int i=0; i<directions.length; i++){
                int nr = r + directions[i][0]; 
                int nc = c + directions[i][1]; 
                if(nr < 0 || nc < 0 || nr>=grid.length || nc>=grid[0].length || grid[nr][nc] != 1) continue;    
                System.out.println(nr + " " + nc); 
                grid[nr][nc] = 0; 
                count++; 
                int [] arr = {nr, nc}; 
                q.add(arr); 
            
            }
        }
        return count; 
        
    }
}
