package com.ncr.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    // Nice decision as once pawn created then  its color should not be changed.
    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
		int currentY = this.getYCoordinate();
		int currentX = this.getXCoordinate();
    	if (this.chessBoard.isLegalBoardPosition(newX, newY) 
    			&& this.chessBoard.isLegalBoardPosition(currentX, currentY)) {
    		// Logic for pawn move
    		if(movementType.compareTo(MovementType.MOVE) == 0) {
        		// Move for pawn with Black color
        		if (this.getPieceColor().compareTo(PieceColor.BLACK) == 0) {
        			if (currentX == newX  && (newY == currentY - 1)) {
        				this.setXCoordinate(newX);
        				this.setYCoordinate(newY);
        			}
        		} else {
        			// Move for pawn with White color
        			if (currentX == newX  && (newY == currentY + 1)) {
        				this.setXCoordinate(newX);
        				this.setYCoordinate(newY);
        			}
        		}
        		
        	}
    		// Logic for pawn Capture TODO
    	} 	
    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
