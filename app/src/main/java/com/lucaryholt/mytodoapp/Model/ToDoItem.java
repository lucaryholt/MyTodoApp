package com.lucaryholt.mytodoapp.Model;

public class ToDoItem {

    private int id;
    private String title;
    private String text;
    private boolean done;

    public ToDoItem(String title, String text) {
        this.title = title;
        this.text = text;
        this.done = false;
    }

    public ToDoItem(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void toggleDone() {
        this.done = !done;
    }

    public boolean equals(Object o){
        if (getClass() != o.getClass())
            return false;
        ToDoItem other = (ToDoItem) o;
        return other.getId() == this.id;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", done=" + done +
                '}';
    }
}
