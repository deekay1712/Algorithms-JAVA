import java.util.Scanner;

public class Main {
    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        for (i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }
        return true;

    }
    static boolean nQueen(int board[][], int row){
        if (row==board.length){
            return true;
        }
        for (int col=0; col<board.length; col++){
            if (isSafe(board, row, col)){
                board[row][col] = 1;
                if (nQueen(board, row+1)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows or columns");
        int n = sc.nextInt();
        int board[][] = new int[n][n];
        if (nQueen(board, 0)){
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Solution does not exist");
        }
        sc.close();
    }
}
