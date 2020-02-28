package sk.tuke.rusyn.entities;

/**
 * Created by petko on 28. 1. 2018.
 */

public class Answer {
    public static final String tableName = "ANSWERS";

    public static final String columnID = "Aid";
    public static final String columnAnswer = "answer";
    public static final String columnCorrectAns = "correctAns";

    private int id;
    private String answer;
    private int correctAns;

    //CREATE TABLE
    public static final String createTable =
            "CREATE TABLE " + tableName + "("
                    + columnID + " INTEGER PRIMARY KEY,"
                    + columnAnswer + " TEXT,"
                    + columnCorrectAns + " INTEGER" + ")";

    public Answer() {
    }

    //CONSTRUCTOR
    public Answer(String answers, int correctAns) {
        this.answer = answers;
        this.correctAns = correctAns;
    }

    public Answer(int id, String answers, int correctAns) {
        this.id = id;
        this.answer = answers;
        this.correctAns = correctAns;
    }

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswers() {
        return answer;
    }

    public void setAnswers(String answer) {
        this.answer = answer;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }
}
