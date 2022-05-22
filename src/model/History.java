package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Smedts
 * @version 1.0 22/05/2022 23:29
 */
public class History {

    public List<HistoryRecord> readHistoryRecords() {
        List<HistoryRecord> records = new ArrayList<>();
        Path path = Paths.get("resources/history.txt");

        System.out.println("File to check: " + path);
        boolean exists = Files.exists(path);
        System.out.println("File to check exists: " + exists);

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));) {
            String line = reader.readLine();
            while (line != null) {
                String[] recordData = line.split(";");
                String date = recordData[0];
                String whitePlayer = recordData[1];
                String blackPlayer = recordData[2];
                String winner = recordData[3];
                records.add(new HistoryRecord(date, whitePlayer, blackPlayer, winner));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
