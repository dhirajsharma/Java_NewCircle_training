public class ChessBoard {
    private ChessPiece[][] board = new ChessPiece[8][8];

    public void setPiece(ChessPiece chessPiece, int n, int l) {
        this.board[n][l] = chessPiece;
    }

    private ChessPiece.Color getLocationColor(int n, int l) {
        return ChessPiece.Color.BLACK;
    }
}
