package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.lucaryholt.mytodoapp.Adapter.TodoAdapter;
import com.lucaryholt.mytodoapp.Repo.ToDoRepo;

public class MainActivity extends AppCompatActivity {

    private final ToDoRepo toDoRepo = ToDoRepo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume() { // IMPORTANT
        super.onResume();

        ListView listView = findViewById(R.id.todoListView);

        TodoAdapter todoAdapter = new TodoAdapter(this, toDoRepo.getItems(), this::onResume); // IMPORTANT - Lambda Expr
        listView.setAdapter(todoAdapter);

        listView.setOnItemClickListener((_listView, linearLayout, adapterPos, arrPos) -> {
            Intent intent = new Intent(this, DetailView.class);

            intent.putExtra("id", toDoRepo.getItem(arrPos).getId());
            intent.putExtra("title", toDoRepo.getItem(arrPos).getTitle());
            intent.putExtra("text", toDoRepo.getItem(arrPos).getText());

            startActivity(intent);
        });
    }

    public void newTodoItem(View view){
        Intent intent = new Intent(this, NewItemActivity.class);
        startActivity(intent);
    }
}