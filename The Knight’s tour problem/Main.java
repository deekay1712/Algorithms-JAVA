import java.util.Scanner;

public class Main {
    static int moveX[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static int moveY[] = {1, 2, 2, 1, -1, -2, -2, -1};

    static boolean isValid(int[][] board, int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 0)
            return true;
        return false;
    }

    static boolean knightsTour(int board[][], int row, int col, int move){
        if(move == board.length * board.length){
            return true;
        }
        for(int i = 0; i < 8; i++){
            int nextRow = row + moveX[i];
            int nextCol = col + moveY[i];
            if(isValid(board, nextRow, nextCol)){
                board[nextRow][nextCol] = move + 1;
                if(knightsTour(board, nextRow, nextCol, move + 1)){
                    return true;
                }
                board[nextRow][nextCol] = 0;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows or columns");
        int n = sc.nextInt();
        int board[][] = new int[n][n];
        board[0][0] = 1;
        knightsTour(board, 0, 0, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
