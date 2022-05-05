package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

public class ChessGameSaver {
    Game chessGame;

    public ChessGameSaver(Game chessGame) {
        this.chessGame = chessGame;
    }

    public void save(){
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
        try (FileWriter writer = new FileWriter(logFile.toFile())){
//            Files.createFile(logFile);
            writer.write(chessGame.log());
            System.out.println(logFile.getFileName() + " was created");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String savedGameFileName){
        Path path = Paths.get("resources/savedGames/"+ savedGameFileName +  ".txt");

        System.out.println("File to check: " + path);
        boolean exists = Files.exists(path);
        System.out.println("File to check exists: " + exists);

        String savedGameText = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));){
            savedGameText = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(savedGameText);

    }


}
