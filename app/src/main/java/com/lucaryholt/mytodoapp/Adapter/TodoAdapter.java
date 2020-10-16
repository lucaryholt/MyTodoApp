package com.lucaryholt.mytodoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucaryholt.mytodoapp.Interface.Updater;
import com.lucaryholt.mytodoapp.Model.ToDoItem;
import com.lucaryholt.mytodoapp.R;

import java.util.ArrayList;

public class TodoAdapter extends BaseAdapter {

    private final ArrayList<ToDoItem> items;
    private final LayoutInflater layoutInflater;
    private final Updater updater;

    public TodoAdapter(Context context, ArrayList<ToDoItem> items, Updater doneClick) {
        this.items = items;
        layoutInflater = LayoutInflater.from(context);
        this.updater = doneClick;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = layoutInflater.inflate(R.layout.todorow, null);
        }
        TextView textView = view.findViewById(R.id.todoTextView);
        textView.setText(items.get(i).getTitle());

        ImageView imageView = view.findViewById(R.id.doneImage);
        imageView.setOnClickListener((v) -> {
            items.get(i).toggleDone();
            updater.update(); // IMPORTANT
        });
        if(items.get(i).isDone()){
            imageView.setImageResource(R.drawable.checkmark);
        }
        return view;
    }
}
