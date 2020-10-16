package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lucaryholt.mytodoapp.Model.ToDoItem;
import com.lucaryholt.mytodoapp.Repo.ToDoRepo;

public class EditActivity extends AppCompatActivity {

    private final ToDoRepo toDoRepo = ToDoRepo.getInstance();

    private int id;

    private EditText titleEdit;
    private EditText textEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        titleEdit = findViewById(R.id.editTodoTitle);
        textEdit = findViewById(R.id.editTodoText);

        id = getIntent().getIntExtra("id", 0);
        String title = getIntent().getStringExtra("title");
        String text = getIntent().getStringExtra("text");

        titleEdit.setText(title);
        textEdit.setText(text);
    }

    public void save(View view){
        String title = titleEdit.getText().toString();
        String text = textEdit.getText().toString();
        toDoRepo.updateItem(id, title, text);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}