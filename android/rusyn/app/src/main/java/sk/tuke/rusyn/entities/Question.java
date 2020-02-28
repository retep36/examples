package sk.tuke.rusyn.entities;

/**
 * Created by petko on 27. 1. 2018.
 */

public class Question {
    public static final String tableName = "QUESTIONS";

    public static final String columnID = "Qid";
    public static final String columnLesson = "lesson";
    public static final String columnType = "type";
    public static final String columnQuestion = "question";
    public static final String columnDescription = "description";

    private int id;
    private int lesson;
    private int type;
    private String question;
    private String description;

    //CREATE TABLE
    public static final String createTable =
            "CREATE TABLE " + tableName + "("
                    + columnID + " INTEGER PRIMARY KEY,"
                    + columnLesson + " INTEGER,"
                    + columnType + " INTEGER,"
                    + columnQuestion + " TEXT,"
                    + columnDescription + " TEXT" + ")";

    //CONSTRUCTORS
    public Question() {
    }

    public Question(int lesson, int type, String question, String description) {
        this.lesson = lesson;
        this.type = type;
        this.question = question;
        this.description = description;
    }

    public Question(int id, int lesson, int type, String question, String description) {
        this.id = id;
        this.lesson = lesson;
        this.type = type;
        this.question = question;
        this.description = description;
    }

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
