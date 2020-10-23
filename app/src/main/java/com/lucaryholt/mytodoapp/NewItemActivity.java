package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lucaryholt.mytodoapp.Model.ToDoItem;
import com.lucaryholt.mytodoapp.Repo.Repo;

public class NewItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_view);
    }

    public void save(View view){
        EditText titleEdit = findViewById(R.id.newTodoTitle);
        EditText textEdit = findViewById(R.id.newTodoText);

        Repo.r().addItem(new ToDoItem(titleEdit.getText().toString(), textEdit.getText().toString()));
        finish();
    }
}