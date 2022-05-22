package model;

import exceptions.IllegalMoveException;
import exceptions.IllegalPieceSelectionException;
import model.chessPieces.Piece;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Player blackPlayer;
    private Player whitePlayer;
    private Board gameBoard;
    private Color turn;
    private LocalDateTime startTime;
    private Player winner;
    private boolean gameFinished;
    private ChessGameSaver saver;
    private ChessGameLoader loader;
    boolean isNewGame;
    private History history;


    //constructor
    public Game(){
        this.history = new History();
    }

//    public Game(String naamWit, String naamZwart, boolean isNewGame) {
//        this.isNewGame = isNewGame;
//
//        this.naamWit = naamWit;
//        this.naamZwart = naamZwart;
//        newGame();
//    }


    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public Color getTurn() {
        return turn;
    }

    public ChessGameSaver getSaver() {
        return saver;
    }

    public History getHistory() {
        return history;
    }

    public void setTurn(Color turn) {
        this.turn = turn;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public void setSaver(ChessGameSaver saver) {
        this.saver = saver;
    }

    public void setBlackPlayer(Player blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public void setWhitePlayer(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setLoader(ChessGameLoader loader) {
        this.loader = loader;
    }

    public void setNewGame(boolean newGame) {
        isNewGame = newGame;
    }

    public void newGame(String playerOneName, String playerTwoName) {

        this.startTime = LocalDateTime.now();
        this.saver = new ChessGameSaver(this);
        // creating Random boolean that can be used to randomly define who plays black or white

        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);

        Random rd = new Random();
        boolean playerOneIsBlack = rd.nextBoolean();
        if (playerOneIsBlack) {
            blackPlayer = playerOne;
            whitePlayer = playerTwo;
        } else {
            blackPlayer = playerTwo;
            whitePlayer = playerOne;
        }
//        we create a new gameBoard and assign the board to the Player object as well.
        gameBoard = new Board();
        whitePlayer.setGameBoard(gameBoard);
        blackPlayer.setGameBoard(gameBoard);


//        player who plays white always has the first turn.
        turn = Color.WHITE;
        startTime = LocalDateTime.now();
        gameFinished = false;

//        we call the initializePieces method to create all pieces and place them onto our board.
        whitePlayer.setColor(Color.WHITE);
        whitePlayer.initializePieces();
        blackPlayer.setColor(Color.BLACK);
        blackPlayer.initializePieces();

    }

    public void loadGame(String fileName) {
        this.loader = new ChessGameLoader(fileName);
        this.blackPlayer = loader.getBlackPlayer();
        this.whitePlayer = loader.getWhitePlayer();
        this.startTime = loader.getStartTime();
        this.gameBoard = loader.getGameBoard();
        this.turn = loader.getTurn();
        this.saver = new ChessGameSaver(this);
    }

    public void play() {
        System.out.printf("%s, you are playing white", whitePlayer);
        System.out.printf("%n%s, you are playing black", blackPlayer);
        System.out.println(getGameBoard());
        while (!gameFinished) {
            if (turn == Color.WHITE) {
//                whitePlayer.selectPiece(whitePlayer, blackPlayer);
                turn = Color.BLACK;
                saver.save();
//                System.out.println(saver.logHistory());

                if (whitePlayer.isWinner()) {
                    gameFinished = true;
                    setWinner(whitePlayer);
                    saver.logHistory();
                    System.out.printf("Game Over! %s wins!", whitePlayer);
                }
            } else {
//                blackPlayer.selectPiece(blackPlayer, whitePlayer);
                turn = Color.WHITE;
                saver.save();

                if (blackPlayer.isWinner()) {
                    gameFinished = true;
                    setWinner(blackPlayer);
                    saver.logHistory();
                    System.out.printf("Game Over! %s wins!", blackPlayer);
                }
            }
            System.out.println(getGameBoard());
        }
    }

    public List<Square> selectWhitePiece(char selectedColumnLetter, int selectedRowNumber) throws IllegalPieceSelectionException {
        return whitePlayer.selectPiece(selectedColumnLetter, selectedRowNumber, whitePlayer, blackPlayer);
    }

    public List<Square> selectBlackPiece(char selectedColumnLetter, int selectedRowNumber) throws IllegalPieceSelectionException {
        return blackPlayer.selectPiece(selectedColumnLetter, selectedRowNumber, blackPlayer, whitePlayer);
    }

    public void moveWhitePiece(char selectedColumnLetter, int selectedRowNumber) throws IllegalMoveException {
        whitePlayer.movePiece(selectedColumnLetter, selectedRowNumber, blackPlayer);
    }

    public void moveBlackPiece(char selectedColumnLetter, int selectedRowNumber) throws IllegalMoveException {
        blackPlayer.movePiece(selectedColumnLetter, selectedRowNumber, whitePlayer);
    }


    public String log() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d,%d,%d,%d,%d,%d;%s;%s;%s;%s", startTime.getDayOfMonth(), startTime.getMonthValue(), startTime.getYear(), startTime.getHour(), startTime.getMinute(), startTime.getSecond(), whitePlayer.log(), blackPlayer.log(), gameBoard.log(), this.turn));
        return builder.toString();
    }

//    public static List<String[]> getHistory() {
//        List<String[]> playedGames = new ArrayList<>();
//        Path historyFile = Paths.get("/resources/history.txt");
//        try (BufferedReader reader = new BufferedReader(new FileReader(historyFile.toFile()));) {
//            String regel = reader.readLine();
//            while (regel != null) {
//                String[] playedGame = regel.split(";");
//                playedGames.add(playedGame);
//                regel = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return playedGames;
//    }

}
