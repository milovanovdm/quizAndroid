package com.example.quizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View view){
        final EditText nameText = findViewById(R.id.editName);
        String name = nameText.getText().toString();
        Intent intent = new Intent(this, QuestionsActivity.class);
        intent.putExtra(QuestionsActivity.EXTRA_MESSAGE, name);
        startActivity(intent);
    }
}
