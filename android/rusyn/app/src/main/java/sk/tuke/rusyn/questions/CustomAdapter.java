package sk.tuke.rusyn.questions;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sk.tuke.rusyn.R;
import sk.tuke.rusyn.entities.Answer;
import sk.tuke.rusyn.helpers.DatabaseHelper;

/**
 * Created by petko on 18. 3. 2018.
 */

public class CustomAdapter extends BaseAdapter {
    private static final String TAG = CustomAdapter.class.getSimpleName();
    List<Answer> listArray;
    private int lesson, score, questionCounter;
    private Context context;
    private String odpoved; //

    public CustomAdapter(int score, int questionCounter, Context context) {
        this.score = score;
        this.questionCounter = questionCounter;
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        listArray = databaseHelper.getAnswersList(questionCounter);
        odpoved = String.valueOf(databaseHelper.getCorrectAnswer(questionCounter).getAnswers()); //
        this.context = context;
    }

    @Override
    public int getCount() {
        return listArray.size();
    }

    @Override
    public Object getItem(int i) {
        return listArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int index, View view, final ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.activity_question, parent, false);
        }

        final Answer answer = listArray.get(index);
        TextView textView = (TextView) view.findViewById(R.id.textOdpoved);
        textView.setText(answer.getAnswers());
        CheckBox button = (CheckBox) view.findViewById(R.id.checkBox);
        final TextView finalText = (TextView) view.findViewById(R.id.textSkryty);
        finalText.setText(String.valueOf(answer.getCorrectAns()));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalText.getText().equals("1")) {
                    Intent intent = new Intent(context, SumActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("spravne",1);
                    intent.putExtra("nespravne",0);
                    intent.putExtra("odpoved", odpoved);//
                    intent.putExtra("lesson", lesson);
                    intent.putExtra("score", score + 1);
                    intent.putExtra("questionPosition", questionCounter + 1);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, SumActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("spravne",0);
                    intent.putExtra("nespravne",1);
                    intent.putExtra("odpoved", odpoved);//
                    intent.putExtra("lesson", lesson);
                    intent.putExtra("score", score);
                    intent.putExtra("questionPosition", questionCounter + 1);
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }
}
