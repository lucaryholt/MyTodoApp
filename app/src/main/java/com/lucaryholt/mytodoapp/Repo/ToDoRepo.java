package com.lucaryholt.mytodoapp.Repo;

import com.lucaryholt.mytodoapp.Model.ToDoItem;

import java.util.ArrayList;

public class ToDoRepo {

    private ArrayList<ToDoItem> items = new ArrayList<>();
    private static ToDoRepo instance = new ToDoRepo();
    private int id = 0;

    private ToDoRepo() {
        instantiateTestData();
    }

    public static ToDoRepo getInstance(){
        if(instance == null){
            instance = new ToDoRepo();
        }
        return instance;
    }

    public void addItem(ToDoItem item){
        items.add(new ToDoItem(id, item.getTitle(), item.getText()));
        id++;
    }

    public ToDoItem getItem(int index){
        return items.get(index);
    }

    public ToDoItem getItem(long index){
        int i = (int) index;
        return getItem(i);
    }

    public ToDoItem getItem(ToDoItem i){
        return items.get(items.indexOf(i));
    }

    public void updateItem(int id, String title, String text){
        int i = items.indexOf(getItem(new ToDoItem(id, title, text)));
        items.get(i).setTitle(title);
        items.get(i).setText(text);
    }

    public ArrayList<ToDoItem> getItems(){
        return items;
    }

    public void deleteItem(int id){
        items.remove(getItem(new ToDoItem(id, "", "")));
    }

    // Only for tests
    private void instantiateTestData(){
        addItem(new ToDoItem("Vask op", "Din dovne hund"));
        addItem(new ToDoItem("Handle ind", "Mælk, sukker, æg - the usual"));
        items.get(1).toggleDone();
    }
}
