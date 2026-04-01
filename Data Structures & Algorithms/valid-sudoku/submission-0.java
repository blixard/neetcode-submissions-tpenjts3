class Solution {
    public boolean isValidSudoku(char[][] board) {
        //rows check 
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[i].length-1; j++){
                for(int k=j+1; k<board[i].length; k++){
                    if(board[i][j] == '.' || board[i][k] == '.') continue; 
                    System.out.println(i + " " + j + " " + k + " "+ board[j][i]);
                    if(board[i][j] == board[i][k]) return false; 
                }
            }
        }

        //cols check
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[i].length-1; j++){
                for(int k=j+1; k<board[i].length; k++){
                    if(board[j][i] == '.' || board[k][i] == '.') continue; 
                    System.out.println(i + " " + j + " " + k + " "+ board[j][i]);
                    if(board[j][i] == board[k][i]) return false; 
                }
            }
        }

        //9 blocks check 
        HashMap<String, List<Character>> map = new HashMap<String, List<Character>>(); 

        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == '.' ) continue; 
                String q = ""; 
                if(i<3){
                    if(j<3)q = "q1"; 
                    else if(j< 6) q = "q2";
                    else if(j<9) q = "q3"; 
                }
                else if(i<6){
                    if(j<3) q= "q4"; 
                    else if(j<6) q = "q5"; 
                    else if(j<9) q = "q6"; 
                }
                else if( i<9 ){
                    if(j<3) q= "q7"; 
                    else if(j<6) q = "q8"; 
                    else if(j<9) q = "q9"; 
                }
                if(map.containsKey(q)){
                    if(map.get(q).contains(board[i][j])) return false; 
                    else map.get(q).add(board[i][j]); 
                }
                else{
                    map.put(q, new ArrayList<Character> (Arrays.asList(board[i][j]) ));
                }
            }
        }
        

        return true;
    }
}



// 00 01 02 03 04 05 06 07 08 
// 10 11 12 13 14 15 16 17 18 
// 20 21 22 23 24 25 26 27 28 
// 30 31 32 33 34 35 36 37 38 
// 40 41 42 43 44 45 46 47 48 
// 50 51 52 53 54 55 56 57 58 
// 60 61 62 63 64 65 66 67 68 
// 70 71 72 73 74 75 76 77 78 
// 80 81 82 83 84 85 86 87 88 

// 0 1 2 3 4 5 6 7 8 
// 1 2 3 4 5 6 7 8 9 
// 2 3 4 5 6 7 8 9 10

// if i < 3 && j <3 q1 
// if i < 3 && j < 6 q2 
// if i < 3 && j < 9 q3 

// if i< 6 && j < 3 q4 
// i<6 j < 6 
// i<6 j < 9
