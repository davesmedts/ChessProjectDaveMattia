package model;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class ChessGameSaver {
    Game chessGame;

    public ChessGameSaver(Game chessGame) {
        this.chessGame = chessGame;
    }

    public void save() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String filename = chessGame.getStartTime().format(formatter);
        Path logFile = Paths.get("resources/savedGames/" + filename + ".txt");
        if (Files.exists(logFile)) {
            try {
                Files.delete(logFile);
                System.out.println(logFile.getFileName() + " was deleted.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter writer = new FileWriter(logFile.toFile())) {
//            Files.createFile(logFile);
            writer.write(chessGame.log());
            System.out.println(logFile.getFileName() + " was created");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String savedGameFileName) {
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
    }

    public void logHistory() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String gameDate = chessGame.getStartTime().format(formatter);
        String whitePlayer = chessGame.getWhitePlayer().toString();
        String blackPlayer = chessGame.getBlackPlayer().toString();
        String winner = chessGame.getWinner().toString();

        Path historyFile = Paths.get("resources/history.txt");
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(historyFile.toFile()));) {
            String regel = reader.readLine();
            while (regel != null) {
                builder.append(regel);
                builder.append("\n");
                regel = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        builder.append(gameDate).append(";").append(whitePlayer).append(";").append(blackPlayer).append(";").append(winner);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(historyFile.toFile()))) {
            writer.write(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
