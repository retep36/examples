package sk.tuke.rusyn.questions;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.entities.Answer;
import sk.tuke.rusyn.helpers.DatabaseHelper;
import sk.tuke.rusyn.ink.InkActivity;
import sk.tuke.rusyn.screens.LessonInfo;
import sk.tuke.rusyn.screens.ListOfLessons;
import sk.tuke.rusyn.screens.Score;

public class Question extends AppCompatActivity {
    ListView simpleListView;
    private TextView cisloOtazky;
    private TextView otazka;
    private TextView popisOtazky;
    private TextView infoQuestion3;
    private TextView infoQuestion4;
    private String odpoved;
    private Button button;
    private Button button2;
    private EditText text;
    private List<Answer> answerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_base);
        simpleListView=(ListView)findViewById(R.id.simpleListView);
        button = ((Button)findViewById(R.id.buttonContinue));
        button2 = ((Button)findViewById(R.id.buttonOver));
        text = ((EditText)findViewById(R.id.dopisOdpoved));
        infoQuestion3 = ((TextView)findViewById(R.id.infoQuestion3));
        infoQuestion4 = ((TextView)findViewById(R.id.infoQuestio4));
    }

    @Override
    protected void onStart() {
        super.onStart();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        odpoved = (String) getIntent().getExtras().get("odpoved");
        final int questionCounter = (int) getIntent().getExtras().get("questionPosition");
        final int score = (int) getIntent().getExtras().get("score");

        sk.tuke.rusyn.entities.Question question = databaseHelper.getSimpleQuestionWithID(questionCounter);

        if(question.getLesson() == 1 && questionCounter == 10){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",1);
            startActivity(intent);
        }

        if(question.getLesson() == 2 && questionCounter == 23){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",2);
            startActivity(intent);
        }

        if(question.getLesson() == 3 && questionCounter == 39){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",3);
            startActivity(intent);
        }

        if(question.getLesson() == 4 && questionCounter == 56){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",4);
            startActivity(intent);
        }

        if(question.getLesson() == 5 && questionCounter == 69){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",5);
            startActivity(intent);
        }

        if(question.getLesson() == 6 && questionCounter == 86){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",6);
            startActivity(intent);
        }

        if(question.getLesson() == 7 && questionCounter == 99){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",7);
            startActivity(intent);
        }

        if(question.getLesson() == 8 && questionCounter == 111){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",8);
            startActivity(intent);
        }

        if(question.getLesson() == 9 && questionCounter == 126){
            Intent intent = new Intent(Question.this, Score.class);
            intent.putExtra("score", score);
            intent.putExtra("lesson",9);
            startActivity(intent);
        }

        //Log.e("SQL", String.valueOf(questionCounter));

        ((TextView)findViewById(R.id.numberOfQuestion)).setText(String.valueOf(question.getId()));
        ((TextView)findViewById(R.id.textQuestion)).setText(question.getQuestion());
        ((TextView)findViewById(R.id.descriptionQuestion)).setText(question.getDescription());

        if(question.getType() == 4){
            button.setVisibility(View.VISIBLE);
            button2.setVisibility(View.INVISIBLE);
            text.setVisibility(View.INVISIBLE);
            infoQuestion3.setVisibility(View.INVISIBLE);
            infoQuestion4.setVisibility(View.VISIBLE);

            final String otazka = question.getQuestion();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Question.this, InkActivity.class);
                    intent.putExtra("value",otazka);
                    intent.putExtra("score", score);
                    intent.putExtra("questionPosition", questionCounter + 1);
                    startActivity(intent);
                }
            });
        } else if (question.getType() == 3){
            answerList = databaseHelper.getAnswersList(question.getId());
            odpoved = String.valueOf(databaseHelper.getCorrectAnswer(questionCounter).getAnswers()); //
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.VISIBLE);
            text.setVisibility(View.VISIBLE);
            infoQuestion3.setVisibility(View.VISIBLE);
            infoQuestion4.setVisibility(View.INVISIBLE);
        } else {
            simpleListView.setAdapter(new CustomAdapter(score,questionCounter,getBaseContext()));
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            text.setVisibility(View.INVISIBLE);
            infoQuestion3.setVisibility(View.INVISIBLE);
            infoQuestion4.setVisibility(View.INVISIBLE);
        }
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.i("prve",text.getText().toString());
                //Log.i("druhe",answerList.get(0).getAnswers());

                if(text.getText().toString().toUpperCase().equals(answerList.get(0).getAnswers())){
                    Intent intent = new Intent(Question.this, SumActivity.class);
                    intent.putExtra("spravne",1);
                    intent.putExtra("nespravne",0);
                    intent.putExtra("odpoved", odpoved);///////
                    intent.putExtra("score",score+1);
                    intent.putExtra("questionPosition",questionCounter+1);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Question.this, SumActivity.class);
                    intent.putExtra("spravne",0);
                    intent.putExtra("nespravne",1);
                    intent.putExtra("odpoved", odpoved);///////
                    intent.putExtra("score",score);
                    intent.putExtra("questionPosition",questionCounter+1);
                    startActivity(intent);
                }
            }
        });

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
                        Intent intent = new Intent(Question.this, ListOfLessons.class);
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
