public class Solution {

    public static boolean issafe(char board [][], int row, int column){
        // vertical Attacking checking 

        for(int i=row-1; i>=0; i--){
            if(board[i][column]=='Q'){
                return false;
            }
        }

        // daigonal left side attatcking check karen 
        for(int i=row-1, j=column-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // diagonal right sode atacing check karna 
        
        for(int i=row-1, j=column+1; i>=0 && j<board.length; i--, j++){
            if( board[i][j] == 'Q'){
                return false;
            }
        }
        return true;


    }
    public static void nQueen(char board[][], int row){
        if(row == board.length){
            printBoard(board);
            return;
        }
        //column loop
        for(int j=0; j<board.length; j++){
            if(issafe(board,row, j)){
                board[row][j] = 'Q';
                nQueen(board, row+1); // Function Call
                board[row][j]='X'; // Backtracking Step
            }
            
        }
    }

    public static void printBoard(char [][] board){
        System.out.println("------  Chess Board  ----------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+"        ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4; 
        char board[] [] = new  char[n][n];

        //intialize
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'X';
            }
        }
        nQueen(board,0);
    }
}
