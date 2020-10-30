package com.lucaryholt.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.lucaryholt.mytodoapp.Adapter.TodoAdapter;
import com.lucaryholt.mytodoapp.Interface.Toastable;
import com.lucaryholt.mytodoapp.Interface.Updateable;
import com.lucaryholt.mytodoapp.Model.ToDoItem;
import com.lucaryholt.mytodoapp.Repo.Repo;

public class MainActivity extends AppCompatActivity implements Updateable, Toastable {

    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.todoListView);

        todoAdapter = new TodoAdapter(this);
        listView.setAdapter(todoAdapter);

        listView.setOnItemClickListener((_listView, linearLayout, adapterPos, arrPos) -> {
            Intent intent = new Intent(this, DetailView.class);

            //System.out.println(Repo.r().getItem(arrPos));

            ToDoItem item = Repo.r().getItem(arrPos);

            intent.putExtra("id", item.getId());
            intent.putExtra("title", item.getTitle());
            intent.putExtra("text", item.getText());
            intent.putExtra("imageName", item.getImageName());
            intent.putExtra("done", item.isDone());

            startActivity(intent);
        });

        Repo.r().setActivity(this);
        Repo.r().setToastable(this);
    }

    protected void onResume() {
        update(null);
        super.onResume();
    }

    public void newTodoItem(View view){
        Intent intent = new Intent(this, NewItemActivity.class);
        startActivity(intent);
    }

    @Override
    public void update(Object o) {
        todoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}