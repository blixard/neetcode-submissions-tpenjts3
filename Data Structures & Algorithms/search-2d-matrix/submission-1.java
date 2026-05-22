class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        for(int i=0; i<matrix.length; i++){
            int l = 0; 
            int r = matrix[i].length - 1;
            while(l<=r){
                int m = l +  ((r-l)/2); 
                System.out.println(l + " " + r + " " + m);
                if(matrix[i][m] == target) return true; 
                else if(matrix[i][m] > target) r = m-1; 
                else l = m+1; 
            } 
        }
        return false; 
    }
}
