package com.lucaryholt.mytodoapp.Model;

public class ToDoItem {

    private String title;
    private String text;
    private boolean done;

    public ToDoItem(String title, String text) {
        this.title = title;
        this.text = text;
        this.done = false;
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

    public void setDone(boolean done) {
        this.done = done;
    }
}
