class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        int l =0; 
        int r = matrix.length ; 
        while(l<r){
            int m = l + ((r-l)/2);
            if(matrix[m][0] == target ) return true;
            else if(matrix[m][0] < target) l = m+1; 
            else r = m; 
        }
        if(l == 0 ) return false;
        int rowNumber = l-1; 
        l =0; 
        r = matrix[rowNumber].length; 
        while(l<= r ){
            int m = l + ((r-l)/2); 
            if(m >= matrix[rowNumber].length) return false; 
            if(matrix[rowNumber][m] == target) return true; 
            else if(matrix[rowNumber][m] < target) l = m+1; 
            else r = m-1; 
        }
        return false; 
    }
}
