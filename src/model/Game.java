package model;

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

    //constructor
    public Game(Player playerOne, Player playerTwo, boolean isNewGame) {
        this.isNewGame = isNewGame;
        if(isNewGame){
            newGame(playerOne, playerTwo);
        } else {
            loadGame();
        }
    }

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

    public void newGame(Player playerOne, Player playerTwo){
        this.startTime = LocalDateTime.now();
        this.saver = new ChessGameSaver(this);
        // creating Random boolean that can be used to randomly define who plays black or white
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

    public void loadGame(){
        this.loader = new ChessGameLoader("checkMateTest");
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
                whitePlayer.selectPiece(whitePlayer, blackPlayer);
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
                blackPlayer.selectPiece(blackPlayer, whitePlayer);
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


    public String log(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d,%d,%d,%d,%d,%d;%s;%s;%s;%s", startTime.getDayOfMonth(), startTime.getMonthValue(), startTime.getYear(), startTime.getHour(), startTime.getMinute(), startTime.getSecond(), whitePlayer.log(), blackPlayer.log(), gameBoard.log(), this.turn));
        return builder.toString();
    }

    public static List<String[]> getHistory(){
        List<String[]> playedGames = new ArrayList<>();
        Path historyFile =  Paths.get("/resources/history.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(historyFile.toFile()));) {
            String regel = reader.readLine();
            while (regel != null) {
                String[] playedGame = regel.split(";");
                playedGames.add(playedGame);
                regel = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playedGames;
    }

}
