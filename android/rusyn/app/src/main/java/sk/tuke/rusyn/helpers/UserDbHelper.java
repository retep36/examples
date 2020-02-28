package sk.tuke.rusyn.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import sk.tuke.rusyn.entities.User;
import sk.tuke.rusyn.entities.UserScore;

/**
 * Created by petko on 5. 2. 2018.
 */

public class UserDbHelper extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "UsersTabs2.db";

    public UserDbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(User.createTable);
        sqLiteDatabase.execSQL(UserScore.createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + User.tableName);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserScore.tableName);
        onCreate(sqLiteDatabase);
    }


    //////////////////////////////////////*CRUD*OPERATIONS*/////////////////////////////////////////
    /**OPERATIONS WITH TABLES**/
    //GET DATA ABOUT USER - USERINFO
    public User selectActiveUser(int isLogged) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + User.tableName + " WHERE " +
                User.columnIsLogged + " = " + "'" + isLogged + "'";

        //Log.e("HELPER", selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        //assert cursor != null;
        User user = new User();
        assert cursor != null;
        user.setEmail(cursor.getString(cursor.getColumnIndex(User.columnEmail)));
        user.setId(cursor.getString(cursor.getColumnIndex(User.columnID)));
        return user;
    }

    //ADD USER OR UPDATE USER - LOGIN
    public void addOrUpdateUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(User.columnID, user.getId());
        contentValues.put(User.columnEmail, user.getEmail());
        contentValues.put(User.columnIsLogged, user.getIsLogged());

        Cursor query = sqLiteDatabase.query(User.tableName, null, null, null, null, null, null);
        if(query.getCount()<1) {
            sqLiteDatabase.insert(User.tableName, null, contentValues);
        }
        else {
            sqLiteDatabase.update(User.tableName, contentValues, null, null);
        }
        sqLiteDatabase.close();
    }

    //LOG OUT USER - USERINFO
    public void logOut(int isLogged){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(User.columnIsLogged,0);

        sqLiteDatabase.update(User.tableName, contentValues, User.columnIsLogged + "=" + isLogged, null);
    }

    //IS USER LOGGED? - LOGIN
    public boolean isUserLogged(){
        String countQuery = "SELECT COUNT (*) FROM " + User.tableName + " WHERE " + User.columnIsLogged + "='" + 1 + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count == 1;
    }



    //GET LAST SCORE - MENUACTIVITY
    public UserScore getScoreOfLesson(int lesson, String user){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + UserScore.tableName + " WHERE " + UserScore.columnLesson + " = '" + lesson + "' AND "
                + UserScore.columnID + " = '" + user + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);
        UserScore userScore = new UserScore();
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            userScore.setId(cursor.getString(cursor.getColumnIndex(UserScore.columnID)));
            userScore.setLesson(Integer.parseInt(cursor.getString(cursor.getColumnIndex(UserScore.columnLesson))));
            userScore.setScore(Integer.parseInt(cursor.getString(cursor.getColumnIndex(UserScore.columnScore))));
        }
        db.close();
        return userScore;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //POMOCNY SELECT
    public List<User> getAllUsers(){
        List<User> lessonInfoList = new ArrayList<>();

        String selectQuery = "SELECT " + User.columnEmail + ", " + User.columnIsLogged + " FROM " + User.tableName;

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setEmail(cursor.getString(cursor.getColumnIndex(User.columnEmail)));
                user.setIsLogged(cursor.getInt(cursor.getColumnIndex(User.columnIsLogged)));

                lessonInfoList.add(user);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return lessonInfoList;
    }



    public List<UserScore> getAll(){
        List<UserScore> lessonInfoList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + UserScore.tableName;

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UserScore userScore = new UserScore();
                userScore.setId(cursor.getString(cursor.getColumnIndex(UserScore.columnID)));
                userScore.setLesson(cursor.getInt(cursor.getColumnIndex(UserScore.columnLesson)));
                userScore.setScore(cursor.getInt(cursor.getColumnIndex(UserScore.columnScore)));

                lessonInfoList.add(userScore);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return lessonInfoList;
    }






    //**SKUSOBNE SELECTY


    //WRITE NEW SCORE OF LESSON TO TABLE - SCORE
    public void addScore(UserScore userScore){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserScore.columnID, userScore.getId());
        values.put(UserScore.columnLesson, userScore.getLesson());
        values.put(UserScore.columnScore, userScore.getScore());

        Cursor query = db.query(UserScore.tableName, null, null, null, null, null, null);
        db.insert(UserScore.tableName, null, values);
        db.close();
    }

    public int existRow(String userid, int lesson){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor mCount= sqLiteDatabase.rawQuery("SELECT COUNT(*) FROM "+ UserScore.tableName
                + " WHERE + " + UserScore.columnLesson + "= '" + lesson + "' AND " + UserScore.columnID + "= '" + userid + "'"
                , null);
        mCount.moveToFirst();
        int count = mCount.getInt(0);
        mCount.close();
        sqLiteDatabase.close();
        return mCount.getCount();
    }

    public void updateScore(UserScore userScore){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserScore.columnID, userScore.getId());
        values.put(UserScore.columnLesson, userScore.getLesson());
        values.put(UserScore.columnScore, userScore.getScore());

        Cursor query = db.query(UserScore.tableName, null, null, null, null, null, null);
        db.update(UserScore.tableName, values, null, null);
        db.close();
    }

    //*KONEC


    public void replaceOrInsertScore(String userID, int score, int lesson){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String selectQuery = "INSERT OR REPLACE INTO " + UserScore.tableName + "(" + UserScore.columnID +","+ UserScore.columnScore +","+ UserScore.columnLesson
                + ") VALUES(" + userID +","+ score +","+ lesson +")";

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        sqLiteDatabase.close();
    }


    @Override
    public void close() {
        super.close();
    }

}
