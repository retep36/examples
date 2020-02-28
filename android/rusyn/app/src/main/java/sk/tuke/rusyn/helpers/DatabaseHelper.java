package sk.tuke.rusyn.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sk.tuke.rusyn.entities.Answer;
import sk.tuke.rusyn.entities.LessonInfo;
import sk.tuke.rusyn.entities.Question;

/**
 * Created by petko on 22. 1. 2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "rusynDB11.db";

    //VARIABLES FOR SHIPING APK WITH DB
    private final Context context;
    private boolean createDb = true;
    private static final String TAG = "SQLiteOpenHelper";

    //**PREPOJOVACIA TABULKA**//
    //PREMENNE PRE PREPOJOVACIU TABULKU
    private static final String helperTable = "HELPERTABLE";
    private static final String columnID = "id";

    //VYTVORENIE PREPOJOVACEJ TABULKY
    private static final String creatTableHelper =
            "CREATE TABLE " + helperTable + "("
                    + columnID + " INTEGER PRIMARY KEY,"
                    + Question.columnID + " INTEGER,"
                    + Answer.columnID + " INTEGER" + ")";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.context = context;
    }

    //**COPY ZIP FILE OF DB FROM ASSETS TO APLICATION PACKAGE**//
    private void copyDatabaseFromAssets(SQLiteDatabase db) {
        Log.e(TAG, "copyDatabase");
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            myInput = context.getAssets().open("rusynDB11.db");
            myOutput = new FileOutputStream(db.getPath());

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();

            SQLiteDatabase copiedDatabase = context.openOrCreateDatabase(databaseName, 0, null);
            copiedDatabase.execSQL("PRAGMA user_version = " + databaseVersion);
            copiedDatabase.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error(TAG + " Error: copy database");
        } finally {
            try {
                if (myOutput != null) {
                    myOutput.close();
                }
                if (myInput != null) {
                    myInput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new Error(TAG + " Error: close streams");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createDb = true;
        sqLiteDatabase.execSQL(LessonInfo.createTable);
        sqLiteDatabase.execSQL(Question.createTable);
        sqLiteDatabase.execSQL(Answer.createTable);
        sqLiteDatabase.execSQL(creatTableHelper);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        boolean upgradeDb = true;
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LessonInfo.tableName);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Question.tableName);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Answer.tableName);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + helperTable);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        if (createDb) {
            createDb = false;
            copyDatabaseFromAssets(db);
        }
    }

    //////////////////////////////////////////OPERATIONS*///////////////////////////////////////////
    /**OPERATIONS WITH TABLES**/
    //GET INFO ABOUT LESSON - INFOLESSON
    public List<LessonInfo> getLessonInfo(int lesson){
        List<LessonInfo> lessonInfoList = new ArrayList<>();

        String selectQuery = "SELECT " + LessonInfo.columnDescription + " FROM " + LessonInfo.tableName + " WHERE " +
                LessonInfo.columnLesson + " = '" + lesson + "'";

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                LessonInfo lessonInfo = new LessonInfo();
                lessonInfo.setDescription(cursor.getString(cursor.getColumnIndex(LessonInfo.columnDescription)));
                lessonInfoList.add(lessonInfo);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return lessonInfoList;
    }

    //GET QUESTION - QUIZ
    public Question getSimpleQuestionWithID(int id){
        String selectQuery = "SELECT * FROM " + Question.tableName + " WHERE " +
                Question.columnID + " = '" + id + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        Question question = new Question();
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            question.setDescription(cursor.getString(cursor.getColumnIndex(Question.columnDescription)));
            question.setQuestion(cursor.getString(cursor.getColumnIndex(Question.columnQuestion)));
            question.setType(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Question.columnType))));
            question.setLesson(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Question.columnLesson))));
            question.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Question.columnID))));
        }
        db.close();
        return question;
    }

    //GET ANSWERS - QUIZ
    public List<HashMap<String, String>> getAnswers(int Qid){
        List<HashMap<String, String>> answerList = new ArrayList<>();

        String selectQuery = "SELECT A.* FROM " + Answer.tableName +" A JOIN " + helperTable + " HT ON A.Aid = HT.Aid JOIN "
                + Question.tableName + " Q ON Q.Qid = HT.Qid WHERE Q.Qid = '" + Qid + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> items = new HashMap<>();
                items.put("text",(cursor.getString(cursor.getColumnIndex(Answer.columnAnswer))));
                items.put("skryty",cursor.getString(cursor.getColumnIndex(Answer.columnCorrectAns)));
                answerList.add(items);
            } while (cursor.moveToNext());
        }
        db.close();
        return answerList;
    }

    //get answer bz Qid
    public List<Answer> getAnswersList(int Qid){
        List<Answer> answerList = new ArrayList<>();

        String selectQuery = "SELECT A.* FROM " + Answer.tableName +" A JOIN " + helperTable + " HT ON A.Aid = HT.Aid JOIN "
                + Question.tableName + " Q ON Q.Qid = HT.Qid WHERE Q.Qid = '" + Qid + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Answer answer = new Answer();
                answer.setAnswers(cursor.getString(cursor.getColumnIndex(Answer.columnAnswer)));
                answer.setCorrectAns(cursor.getInt(cursor.getColumnIndex(Answer.columnCorrectAns)));
                answer.setId(cursor.getInt(cursor.getColumnIndex(Answer.columnID)));
                answerList.add(answer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return answerList;
    }

    //get correct answer - question, customadapter, inkactivity
    public Answer getCorrectAnswer(int Qid){
        String selectQuery = "SELECT A.* FROM " + Answer.tableName +" A JOIN " + helperTable + " HT ON A.Aid = HT.Aid JOIN "
                + Question.tableName + " Q ON Q.Qid = HT.Qid WHERE Q.Qid = '" + Qid + "' AND " + Answer.columnCorrectAns + " = '1'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        Answer answer = new Answer();
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            answer.setAnswers(cursor.getString(cursor.getColumnIndex(Answer.columnAnswer)));
            answer.setCorrectAns(cursor.getInt(cursor.getColumnIndex(Answer.columnCorrectAns)));
            answer.setId(cursor.getInt(cursor.getColumnIndex(Answer.columnID)));
        }
        db.close();
        return answer;
    }

    @Override
    public void close() {
        super.close();
    }
}
