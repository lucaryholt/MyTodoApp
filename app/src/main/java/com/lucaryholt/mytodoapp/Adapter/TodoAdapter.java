package com.lucaryholt.mytodoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucaryholt.mytodoapp.Model.ToDoItem;
import com.lucaryholt.mytodoapp.R;
import com.lucaryholt.mytodoapp.Repo.Repo;

public class TodoAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;

    public TodoAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Repo.r().getItems().size();
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
        textView.setText(Repo.r().getItem(i).getTitle());

        ImageView imageView = view.findViewById(R.id.doneImage);
        imageView.setOnClickListener((v) -> {
            ToDoItem item = Repo.r().getItem(i);
            item.toggleDone();
            Repo.r().updateItem(item.getId(), item.getTitle(), item.getText(), item.isDone());
        });
        if(Repo.r().getItem(i).isDone()){
            imageView.setImageResource(R.drawable.checkmark);
            textView.setTextColor(textView.getResources().getColor(R.color.design_default_color_primary));
        }else{
            imageView.setImageResource(R.drawable.checkmarkgrey);
            textView.setTextColor(textView.getResources().getColor(R.color.design_default_color_secondary));
        }
        return view;
    }
}
