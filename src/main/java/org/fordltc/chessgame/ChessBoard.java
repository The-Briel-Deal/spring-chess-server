package org.fordltc.chessgame;

public class ChessBoard {
    private static ChessBoard chessBoardInstance = null;

    public int[][] board = new int[8][8];

    ChessBoard() {
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static ChessBoard getInstance() {
        if (chessBoardInstance == null) {
            chessBoardInstance = new ChessBoard();
        }
        return chessBoardInstance;
    }
}
