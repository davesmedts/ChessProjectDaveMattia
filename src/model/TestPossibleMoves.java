package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestPossibleMoves {
    public static void main(String[] args) {
        Player dave = new Player("Dave");
        Player mattia = new Player("mattia");
        Game chessGame = new Game(dave, mattia);
//        System.out.println(chessGame.log());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHms");
//        String filename = chessGame.getStartTime().format(formatter);
//        Path logFile = Paths.get("resources/savedGames/" + filename + ".txt");
//        if (Files.exists(logFile)) {
//            try {
//                Files.delete(logFile);
//                System.out.println(logFile.getFileName() + " was deleted.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try (FileWriter writer = new FileWriter(logFile.toFile());){
////            Files.createFile(logFile);
//            writer.write(chessGame.log());
//            System.out.println(logFile.getFileName() + " was created");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String savedGameText = null;
//        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(logFile)));){
//            savedGameText = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(savedGameText);

//
//        String[] firstParsing = savedGameText.split(";");
//        String[] startDateValues = firstParsing[0].split(",");
//        String[] whitePlayerValues = firstParsing[1].split(",");
//        String[] blackPlayerValues = firstParsing[2].split(",");
//        String[] gameboardValues = firstParsing[3].split(",");
//
//        System.out.println(startDateValues[0]);
//        System.out.println(whitePlayerValues[0]);
//        System.out.println(blackPlayerValues[0]);
//        System.out.println(gameboardValues.length);
//        System.out.println(startDateValues[1]);
//
        chessGame.play();

//        Piece pawn = new Pawn(Color.WHITE, new Square(2, 'A'));
//        System.out.println("pawn");
//        Map<String, List<Square>> possibleMoves = pawn.getValidMoves();
//        for (List<Square> direction : possibleMoves.values()) {
//            System.out.println(direction);
//        }
//
//        Piece knight = new Knight(Color.WHITE, new Square(1, 'B'));
//        System.out.println("\nknight");
//        Map<String, List<Square>> possibleMovesKnight = knight.getValidMoves();
//        for (List<Square> direction : possibleMovesKnight.values()) {
//            System.out.println(direction);
//        }
//
//        Piece queen = new Queen(Color.WHITE, new Square(4, 'D'));
//        System.out.println("\nqueen");
//        Map<String, List<Square>> possibleMovesQueen = queen.getValidMoves();
//        for (List<Square> direction : possibleMovesQueen.values()) {
//            System.out.println(direction);
//        }
//
//        Piece king = new King(Color.WHITE, new Square(1, 'E'));
//        System.out.println("\nking");
//        Map<String, List<Square>> possibleMovesKing = king.getValidMoves();
//        for (List<Square> direction : possibleMovesKing.values()) {
//            System.out.println(direction);
//        }
//
//        Piece bishop = new Bishop(Color.WHITE, new Square(3, 'C'));
//        System.out.println("\nbischop");
//        Map<String, List<Square>> possibleMovesBishop = bishop.getValidMoves();
//        for (List<Square> direction : possibleMovesBishop.values()) {
//            System.out.println(direction);
//        }
//
//        Piece rook = new Rook(Color.WHITE, new Square(3, 'C'));
//        System.out.println("\nrook");
//        Map<String, List<Square>> possibleMovesRook = rook.getValidMoves();
//        for (List<Square> direction : possibleMovesRook.values()) {
//            System.out.println(direction);
//        }
//
//        Square squareOne = new Square(1,'A');
//        Square squareTwo = new Square(1,'A');
//        System.out.println(squareOne.equals(squareTwo));
    }
}
