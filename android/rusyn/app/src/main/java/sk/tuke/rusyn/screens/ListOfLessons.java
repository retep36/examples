package sk.tuke.rusyn.screens;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.entities.UserScore;
import sk.tuke.rusyn.helpers.UserDbHelper;
import sk.tuke.rusyn.questions.Question;

public class ListOfLessons extends AppCompatActivity implements View.OnClickListener{
    private TextView percento1, percento2, percento3, percento4, percento5, percento6, percento7, percento8, percento9;
    UserDbHelper userDbHelper = new UserDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Rusínsky jazyk");

        UserDbHelper userDbHelper = new UserDbHelper(this);
        String userid = userDbHelper.selectActiveUser(1).getId();

        percento1 = (TextView)findViewById(R.id.percento1);
        percento2 = (TextView)findViewById(R.id.percento2);
        percento3 = (TextView)findViewById(R.id.percento3);
        percento4 = (TextView)findViewById(R.id.percento4);
        percento5 = (TextView)findViewById(R.id.percento5);
        percento6 = (TextView)findViewById(R.id.percento6);
        percento7 = (TextView)findViewById(R.id.percento7);
        percento8 = (TextView)findViewById(R.id.percento8);
        percento9 = (TextView)findViewById(R.id.percento9);


        //**ZAKLADY**//
        Button btn_zaklady = findViewById(R.id.btn_zaklady);
        btn_zaklady.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",1);
                infolesson.putExtra("lesson",0);
                startActivity(infolesson);
            }
        });

        StringBuilder sb1 = new StringBuilder();
        UserScore userScore1 = userDbHelper.getScoreOfLesson(1,userid);
        int cislo1 = (int) Math.round((userScore1.getScore()*10));
        sb1.append(cislo1).append("%");
        if (userScore1.getScore() != 0)
            percento1.setText(sb1);


        //**POZDRAVY A PRIANIA**//
        Button btn_pozdravy = findViewById(R.id.btn_pozdravy);
        btn_pozdravy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",2);
                infolesson.putExtra("lesson",10);
                startActivity(infolesson);
            }
        });

        StringBuilder sb2 = new StringBuilder();
        UserScore userScore2 = userDbHelper.getScoreOfLesson(2,userid);
        int cislo2 = (int) Math.round((userScore2.getScore()*8.33));
        sb2.append(cislo2).append("%");
        Log.e("MAIN", String.valueOf(cislo2));
        if (userScore2.getScore() != 0)
            percento2.setText(sb2);


        //**OSLOVENIA - FORMALNA A NEFORMALNA KOMUNIKACIA**//
        Button btn_oslovenia = findViewById(R.id.btn_oslovenia);
        btn_oslovenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",3);
                infolesson.putExtra("lesson",23);
                startActivity(infolesson);
            }
        });

        StringBuilder sb3 = new StringBuilder();
        UserScore userScore3 = userDbHelper.getScoreOfLesson(3,userid);
        int cislo3 = (int) Math.round((userScore3.getScore()*6.66));
        sb3.append(cislo3).append("%");
        if (userScore3.getScore() != 0)
            percento3.setText(sb3);

        //**SLOVNA ZASOBA 1**//
        Button btn_slovZasoba1 = findViewById(R.id.btn_slovZasoba1);
        btn_slovZasoba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",4);
                infolesson.putExtra("lesson",39);
                startActivity(infolesson);
            }
        });

        StringBuilder sb4 = new StringBuilder();
        UserScore userScore4 = userDbHelper.getScoreOfLesson(4,userid);
        int cislo4 = (int) Math.round((userScore4.getScore()*6.25));
        sb4.append(cislo4).append("%");
        if (userScore4.getScore() != 0)
            percento4.setText(sb4);

        //**FRAZY 1**//
        Button btn_frazy1 = findViewById(R.id.btn_frazy1);
        btn_frazy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",5);
                infolesson.putExtra("lesson",56);
                startActivity(infolesson);
            }
        });

        StringBuilder sb5 = new StringBuilder();
        UserScore userScore5 = userDbHelper.getScoreOfLesson(5,userid);
        int cislo5 = (int) Math.round((userScore5.getScore()*8.33));
        sb5.append(cislo5).append("%");
        if (userScore5.getScore() != 0)
            percento5.setText(sb5);

        //***OSOBNE ZAMENA, RODINA A FARBY*//
        Button btn_rodina = findViewById(R.id.btn_rodina);
        btn_rodina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",6);
                infolesson.putExtra("lesson",69);
                startActivity(infolesson);
            }
        });

        StringBuilder sb6 = new StringBuilder();
        UserScore userScore6 = userDbHelper.getScoreOfLesson(6,userid);
        int cislo6 = (int) Math.round((userScore6.getScore()*6.25));
        sb6.append(cislo6).append("%");
        if (userScore6.getScore() != 0)
            percento6.setText(sb6);

        //***SLOVESO BYT*//
        Button btn_slovesobyt = findViewById(R.id.btn_siedma);
        btn_slovesobyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",7);
                infolesson.putExtra("lesson",86);
                startActivity(infolesson);
            }
        });

        StringBuilder sb7 = new StringBuilder();
        UserScore userScore7 = userDbHelper.getScoreOfLesson(7,userid);
        int cislo7 = (int) Math.round((userScore7.getScore()*8.33));
        sb7.append(cislo7).append("%");
        if (userScore7.getScore() != 0)
            percento7.setText(sb7);


        //***ZAMESTNANIA*//
        Button btn_profesia = findViewById(R.id.btn_osma);
        btn_profesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",8);
                infolesson.putExtra("lesson",99);
                startActivity(infolesson);
            }
        });

        StringBuilder sb8 = new StringBuilder();
        UserScore userScore8 = userDbHelper.getScoreOfLesson(8,userid);
        int cislo8 = (int) Math.round((userScore8.getScore()*8.33));
        sb8.append(cislo8).append("%");
        if (userScore8.getScore() != 0)
            percento8.setText(sb8);

        //***SLOVNA ZASOBA 2*//
        Button btn_slov2 = findViewById(R.id.btn_deviata);
        btn_slov2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infolesson = new Intent(ListOfLessons.this, LessonInfo.class);
                infolesson.putExtra("value",9);
                infolesson.putExtra("lesson",111);
                startActivity(infolesson);
            }
        });

        StringBuilder sb9 = new StringBuilder();
        UserScore userScore9 = userDbHelper.getScoreOfLesson(9,userid);
        int cislo9 = (int) Math.round((userScore9.getScore()*9.09));
        sb9.append(cislo9).append("%");
        if (userScore9.getScore() != 0)
            percento9.setText(sb9);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.user: {
                Intent launchNewIntent = new Intent(ListOfLessons.this,UserInfo.class);
                startActivityForResult(launchNewIntent, 0);
                return true;
            }
            case R.id.about_us:{
                Intent launchNewIntent = new Intent(ListOfLessons.this,About.class);
                startActivityForResult(launchNewIntent, 0);
                return true;
            }
            case R.id.odhlasenie:{
                userDbHelper.logOut(1);
                Intent launchNewIntent = new Intent(ListOfLessons.this, Login.class);
                startActivityForResult(launchNewIntent, 0);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {
        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Chcete ukončiť aplikáciu?")
                .setPositiveButton("Áno", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                })
                .setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }

    @Override
    public void onClick(View view) {

    }
}
