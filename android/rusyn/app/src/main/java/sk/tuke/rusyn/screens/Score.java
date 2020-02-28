package sk.tuke.rusyn.screens;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.plus.PlusShare;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.entities.UserScore;
import sk.tuke.rusyn.helpers.UserDbHelper;

public class Score extends AppCompatActivity implements View.OnClickListener {
    private int score, lesson;
    private String shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        UserDbHelper userDbHelper = new UserDbHelper(this);

        TextView skore = (TextView) findViewById(R.id.score_skore);
        Button next = (Button) findViewById(R.id.score_button_menu);
        next.setOnClickListener(this);

        lesson = (int) getIntent().getExtras().get("lesson");
        score = (int) getIntent().getExtras().get("score");
        String userid = userDbHelper.selectActiveUser(1).getId();

        skore.setText(String.valueOf(score));

        //Log.e("SCOREactLESSON", String.valueOf(lesson));
        //Log.e("SCOREactSCORE", String.valueOf(score));
        //Log.e("SCOREactUSER", userid);

        //int numOfRowExist = userDbHelper.existRow(userid, lesson);
        //Log.e("ROW EXIST", String.valueOf(numOfRowExist));

        //if(numOfRowExist == 1){
        //   userDbHelper.updateScore(new UserScore(userid,lesson,score));
        //}
        //else {
            userDbHelper.addScore(new UserScore(userid,lesson,score));
        //}

        Button opakuj = ((Button) findViewById(R.id.score_button_opakuj));
        opakuj.setOnClickListener(this);
//        opakuj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        String shareText = "Ziskal som v " + lesson + "lekcii" + score + "bodov";
        Button shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setOnClickListener(this);
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.share_button) {
            Intent shareIntent = new PlusShare.Builder(this)
                    .setType("text/plain")
                    .setText(shareText)
                    .setContentUrl(Uri.parse("https://developers.google.com/+/"))
                    .getIntent();
            Log.e("SCORE",shareIntent.toString());
            startActivityForResult(shareIntent,0);
        }
        if (v.getId() == R.id.score_button_menu){
            Intent intent = new Intent(Score.this, ListOfLessons.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.score_button_opakuj){
            if(lesson == 1) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 1);
                infolesson.putExtra("lesson", 0);
                startActivity(infolesson);
            }
            if(lesson == 2) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 2);
                infolesson.putExtra("lesson", 10);
                startActivity(infolesson);
            }
            if(lesson == 3) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 3);
                infolesson.putExtra("lesson", 23);
                startActivity(infolesson);
            }
            if(lesson == 4) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 4);
                infolesson.putExtra("lesson", 39);
                startActivity(infolesson);
            }
            if(lesson == 5) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 5);
                infolesson.putExtra("lesson", 56);
                startActivity(infolesson);
            }
            if(lesson == 6) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 6);
                infolesson.putExtra("lesson", 69);
                startActivity(infolesson);
            }
            if(lesson == 7) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 7);
                infolesson.putExtra("lesson", 86);
                startActivity(infolesson);
            }
            if(lesson == 8) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 8);
                infolesson.putExtra("lesson", 99);
                startActivity(infolesson);
            }
            if(lesson == 9) {
                Intent infolesson = new Intent(Score.this, LessonInfo.class);
                infolesson.putExtra("value", 9);
                infolesson.putExtra("lesson", 111);
                startActivity(infolesson);
            }
        }
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
                .setMessage("Chcete ukončiť lekciu?")
                .setPositiveButton("Áno", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(Score.this, ListOfLessons.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }
}
