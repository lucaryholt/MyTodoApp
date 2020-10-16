package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lucaryholt.mytodoapp.Model.ToDoItem;
import com.lucaryholt.mytodoapp.Repo.ToDoRepo;

public class NewItemActivity extends AppCompatActivity {

    private final ToDoRepo toDoRepo = ToDoRepo.getInstance();
    private EditText titleEdit;
    private EditText textEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_view);
    }

    public void save(View view){
        titleEdit = findViewById(R.id.newTodoTitle);
        textEdit = findViewById(R.id.newTodoText);

        toDoRepo.addItem(new ToDoItem(titleEdit.getText().toString(), textEdit.getText().toString()));
        finish();
    }
}