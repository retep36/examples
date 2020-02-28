package sk.tuke.rusyn.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sk.tuke.rusyn.R;

public class About extends AppCompatActivity {
    private Button spat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("Rusínsky jazyk");

        spat = findViewById(R.id.btn_spat);
        spat.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(About.this, ListOfLessons.class);
                 startActivity(intent);
             }
        });
    }
}