package model;

import model.chessPieces.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class ChessGameLoader {
    Player whitePlayer;
    Player blackPlayer;
    LocalDateTime startTime;
    Board gameBoard;
    Color turn;
    ChessGameSaver saver;

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public Color getTurn() {
        return turn;
    }

    public ChessGameLoader(String savedGameFileName) {
        Path path = Paths.get("resources/savedGames/" + savedGameFileName + ".txt");

        System.out.println("File to check: " + path);
        boolean exists = Files.exists(path);
        System.out.println("File to check exists: " + exists);

        String savedGameText = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));) {
            savedGameText = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(savedGameText);

        String[] savedGameData = savedGameText.split(";");

        String[] startDateElements = savedGameData[0].split(",");
        this.startTime = LocalDateTime.of(Integer.parseInt(startDateElements[2]), Integer.parseInt(startDateElements[1]), Integer.parseInt(startDateElements[0]), Integer.parseInt(startDateElements[3]), Integer.parseInt(startDateElements[4]), Integer.parseInt(startDateElements[5]));

        this.gameBoard = new Board();
        if(savedGameData[4].equals("WHITE")){
            this.turn = Color.WHITE;
        } else {
            this.turn = Color.BLACK;
        }

        String[] whitePlayerData = savedGameData[1].split(",");
        this.whitePlayer = new Player(whitePlayerData[0]);
        whitePlayer.setGameBoard(this.gameBoard);
        whitePlayer.setColor(Color.WHITE);
        Square lastMove = whitePlayer.lookupSquare(whitePlayerData[1].charAt(0), whitePlayerData[1].charAt(0));
        whitePlayer.getMoves().add(lastMove);

        String[] blackPlayerData = savedGameData[2].split(",");
        this.blackPlayer = new Player(blackPlayerData[0]);
        blackPlayer.setGameBoard(gameBoard);
        blackPlayer.setColor(Color.BLACK);
        lastMove = blackPlayer.lookupSquare(blackPlayerData[1].charAt(0), blackPlayerData[1].charAt(0));
        blackPlayer.getMoves().add(lastMove);

        String[] boardData = savedGameData[3].split(",");
        for (String boardSquareData : boardData) {
            String[] parsedBoardSquareData = boardSquareData.split(":");
            char column = parsedBoardSquareData[0].charAt(0);
            int row = Character.getNumericValue(parsedBoardSquareData[0].charAt(1));
            Square boardSquare = gameBoard.lookupSquare(column, row);
            if (!parsedBoardSquareData[1].equals("null")) {
                String[] boardSquareContentData = parsedBoardSquareData[1].split("-");
                Color pieceColor;
                if (boardSquareContentData[1].equals("WHITE")) {
                    pieceColor = Color.WHITE;
                } else {
                    pieceColor = Color.BLACK;
                }
                Piece loadedpiece = null;
                switch (boardSquareContentData[0]) {
                    case "King":
                        loadedpiece = new King(pieceColor, boardSquare);
                        break;
                    case "Queen":
                        loadedpiece = new Queen(pieceColor, boardSquare);
                        break;
                    case "Rook":
                        loadedpiece = new Rook(pieceColor, boardSquare);
                        break;
                    case "Bishop":
                        loadedpiece = new Bishop(pieceColor, boardSquare);
                        break;
                    case "Pawn":
                        loadedpiece = new Pawn(pieceColor, boardSquare);
                        break;
                    case "Knight":
                        loadedpiece = new Knight(pieceColor, boardSquare);
                        break;
                }
                if (loadedpiece != null) {
                    loadedpiece.setPosition(boardSquare);
                    boardSquare.setSquareContent(loadedpiece);
                }
            }
        }
    }
}

