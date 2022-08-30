package org.fordltc.chessgame;

public class ChessBoard {
    private static ChessBoard chessBoardInstance = null;

    public int[][] board = new int[8][8];

    ChessBoard() {
        // Defaulting all spots to empty
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                board[i][j] = 0;
            }
        }

        // Setting blacks pawns
        for (int i = 0; i<8; i++) {
            board[i][1] = 1;
        }

        //Setting white pawns
        for (int i = 0; i<8; i++) {
            board[i][6] = 7;
        }

        // Manually placing the rest of the pieces
        board[0][0] = 2;
        board[7][0] = 2;
        board[1][0] = 3;
        board[6][0] = 3;
        board[2][0] = 4;
        board[5][0] = 4;
        board[4][0] = 5;
        board[3][0] = 6;

        board[0][7] = 8;
        board[7][7] = 8;
        board[1][7] = 9;
        board[6][7] = 9;
        board[2][7] = 10;
        board[5][7] = 10;
        board[4][7] = 11;
        board[3][7] = 12;
    }

    public static ChessBoard getInstance() {
        if (chessBoardInstance == null) {
            chessBoardInstance = new ChessBoard();
        }
        return chessBoardInstance;
    }
}
