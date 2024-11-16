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

    //construct
    public Room(int roomID, int difficultyLevel, int maxParticipant, String status, String theme){
        this.roomID = roomID;
        this.difficultyLevel = difficultyLevel;
        this.maxParticipant = maxParticipant;
        this.status = status;
        this.theme = theme;
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
}
