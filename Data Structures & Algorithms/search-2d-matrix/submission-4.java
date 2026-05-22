class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        int rowNumber =0; 
        int l =0; 
        int r = matrix.length ; 
        System.out.println(l + " " + r);
        while(l<r){
            int m = l + ((r-l)/2);
            if(matrix[m][0] == target ) return true;
            else if(matrix[m][0] < target) l = m+1; 
            else r = m; 
        }
        if(l == 0 ) return false;
        System.out.println(l);
        rowNumber = l-1; 
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
