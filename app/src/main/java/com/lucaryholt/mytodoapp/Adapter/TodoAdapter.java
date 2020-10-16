package com.lucaryholt.mytodoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lucaryholt.mytodoapp.Model.ToDoItem;
import com.lucaryholt.mytodoapp.R;

import java.util.ArrayList;

public class TodoAdapter extends BaseAdapter {

    private ArrayList<ToDoItem> items;
    private LayoutInflater layoutInflater;

    public TodoAdapter(Context context, ArrayList<ToDoItem> items) {
        this.items = items;
        layoutInflater = LayoutInflater.from(context);
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
        textView.setText(items.get(i).getText());
        return view;
    }
}
