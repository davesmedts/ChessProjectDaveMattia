package model;

/**
 * @author Dave Smedts
 * @version 1.0 22/05/2022 23:39
 */
public class HistoryRecord {
    String date;
    String whitePlayer;
    String blackPlayer;
    String winner;

    public HistoryRecord(String date, String whitePlayer, String blackPlayer, String winner) {
        this.date = date;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.winner = winner;
    }

    public String getDate() {
        return date;
    }

    public String getWhitePlayer() {
        return whitePlayer;
    }

    public String getBlackPlayer() {
        return blackPlayer;
    }

    public String getWinner() {
        return winner;
    }
}
