package com.example.quizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tv, tv2, tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.resCorrect);
        tv2 = findViewById(R.id.resWrong);
        tv3 = findViewById(R.id.resFull);

        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = new StringBuffer();
        sb.append("correct: " + QuestionsActivity.correct + '\n');
        sb2.append("Wrong: " + QuestionsActivity.wrong + '\n');
        sb3.append("Full: " + QuestionsActivity.correct + '\n');
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        QuestionsActivity.correct = 0;
        QuestionsActivity.wrong = 0;
    }

    public void onClickQuit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
