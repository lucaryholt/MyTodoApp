package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lucaryholt.mytodoapp.Repo.Repo;

public class DetailView extends AppCompatActivity {

    //private final ToDoRepo toDoRepo = ToDoRepo.getInstance();

    private String id;
    private String titleString;
    private String textString;
    private boolean done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        TextView title = findViewById(R.id.todoItemTitleText);
        TextView text = findViewById(R.id.todoItemTextText);

        id = getIntent().getStringExtra("id");
        titleString = getIntent().getStringExtra("title");
        textString = getIntent().getStringExtra("text");
        done = getIntent().getBooleanExtra("done", false);

        title.setText(titleString);
        text.setText(textString);
    }

    public void edit(View view){
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("title", titleString);
        intent.putExtra("text", textString);
        intent.putExtra("done", done);
        startActivity(intent);
    }

    public void delete(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Do you want to delete " + titleString + "?")
                .setPositiveButton("Yes", (dialog, id) -> {
                    Repo.r().deleteItem(this.id);
                    finish();
                })
                .setNegativeButton("No", (dialog, id) -> {
                    dialog.cancel();
                });

        AlertDialog alert = builder.create();
        alert.setTitle("Delete");
        alert.show();
    }
}