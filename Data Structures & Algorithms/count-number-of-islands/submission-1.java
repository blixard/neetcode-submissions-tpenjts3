class Solution {
    public int numIslands(char[][] grid) {
        Stack<List<Integer>> stack = new Stack<>();
        int count =0; 
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++; 
                    System.out.println("Start: " + i + " " + j ); 
                    ArrayList<Integer> arr = new ArrayList<Integer>(); 
                    arr.add(i); 
                    arr.add(j); 

                    stack.push(arr); 

                    while(!stack.isEmpty()){
                        List<Integer> temp = stack.pop(); 
                        int r = temp.get(0); 
                        int c = temp.get(1); 
                        grid[r][c] = '2'; 
                        if( r < grid.length-1 && grid[r+1][c] == '1'  ){
                            ArrayList<Integer> stemp = new ArrayList<Integer>(); 
                            stemp.add(r+1);
                            stemp.add(c); 
                            stack.push(stemp);
                        }  

                        if( c+1 < grid[0].length && grid[r][c+1] == '1'  ){
                            ArrayList<Integer> stemp = new ArrayList<Integer>(); 
                            stemp.add(r); 
                            stemp.add(c+1); 
                            stack.push(stemp);
                        }  

                        if( c-1 >=0 && grid[r][c-1] == '1'){
                            ArrayList<Integer> stemp = new ArrayList<Integer>(); 
                            stemp.add(r); 
                            stemp.add(c-1); 
                            stack.push(stemp);
                        }  

                        if( r-1 >=0 && grid[r-1][c] == '1'){
                            ArrayList<Integer> stemp = new ArrayList<Integer>(); 
                            stemp.add(r-1);
                            stemp.add(c); 
                            stack.push(stemp);
                        }  
                    }
                }
            }
        }
        return count; 
    }
}
