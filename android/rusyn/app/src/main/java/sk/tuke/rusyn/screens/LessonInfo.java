package sk.tuke.rusyn.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.helpers.DatabaseHelper;
import sk.tuke.rusyn.questions.SumActivity;

public class LessonInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_lesson);

        //initialiyations
        DatabaseHelper db = new DatabaseHelper(this);
        TextView fieldForDescription = findViewById(R.id.text_aboutlesson);

        //print number of lesson
        Intent intent = getIntent();
        final int lesson = intent.getIntExtra("value", 0);
        TextView textView_numberOfLesson = findViewById(R.id.text_cislolekcie);
        textView_numberOfLesson.setText(String.valueOf(lesson));

        //print description of lesson
        List<sk.tuke.rusyn.entities.LessonInfo> lessonInfoList = db.getLessonInfo(lesson);
        StringBuilder sb = new StringBuilder();
        assert lessonInfoList != null;
        for (sk.tuke.rusyn.entities.LessonInfo lessonInfo : lessonInfoList) {
            sb.append(lessonInfo.getDescription()).append("\n");
            //Log.e("LESSON ACTIVITY", String.valueOf(sb));
        }
        fieldForDescription.setText(sb);

        LinearLayout buttons = findViewById(R.id.buttons);

        //buttons
        Button button_back = findViewById(R.id.button_spat);
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent backToMenu = new Intent(LessonInfo.this, ListOfLessons.class);
                startActivity(backToMenu);
            }
        });

        Button button_next = findViewById(R.id.button_pokracuj);
        button_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent pokracuj = new Intent(LessonInfo.this, SumActivity.class);
                pokracuj.putExtra("spravne",2);
                pokracuj.putExtra("nespravne",2);
                pokracuj.putExtra("score",0);
                pokracuj.putExtra("questionPosition",1+(int) getIntent().getExtras().get("lesson"));
                startActivity(pokracuj);
            }
        });
    }
}
