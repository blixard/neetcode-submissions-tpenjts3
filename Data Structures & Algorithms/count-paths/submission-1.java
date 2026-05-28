class Solution {
    public int uniquePaths(int m, int n) {
        int [][] mat = new int [m][n];
        if(m == 1 && n == 1) return 1; 
        mat[m-1][n-1] = 1; 


        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i == m-1 || j==n-1)mat[i][j] = 1;
                else 
                mat[i][j] = mat[i+1][j] + mat[i][j+1];  
            }
        }
        return mat[0][0];
    }
}