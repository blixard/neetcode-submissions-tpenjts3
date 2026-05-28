class Solution {
    public int uniquePaths(int m, int n) {
        int [][] mat = new int [m][n];
        if(m == 1 && n == 1) return 1; 
        mat[m-1][n-1] = 1; 
        return countPaths(0,0, mat );   
    }

    public static int countPaths(int i, int j, int [][] mat){
        int count =0; 
        if(i<mat.length-1){
            if(mat[i+1][j] != 0 ){
                count += mat[i+1][j]; 
            } 
            else{
                count += countPaths(i+1, j,mat);
            }
        
        }
        if(j<mat[i].length-1){
            if(mat[i][j+1] != 0 ){
                count += mat[i][j+1];  
            } 
            else{
                count += countPaths(i, j+1, mat);
            }
        }
        mat[i][j] = count; 
        return count; 
    }
}