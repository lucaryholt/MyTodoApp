package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.lucaryholt.mytodoapp.Adapter.TodoAdapter;
import com.lucaryholt.mytodoapp.Repo.ToDoRepo;

public class MainActivity extends AppCompatActivity {

    private ToDoRepo toDoRepo = new ToDoRepo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.todoListView);
        TodoAdapter todoAdapter = new TodoAdapter(this, toDoRepo.getItems());
        listView.setAdapter(todoAdapter);
    }
}