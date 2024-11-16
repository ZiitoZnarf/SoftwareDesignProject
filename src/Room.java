import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomID;
    private int difficultyLevel;
    private int maxParticipant;
    private String status;
    private String theme;
    private List<Puzzle> puzzles;
    private Leaderboard leaderboard;
    private List<Feedback> feedback;
    private float basePrice;

    //construct
    public Room(int roomID, int difficultyLevel, int maxParticipant, String status, String theme, float basePrice){
        this.roomID = roomID;
        this.difficultyLevel = difficultyLevel;
        this.maxParticipant = maxParticipant;
        this.status = status;
        this.theme = theme;
        this.puzzles = new ArrayList<>();
        this.leaderboard = new Leaderboard();
        this.feedback = new ArrayList<>();
        this.basePrice = basePrice;
    }

    //getter setter
    public int getRoomID(){
        return roomID;
    }

    public int getMaxParticipant(){
        return maxParticipant;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public float getBasePrice() {
        return basePrice;
    }
}
