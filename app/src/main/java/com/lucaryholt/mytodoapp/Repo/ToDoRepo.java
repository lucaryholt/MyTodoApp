package com.lucaryholt.mytodoapp.Repo;

import com.lucaryholt.mytodoapp.Model.ToDoItem;

import java.util.ArrayList;

public class ToDoRepo {

    private ArrayList<ToDoItem> items = new ArrayList<>();

    public ToDoRepo() {
        instantiateTestData();
    }

    public void addItem(ToDoItem item){
        items.add(item);
    }

    public ToDoItem getItem(int index){
        return items.get(index);
    }

    public ArrayList<ToDoItem> getItems(){
        return items;
    }

    public void deleteItem(int index){
        items.remove(index);
    }

    private void instantiateTestData(){
        items.add(new ToDoItem("Vask op", "Din dovne hund"));
        items.add(new ToDoItem("Bob", "Er dit navn"));
    }
}
