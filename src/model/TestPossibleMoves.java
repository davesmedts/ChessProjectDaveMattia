package model;

import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TestPossibleMoves {
    public static void main(String[] args) {
//        Player dave = new Player("Tom");
//        Player mattia = new Player("Jerry");
//
//        Game chessGame = new Game(dave,mattia,false);
//        chessGame.play();

        History history = new History();
        List<HistoryRecord> records = history.readHistoryRecords();
        System.out.println(records.size());
        for (HistoryRecord record : records) {
            System.out.printf("%s,%s,%s,%s\n", record.getDate(), record.getWhitePlayer(), record.getBlackPlayer(), record.getWinner());
        }

    }
}
