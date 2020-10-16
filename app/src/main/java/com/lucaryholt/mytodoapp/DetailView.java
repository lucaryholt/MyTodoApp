package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lucaryholt.mytodoapp.Repo.ToDoRepo;

public class DetailView extends AppCompatActivity {

    private final ToDoRepo toDoRepo = ToDoRepo.getInstance();

    private int id;
    private String titleString;
    private String textString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        TextView title = findViewById(R.id.todoItemTitleText);
        TextView text = findViewById(R.id.todoItemTextText);

        id = getIntent().getIntExtra("id", 0);
        titleString = getIntent().getStringExtra("title");
        textString = getIntent().getStringExtra("text");

        title.setText(titleString);
        text.setText(textString);
    }

    public void edit(View view){
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("title", titleString);
        intent.putExtra("text", textString);
        startActivity(intent);
    }

    public void delete(View view){
        toDoRepo.deleteItem(id);
        finish();
    }
}