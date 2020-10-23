package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lucaryholt.mytodoapp.Repo.Repo;

public class EditActivity extends AppCompatActivity {

    private String id;
    private boolean done;

    private EditText titleEdit;
    private EditText textEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        titleEdit = findViewById(R.id.editTodoTitle);
        textEdit = findViewById(R.id.editTodoText);

        id = getIntent().getStringExtra("id");
        String title = getIntent().getStringExtra("title");
        String text = getIntent().getStringExtra("text");
        done = getIntent().getBooleanExtra("done", false);

        titleEdit.setText(title);
        textEdit.setText(text);
    }

    public void save(View view){
        String title = titleEdit.getText().toString();
        String text = textEdit.getText().toString();
        Repo.r().updateItem(id, title, text, done);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}