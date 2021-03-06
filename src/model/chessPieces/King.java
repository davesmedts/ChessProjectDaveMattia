package model.chessPieces;

import model.Board;
import model.Color;
import model.Player;
import model.Square;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private boolean isChecked;
    private boolean isCheckmate;
    private boolean HasCastled;

    public King(Color color, Square startPosition) {
        super(color, startPosition);
        this.isChecked = false;
        this.isCheckmate = false;
        HasCastled = false;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public boolean isCheckmate() {
        return isCheckmate;
    }

    public boolean isHasCastled() {
        return HasCastled;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }


    public void setCheckmate(boolean checkmate) {
        isCheckmate = checkmate;
    }

    public void setHasCastled(boolean hasCastled) {
        HasCastled = hasCastled;
    }

    @Override
    public List<Square> getValidMoves(Board gameBoard, Player opponent) {
        List<Square> possibleSquares = new ArrayList<>();

        if (super.getPosition() == null) {
            return possibleSquares;
        }

//        get the current row and column of the piece that has to move
        char column = super.getPosition().getColumnLetter();
        int row = super.getPosition().getRowNumber();

//        a King can move in any direction but is limited to the square next to it.
//        north
        if (row + 1 <= 8) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = column;
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        south
        if (row - 1 >= 1) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = column;
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        west
        if (column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row;
            char newColumn = (char) (column - 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        east
        if (column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row;
            char newColumn = (char) (column + 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        north-east
        if (row + 1 <= 8 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = (char) (column + 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        south-east
        if (row - 1 >= 1 && column + 1 < 65 + 8) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = (char) (column + 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        north-west
        if (row + 1 <= 8 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row + 1;
            char newColumn = (char) (column - 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }
//        south-west
        if (row - 1 >= 1 && column - 1 >= 65) { // check if target is whithin the scope of the board.
            int newRow = row - 1;
            char newColumn = (char) (column - 1);
            Square moveSquare = gameBoard.lookupSquare(newColumn, newRow);
            Piece moveSquareContent = moveSquare.getSquareContent();
            if (moveSquareContent == null) {
                possibleSquares.add(moveSquare);
            } else if (moveSquareContent.getColor() != super.getColor()) {
                possibleSquares.add(moveSquare);
            }
        }

//        get the castlingSquares
        List<Square> castlingSquares = getCastlingSquares(gameBoard, opponent);
        if (this.getMoves().size() == 0) {
            possibleSquares.addAll(castlingSquares);
        }

        return possibleSquares;
    }

    public boolean defineCheckStatus(Board gameBoard, Player opponent) {
        boolean kingIsChecked = false;
        List<Square> allPossibleMoves = new ArrayList<>();
        for (Square square : gameBoard.getSquares()) {
            if (square.getSquareContent() != null && square.getSquareContent().getColor() != getColor()) {
                Piece opponentPiece = square.getSquareContent();
                allPossibleMoves.addAll(opponentPiece.getValidMoves(gameBoard, opponent));
            }
        }

        for (Square possibleMove : allPossibleMoves) {
            if (possibleMove.equals(getPosition())) {
                kingIsChecked = true;
                break;
            }
        }
        return kingIsChecked;
    }

    public boolean defineCheckMateStatus(Board gameBoard, Player opponent) {
        boolean checkMate = true;
        List<Piece> playerPieces = new ArrayList<>();
        for (Square square : gameBoard.getSquares()) {
            if (square.getSquareContent() != null && square.getSquareContent().getColor() == getColor()) {
                playerPieces.add(square.getSquareContent());
            }
        }

        for (Piece playerPiece : playerPieces) {
            List<Square> validMovesPiece;
            Square originalPosition = playerPiece.getPosition();
            validMovesPiece = playerPiece.getValidMoves(gameBoard, opponent);

            for (Square validMove : validMovesPiece) {
                boolean isChecked;
                if (validMove.getSquareContent() == null) {
                    playerPiece.setPosition(validMove);
                    validMove.setSquareContent(playerPiece);

                    isChecked = defineCheckStatus(gameBoard, opponent);

                    playerPiece.setPosition(originalPosition);
                    validMove.setSquareContent(null);

                } else {
                    Piece originalContent = validMove.getSquareContent();
                    playerPiece.setPosition(validMove);
                    validMove.setSquareContent(playerPiece);
                    originalContent.setPosition(null);

                    isChecked = defineCheckStatus(gameBoard, opponent);

                    validMove.setSquareContent(originalContent);
                    originalContent.setPosition(validMove);
                    playerPiece.setPosition(originalPosition);
                    originalPosition.setSquareContent(playerPiece);
                }

                if (!isChecked) {
                    checkMate = false;
                    break;
                }
            }
            if (!checkMate) {
                break;
            }
        }
        return checkMate;
    }


    public List<Square> getCastlingSquares(Board gameBoard, Player opponent) {
        List<Square> castleMoves = new ArrayList<>();
        if (getColor() == Color.WHITE) {
            Square a1 = gameBoard.lookupSquare('A', 1);
            Square b1 = gameBoard.lookupSquare('B', 1);
            Square c1 = gameBoard.lookupSquare('C', 1);
            Square d1 = gameBoard.lookupSquare('D', 1);
            Square f1 = gameBoard.lookupSquare('F', 1);
            Square g1 = gameBoard.lookupSquare('G', 1);
            Square h1 = gameBoard.lookupSquare('H', 1);

            if (a1.getSquareContent() instanceof Rook && a1.getSquareContent().getMoves().size() == 0) {
                if (b1.getSquareContent() == null && c1.getSquareContent() == null && d1.getSquareContent() == null) {

                    castleMoves.add(gameBoard.lookupSquare('C', 1)); // left castling move: kings always moves to C1
                }
            }

            if (h1.getSquareContent() instanceof Rook && h1.getSquareContent().getMoves().size() == 0) {
                if (f1.getSquareContent() == null && g1.getSquareContent() == null) {

                    castleMoves.add(gameBoard.lookupSquare('G', 1)); // left castling move: kings always moves to G1
                }
            }
        } else if (getColor() == Color.BLACK) { // for the black pieces
            Square a8 = gameBoard.lookupSquare('A', 8);
            Square b8 = gameBoard.lookupSquare('B', 8);
            Square c8 = gameBoard.lookupSquare('C', 8);
            Square d8 = gameBoard.lookupSquare('D', 8);
            Square f8 = gameBoard.lookupSquare('F', 8);
            Square g8 = gameBoard.lookupSquare('G', 8);
            Square h8 = gameBoard.lookupSquare('H', 8);

            if (a8.getSquareContent() instanceof Rook && a8.getSquareContent().getMoves().size() == 0) {
                if (b8.getSquareContent() == null && c8.getSquareContent() == null && d8.getSquareContent() == null) {

                    castleMoves.add(gameBoard.lookupSquare('C', 8)); // left castling move: kings always moves to C8
                }
            }

            if (h8.getSquareContent() instanceof Rook && h8.getSquareContent().getMoves().size() == 0) {
                if (f8.getSquareContent() == null && g8.getSquareContent() == null) {

                    castleMoves.add(gameBoard.lookupSquare('G', 8)); // left castling move: kings always moves to G8
                }
            }

        }
        return castleMoves;
    }

    public boolean getCastlingCheckStatus(Board gameBoard, Square targetSquare, Player opponent) {
        boolean isChecked = false;

        Square a1 = gameBoard.lookupSquare('A', 1);
        Square b1 = gameBoard.lookupSquare('B', 1);
        Square c1 = gameBoard.lookupSquare('C', 1);
        Square d1 = gameBoard.lookupSquare('D', 1);
        Square e1 = gameBoard.lookupSquare('E', 1);
        Square f1 = gameBoard.lookupSquare('F', 1);
        Square g1 = gameBoard.lookupSquare('G', 1);
        Square h1 = gameBoard.lookupSquare('H', 1);
        Square a8 = gameBoard.lookupSquare('A', 8);
        Square b8 = gameBoard.lookupSquare('B', 8);
        Square c8 = gameBoard.lookupSquare('C', 8);
        Square d8 = gameBoard.lookupSquare('D', 8);
        Square e8 = gameBoard.lookupSquare('E', 8);
        Square f8 = gameBoard.lookupSquare('F', 8);
        Square g8 = gameBoard.lookupSquare('G', 8);
        Square h8 = gameBoard.lookupSquare('H', 8);

        if (targetSquare.equals(g1)) {
            List<Square> rightCastleCheck = new ArrayList<>();
            rightCastleCheck.add(getPosition()); // we moeten selectedPiece dan ook gaan meegeven
            rightCastleCheck.add(f1);
            rightCastleCheck.add(e1); // c1 add to the list

            for (Square square : rightCastleCheck) {
                if (moveCheckSimulation(square, gameBoard, opponent)) {
                    isChecked = true; // if the boolean is changed to true, we never change it back within this loop
                }
            }

        } else if (targetSquare.equals(c1)) {
            List<Square> leftCastleCheck = new ArrayList<>();
            leftCastleCheck.add(getPosition()); // we moeten selectedPiece dan ook gaan meegeven
            leftCastleCheck.add(d1);
            leftCastleCheck.add(e1); // c1 add to the list

            for (Square square : leftCastleCheck) {
                if (moveCheckSimulation(square, gameBoard, opponent)) {
                    isChecked = true; // if the boolean is changed to true, we never change it back within this loop
                }
            }
        } else if (targetSquare.equals(c8)) {
            List<Square> leftCastleCheck = new ArrayList<>();
            leftCastleCheck.add(getPosition()); // we moeten selectedPiece dan ook gaan meegeven
            leftCastleCheck.add(d8);
            leftCastleCheck.add(e8); // c1 add to the list

            for (Square square : leftCastleCheck) {
                if (moveCheckSimulation(square, gameBoard, opponent)) {
                    isChecked = true; // if the boolean is changed to true, we never change it back within this loop
                }
            }
        } else if (targetSquare.equals(g8)) {
            List<Square> rightCastleCheck = new ArrayList<>();
            rightCastleCheck.add(getPosition()); // we moeten selectedPiece dan ook gaan meegeven
            rightCastleCheck.add(f8);
            rightCastleCheck.add(e8); // c1 add to the list

            for (Square square : rightCastleCheck) {
                if (moveCheckSimulation(square, gameBoard, opponent)) {
                    isChecked = true; // if the boolean is changed to true, we never change it back within this loop
                }
            }
        }
        return isChecked;
    }


    public boolean moveCheckSimulation(Square targetSquare, Board gameBoard, Player opponent) {
        Square startPosition = this.getPosition(); // set the previous content to null because the piece is moved
        startPosition.setSquareContent(null);

        setPosition(targetSquare); // assigns the new square to the piece
        targetSquare.setSquareContent(this); // assigns piece to the new square

        boolean isChecked = defineCheckStatus(gameBoard, opponent);

        startPosition.setSquareContent(this);
        this.setPosition(startPosition);

        if (!targetSquare.equals(gameBoard.lookupSquare('G', 1))
                || !targetSquare.equals(gameBoard.lookupSquare('C', 1))
                || !targetSquare.equals(gameBoard.lookupSquare('G', 8))
                || !targetSquare.equals(gameBoard.lookupSquare('C', 8))) {
            targetSquare.setSquareContent(null);
        }

        return isChecked;
    }

    public void castlingMove(Square targetSquare, Board gameBoard) {
        if (targetSquare.equals(new Square(1, 'C'))) {
            Piece rook = gameBoard.lookupSquare('A', 1).getSquareContent();
            rook.getPosition().setSquareContent(null);
            rook.setPosition(gameBoard.lookupSquare('D', 1));
            gameBoard.lookupSquare('D', 1).setSquareContent(rook);
        }

        if (targetSquare.equals(new Square(1, 'G'))) {
            Piece rook = gameBoard.lookupSquare('H', 1).getSquareContent();
            rook.getPosition().setSquareContent(null);
            rook.setPosition(gameBoard.lookupSquare('F', 1));
            gameBoard.lookupSquare('F', 1).setSquareContent(rook);
        }

        if (targetSquare.equals(new Square(8, 'C'))) {
            Piece rook = gameBoard.lookupSquare('A', 8).getSquareContent();
            rook.getPosition().setSquareContent(null);
            rook.setPosition(gameBoard.lookupSquare('D', 8));
            gameBoard.lookupSquare('D', 8).setSquareContent(rook);
        }

        if (targetSquare.equals(new Square(8, 'G'))) {
            Piece rook = gameBoard.lookupSquare('H', 8).getSquareContent();
            rook.getPosition().setSquareContent(null);
            rook.setPosition(gameBoard.lookupSquare('F', 8));
            gameBoard.lookupSquare('F', 8).setSquareContent(rook);
        }
    }

    @Override
    public String log() {
        return String.format("%s-%s", this.getClass().getSimpleName(), super.getColor());
    }

    @Override
    public String toString() {
        return "King" + getColor().toString().toLowerCase();
    }
}
