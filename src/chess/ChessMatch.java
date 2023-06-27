package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        //Cria o tabuleiro
        board = new Board(8,8);
        initialSetup();
    };

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++){
            for (int j=0; j<board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece,new ChessPosition(column,row).toPosition());
    }

    // Iniciar a partida colocando as peças no tabuleiro
    private void initialSetup(){
        placeNewPiece('b',6, new Rook(board,Color.WHITE));
        placeNewPiece('e',8,new King(board,Color.BLACK));
        placeNewPiece('e',1,new King(board,Color.BLACK));

    }

}
