package com.example.quizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "myName";
    TextView tv;
    Button submitButton, quitButton;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4;
    int flag = 0;
    public static int correct = 0;
    public static int wrong = 0;
    String questions[] = {
            "Вопрос 1",
            "Вопрос 2",
            "Вопрос 3",
            "Вопрос 4"
    };
    String answer[] = {"2", "3", "1", "4"};
    String opt[] = {
            "1", "2", "3", "4",
            "1", "2", "3", "4",
            "1", "2", "3", "4",
            "1", "2", "3", "4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        TextView textView = findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name = intent.getStringExtra(EXTRA_MESSAGE);
        if(name.trim().equals("")){
            textView.setText("Hello User");

        }
        else
        {
            textView.setText("Hello " + name);
        }

        submitButton = findViewById(R.id.buttonNext);
        quitButton = findViewById(R.id.buttonQuit);
        tv = findViewById(R.id.tvque);
        radioGroup = findViewById(R.id.answerGroup);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);


        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

    }


    public void onNextQuest(View view){
        if(radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Выберите один вариант ответа", Toast.LENGTH_SHORT).show();
        }
        else {
            RadioButton uAns = findViewById(radioGroup.getCheckedRadioButtonId());
            String ansText = uAns.getText().toString();
            if(ansText.equals(answer[flag])){
                correct++;
                Toast.makeText(this, "Правильный ответ", Toast.LENGTH_SHORT).show();
            }
            else{
                wrong++;
                Toast.makeText(this, "Неправильный ответ", Toast.LENGTH_SHORT).show();
            }
                flag++;
            if(flag<questions.length){
                tv.setText(questions[flag]);
                rb1.setText(opt[flag*4+0]);
                rb2.setText(opt[flag*4+1]);
                rb3.setText(opt[flag*4+2]);
                rb4.setText(opt[flag*4+3]);
            }
            else{
                Intent in = new Intent(this, ResultActivity.class);
                startActivity(in);
            }
            radioGroup.clearCheck();

        }

    }


    public void onQuit(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
