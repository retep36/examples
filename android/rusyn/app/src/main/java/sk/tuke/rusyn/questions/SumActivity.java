package sk.tuke.rusyn.questions;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.screens.ListOfLessons;

public class SumActivity extends AppCompatActivity {
    private int questionCounter;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        questionCounter = (int) getIntent().getExtras().get("questionPosition");
        score = (int) getIntent().getExtras().get("score");
        int spravne = (int) getIntent().getExtras().get("spravne");
        int nespravne = (int) getIntent().getExtras().get("nespravne");
        String odpoved = (String) getIntent().getExtras().get("odpoved");

        ((TextView)findViewById(R.id.textViewSkore)).setText(String.valueOf(score));
        ((TextView)findViewById(R.id.textViewPos)).setText(String.valueOf(questionCounter));
        TextView spravnaOdpoved = ((TextView) findViewById(R.id.spravnaOdpoved));
        spravnaOdpoved.setText(String.valueOf(odpoved));
        TextView textSpravne = ((TextView) findViewById(R.id.spravne));
        TextView textNespravne = ((TextView) findViewById(R.id.nespravne));
        TextView text_spravna = ((TextView) findViewById(R.id.text_spravnaOdpoved));

        if(spravne == 1 && nespravne == 0){
            textSpravne.setVisibility(View.VISIBLE);
            textNespravne.setVisibility(View.INVISIBLE);
            spravnaOdpoved.setVisibility(View.INVISIBLE);
            text_spravna.setVisibility(View.INVISIBLE);
        }
        else if(nespravne == 1 && spravne == 0) {
            textNespravne.setVisibility(View.VISIBLE);
            textSpravne.setVisibility(View.INVISIBLE);
            spravnaOdpoved.setVisibility(View.VISIBLE);
            text_spravna.setVisibility(View.VISIBLE);
        }
        else{
            textSpravne.setVisibility(View.INVISIBLE);
            textNespravne.setVisibility(View.INVISIBLE);
            spravnaOdpoved.setVisibility(View.INVISIBLE);
            text_spravna.setVisibility(View.INVISIBLE);
        }

        findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SumActivity.this, Question.class);
                intent.putExtra("score",score);
                intent.putExtra("questionPosition",questionCounter);
                startActivity(intent);
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
                        Intent intent = new Intent(SumActivity.this, ListOfLessons.class);
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
