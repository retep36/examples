package sk.tuke.rusyn.entities;

/**
 * Created by petko on 25. 3. 2018.
 */

public class UserScore {
    public static final String tableName = "USERSCORE";

    public static final String columnID = "id";
    public static final String columnLesson = "lesson";
    public static final String columnScore = "score";

    private String id;
    private int lesson;
    private int score;

    //CREATE TABLE
    public static final String createTable =
            "CREATE TABLE " + tableName + "("
                    + columnID + " TEXT,"
                    + columnLesson + " INTEGER,"
                    + columnScore + " INTEGER"
                    + ")";

    //CONSTRUCTORS
    public UserScore() {
    }

    public UserScore(String id, int lesson, int score) {
        this.id = id;
        this.lesson = lesson;
        this.score = score;
    }

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
