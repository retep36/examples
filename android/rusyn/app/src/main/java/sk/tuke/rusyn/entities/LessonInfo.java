package sk.tuke.rusyn.entities;

/**
 * Created by petko on 22. 1. 2018.
 */

public class LessonInfo {
    public static final String tableName = "LESSONINFO";

    public static final String columnID = "id";
    public static final String columnLesson = "lesson";
    public static final String columnDescription = "description";

    private int id;
    private int lesson;
    private String description;

    //CREATE TABLE
    public static final String createTable =
            "CREATE TABLE " + tableName + "("
                    + columnID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + columnLesson + " INTEGER,"
                    + columnDescription + " TEXT"
                    + ")";

    //CONSTRUCTORS
    public LessonInfo() {
    }

    public LessonInfo(int id, int lesson, String description) {
        this.id = id;
        this.lesson = lesson;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}




